public class LoginServiceImpl implements LoginService {

    private final UserGateway userGateway;
    private final TokenGenerator tokenGenerator;

    public LoginServiceImpl(UserGateway userGateway,
                            TokenGenerator tokenGenerator) {
        this.userGateway = userGateway;
        this.tokenGenerator = tokenGenerator;
    }

    @Override
    public String login(String username, String password) {
        User user = userGateway.getUser(username);
        if (user.getPassword().equals(password)) {
            return tokenGenerator.generateToken();
        }
        return null;
    }

}
