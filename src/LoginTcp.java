import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginTcp {

    private final LoginServiceWith2Factor loginService;

    public LoginTcp(LoginServiceWith2Factor loginService) {
        this.loginService = loginService;
    }

    public void execute() {
        try (ServerSocket serverSocket = new ServerSocket(3300)) {
            do {
                Socket socket = serverSocket.accept();
                LoginTcpHandler loginTcpHandler = new LoginTcpHandler(socket, loginService);
                Thread thread = new Thread(loginTcpHandler);
                thread.start();
            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
