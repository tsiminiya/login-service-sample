public class LoginCliMain {

    public static void main(String[] args) {
        LoginServiceWith2Factor loginService = new LoginServiceImpl(new UserGatewayImpl(),
                new DefaultTokenGenerator(), new DefaultTwoFactorCodeValidator());
        LoginCli loginCli = new LoginCli(loginService);
        loginCli.execute();
    }

}
