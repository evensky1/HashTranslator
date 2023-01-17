package tt.authorization.config;

public class Queries {

    public static final String USERS_BY_USERNAME
        = "SELECT username, password, enabled FROM users WHERE username = ?";
    public static final String AUTHORITIES_BY_USERNAME
        = "SELECT u.username, ur.roles FROM users u "
        + "INNER JOIN user_role ur ON u.id = ur.user_id "
        + "WHERE u.username = ?";

    private Queries() {
        throw new AssertionError("Utility class");
    }
}
