package mediator;

class Main {
    public static void main(String[] args) {
        TextChat chat = new TextChat();

        User admin = new Admin(chat, "ADMIN Vasya");
        User user1 = new SimpleUser(chat, "User1 Petya");
        User user2 = new SimpleUser(chat, "User2 Kolya");

        user1.setEnable(false);

        chat.setAdmin(admin);
        chat.addUser(user1);
        chat.addUser(user2);

        user1.sendMessage("user1 message");
    }
}