public interface TwoFactorCodeValidator {

    boolean isValidCode(String username, String twoFactorCode);

}
