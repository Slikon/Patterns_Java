package command;

public class CommandApp {
    public static void main(String[] args) {
        Comp comp = new Comp();
        User u = new User(new StartCommand(comp),new StopCommand(comp),new ResetCommand(comp));

        u.startComp();
        u.stopComp();
        u.resetComp();
    }
}

interface Command{
    void execute();
}

class Comp{
    void start(){
        System.out.println("Start");
    }
    void stop(){
        System.out.println("Stop");
    }
    void reset(){
        System.out.println("Reset");
    }
}

class StartCommand implements Command{
    Comp comp;

    public StartCommand(Comp comp) {
        this.comp = comp;
    }

    @Override
    public void execute() {
        comp.start();
    }
}
class StopCommand implements Command{
    Comp comp;

    public StopCommand(Comp comp) {
        this.comp = comp;
    }

    @Override
    public void execute() {
        comp.stop();
    }
}
class ResetCommand implements Command{
    Comp comp;

    public ResetCommand(Comp comp) {
        this.comp = comp;
    }

    @Override
    public void execute() {
        comp.reset();
    }
}

class User{
    Command start;
    Command stop;
    Command reset;

    public User(Command start, Command stop, Command reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }

    void startComp(){
        start.execute();
    }
    void stopComp(){
        stop.execute();
    }
    void resetComp(){
        reset.execute();
    }
}