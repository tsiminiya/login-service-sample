public interface TwoFactorCodeValidator {

    default boolean isValid(String username, String twoFactorCode) {
        return true;
    }

}
