public interface LoginService {

    default String login(String username, String password) {
        User user = getUserGateway().getUser(username);
        if (user.getPassword().equals(password)) {
            return getTokenGenerator().generateToken();
        }
        return null;
    }

    UserGateway getUserGateway();

    TokenGenerator getTokenGenerator();

}
