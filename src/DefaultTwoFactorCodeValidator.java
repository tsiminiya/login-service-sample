public class DefaultTwoFactorCodeValidator implements TwoFactorCodeValidator {

    @Override
    public boolean isValid(String username, String twoFactorCode) {
        return true;
    }

}
