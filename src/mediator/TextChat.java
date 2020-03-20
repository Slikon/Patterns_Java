package mediator;

import java.util.ArrayList;
import java.util.List;

public class TextChat implements Chat {
    private User admin;
    private List<User> users = new ArrayList<>();

    void addUser(User user) {
        if (admin == null) {
            throw new RuntimeException("no admin");
        }

        if (user instanceof SimpleUser) {
            users.add(user);
        } else {
            throw new RuntimeException("cannot enter another chat");
        }
    }

    void setAdmin(User admin) {
        if (admin instanceof Admin) {
            this.admin = admin;
        } else {
            throw new RuntimeException("don't have enough rights");
        }
    }

    @Override
    public void sendMessage(String message, User user) {
        if (user instanceof Admin) {
            for (User u : users) {
                u.getMessage(user.getName() + ": " + message);
            }
        }

        if (user instanceof SimpleUser) {
            for (User u : users) {
                if (u != user && u.isEnable()) {
                    u.getMessage(user.getName() + ": " + message);
                }
            }

            if (admin.isEnable()) {
                admin.getMessage(user.getName() + ": " + message);
            }
        }
    }
}