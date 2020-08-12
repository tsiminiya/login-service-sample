public class LoginCliMain {

    public static void main(String[] args) {
        LoginService loginService = new LoginServiceImpl(new UserGatewayImpl(),
                new DefaultTokenGenerator(), new DefaultTwoFactorCodeValidator());
        LoginCli loginCli = new LoginCli(loginService);
        loginCli.execute();
    }

}
