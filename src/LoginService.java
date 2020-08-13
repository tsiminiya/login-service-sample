public interface LoginService {

    String login(String username, String password);

    default String login(String username, String password, String twoFactorCode) {
        return null;
    }

}
