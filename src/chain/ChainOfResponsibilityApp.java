package chain;

class ChainOfResponsibilityApp {
    public static void main(String[] args) {
        SMSLogger smsLogger = new SMSLogger(Level.ERROR);
        FileLogger fileLogger = new FileLogger(Level.DEBUG);

        smsLogger.setNext(fileLogger);

        smsLogger.writeMessage("OK", Level.INFO);
        smsLogger.writeMessage("DEBUG", Level.DEBUG);
        smsLogger.writeMessage("ERROR", Level.ERROR);
    }
}
abstract class Logger {
    private int priority;
    private Logger next;

    Logger(int priority) {
        this.priority = priority;
    }

    void writeMessage(String message, int level) {
        if (level <= priority) {
            System.out.println(message);
        }

        if (next != null) {
            next.writeMessage(message, level);
        }
    }

    abstract void write(String message);

    void setNext(Logger next) {
        this.next = next;
    }
}

class SMSLogger extends Logger {
    SMSLogger(int priority) {
        super(priority);
    }

    @Override
    void write(String message) {
        System.out.println(message);
    }
}

interface Level {
    int ERROR = 1;
    int DEBUG = 2;
    int INFO = 3;
}

class FileLogger extends Logger {
    FileLogger(int priority) {
        super(priority);
    }

    @Override
    void write(String message) {
        System.out.println(message);
    }
}