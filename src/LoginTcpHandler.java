import java.io.*;
import java.net.Socket;

public class LoginTcpHandler implements Runnable {

    private final LoginService loginService;

    private final Socket socket;

    private final InputStream inputStream;
    private final InputStreamReader inputStreamReader;
    private final BufferedReader bufferedReader;

    private final OutputStream outputStream;
    private final PrintWriter printWriter;

    public LoginTcpHandler(Socket socket, LoginService loginService) {
        this.loginService = loginService;

        this.socket = socket;

        try {
            inputStream = socket.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);

            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(outputStream, true);
        } catch (IOException e) {
            throw new RuntimeException("Cannot initiate I/O access");
        }
    }

    @Override
    public void run() {
        printWriter.println("Enter username and password in this format:");
        printWriter.println("<username>|<password>");

        String input = getInput();
        if (input.isEmpty()) {
            printWriter.println("Unauthorized");
        } else {
            String[] usernamePassword = input.split("\\|");
            String token = loginService.login(usernamePassword[0], usernamePassword[1]);
            if (token == null) {
                printWriter.println("Unauthorized");
            } else {
                printWriter.println("Token: " + token);
            }
        }

        try {
            terminateAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getInput() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            return "";
        }
    }

    private void terminateAll() throws IOException {
        if (printWriter != null) printWriter.close();
        if (outputStream != null) outputStream.close();

        if (bufferedReader != null) bufferedReader.close();
        if (inputStreamReader != null) inputStreamReader.close();
        if (inputStream != null) inputStream.close();

        socket.close();
    }
}
