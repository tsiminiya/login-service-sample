public class LoginServiceImpl implements LoginService {

    private final UserGateway userGateway;
    private final TokenGenerator tokenGenerator;
    private final TwoFactorCodeValidator twoFactorCodeValidator;

    public LoginServiceImpl(UserGateway userGateway,
                            TokenGenerator tokenGenerator) {
        this.userGateway = userGateway;
        this.tokenGenerator = tokenGenerator;
        twoFactorCodeValidator = new DefaultTwoFactorCodeValidator();
    }

    @Override
    public String login(String username, String password) {
        User user = userGateway.getUser(username);
        if (user.getPassword().equals(password)) {
            return tokenGenerator.generateToken();
        }
        return null;
    }

    @Override
    public String login(String username, String password, String twoFactorCode) {
        String token = login(username, password);
        if (twoFactorCodeValidator.isValid(username, twoFactorCode)) {
            return token;
        }
        return null;
    }

}
