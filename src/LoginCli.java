import java.util.NoSuchElementException;
import java.util.Scanner;

public class LoginCli {

    private final LoginServiceWith2Factor loginService;
    private final Scanner inputScanner = new Scanner(System.in);

    public LoginCli(LoginServiceWith2Factor loginService) {
        this.loginService = loginService;
    }

    public void execute() {
        String username = promptForField("Username");
        String password = promptForField("Password");
        String twoFactorCode = promptForField("Two-Factor Code");

        String token = loginService.login(username, password, twoFactorCode);
        if (token == null) {
            System.out.println("Unauthorized");
        } else {
            System.out.println("Token: " + token);
        }
    }

    private String promptForField(String fieldName) {
        String inputValue;

        do {
            System.out.print(fieldName + ": ");
            inputValue = getInputValue(inputScanner);
        } while (inputValue.isEmpty());

        return inputValue;
    }

    private String getInputValue(Scanner inputScanner) {
        try {
            return inputScanner.nextLine();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    @Override
    protected void finalize() throws Throwable {
        inputScanner.close();
    }

}
