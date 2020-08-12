public class UserGatewayImpl implements UserGateway {

    @Override
    public User getUser(String username) {
        // Don't do this at home. LOL!
        User user = new User();
        user.setUsername(username);
        user.setPassword("abc123");
        return user;
    }

}
