public class DefaultTwoFactorCodeValidator implements TwoFactorCodeValidator {

    @Override
    public boolean isValidCode(String username, String twoFactorCode) {
        return true;
    }

}
