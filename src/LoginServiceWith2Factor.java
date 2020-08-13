public interface LoginServiceWith2Factor extends LoginService {

    String login(String username, String password, String twoFactorCode);

}
