import java.util.UUID;

public class DefaultTokenGenerator implements TokenGenerator {

    @Override
    public String generateToken() {
        return UUID.randomUUID().toString();
    }

}
