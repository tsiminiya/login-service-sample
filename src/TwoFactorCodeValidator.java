public interface TwoFactorCodeValidator {

    boolean isValid(String username, String twoFactorCode);

}
