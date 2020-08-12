public class LoginServiceImpl implements LoginService {

    private final UserGateway userGateway;
    private final TokenGenerator tokenGenerator;
    private final TwoFactorCodeValidator twoFactorCodeValidator;

    public LoginServiceImpl(UserGateway userGateway,
                            TokenGenerator tokenGenerator,
                            TwoFactorCodeValidator twoFactorCodeValidator) {
        this.userGateway = userGateway;
        this.tokenGenerator = tokenGenerator;
        this.twoFactorCodeValidator = twoFactorCodeValidator;
    }

    @Override
    public String login(String username, String password, String twoFactorCode) {
        User user = userGateway.getUser(username);
        if (user.getPassword().equals(password) &&
                twoFactorCodeValidator.isValidCode(username, twoFactorCode)) {
            return tokenGenerator.generateToken();
        }
        return null;
    }

}
