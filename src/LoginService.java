public interface LoginService {

    String login(String username, String password);

    static boolean passwordsMatched(String password1, String password2) {
        if (isBlank(password1) || isBlank(password2)) {
            return false;
        }
        return password1.equals(password2);
    }

    static boolean isBlank(String password) {
        return password == null || password.isEmpty();
    }

}
