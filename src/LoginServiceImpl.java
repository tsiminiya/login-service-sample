public class LoginServiceImpl implements LoginService {

    private final UserGateway userGateway;
    private final TokenGenerator tokenGenerator;

    public LoginServiceImpl(UserGateway userGateway,
                            TokenGenerator tokenGenerator) {
        this.userGateway = userGateway;
        this.tokenGenerator = tokenGenerator;
    }

    @Override
    public UserGateway getUserGateway() {
        return userGateway;
    }

    @Override
    public TokenGenerator getTokenGenerator() {
        return tokenGenerator;
    }
}
