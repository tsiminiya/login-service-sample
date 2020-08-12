public class LoginTcpMain {

    public static void main(String[] args) {
        LoginService loginService = new LoginServiceImpl(new UserGatewayImpl(), new DefaultTokenGenerator());
        LoginTcp loginTcp = new LoginTcp(loginService);
        loginTcp.execute();
    }

}
