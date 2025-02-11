package Task_1;

import java.util.HashMap;
import java.util.Map;

public class UserDatabase {
    private final Map<String, User> users = new HashMap<>();

    public void addUser(String login, String password)
            throws IllegalArgumentException {
        if (users.containsKey(login))
            throw new IllegalArgumentException("Користувач з таким логіном вже існує!");
        users.put(login, new User(login, password));
    }

    public void removeUser(String login) {
        if (users.remove(login) == null)
            throw new IllegalArgumentException("Користувача не знайдено!");
    }

    public boolean userExists(String login) {
        return users.containsKey(login);
    }

    public void updateLogin(String oldLogin, String newLogin) {
        if (!users.containsKey(oldLogin))
            throw new IllegalArgumentException("Старий логін не існує!");
        if (users.containsKey(newLogin))
            throw new IllegalArgumentException("Новий логін вже зайнятий!");

        User user = users.get(oldLogin);
        user.setLogin(newLogin);
        users.remove(oldLogin);
        users.put(newLogin, user);
    }

    public void updatePassword(String login, String newPassword) {
        if (!users.containsKey(login))
            throw new IllegalArgumentException("Користувача не знайдено!");
        users.get(login).setPassword(newPassword);
    }
}
