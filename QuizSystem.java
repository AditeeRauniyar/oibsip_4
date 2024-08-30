import java.util.HashMap;
import java.util.Map;

public class QuizSystem {
    private Map<String, User> users;

    public QuizSystem() {
        users = new HashMap<>();
    }

    public void addUser(String userId, String password) {
        users.put(userId, new User(userId, password));
    }

    public User authenticateUser(String userId, String password) {
        User user = users.get(userId);
        if (user != null && user.getPassword().equals(password)) {
            user.setLoggedIn(true);
            return user;
        }
        return null;
    }

    public void updatePassword(User user, String newPassword) {
        if (user != null) {
            user.setPassword(newPassword);
        }
    }

    public void logout(User user) {
        if (user != null) {
            user.setLoggedIn(false);
        }
    }
}

