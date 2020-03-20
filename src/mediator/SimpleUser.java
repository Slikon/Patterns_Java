package mediator;

class SimpleUser extends User {
    SimpleUser(Chat chat, String name) {
        super(chat, name);
    }

    @Override
    void getMessage(String message) {
        System.out.println("User " + getName() + " got message: " + message);
    }
}