package mediator;

abstract class User {
    private Chat chat;
    private String name;
    private boolean isEnable = true;

    User(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }

    void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    abstract void getMessage(String message);

    boolean isEnable() {
        return isEnable;
    }

    String getName() {
        return name;
    }

    void setEnable(boolean enable) {
        isEnable = enable;
    }
}