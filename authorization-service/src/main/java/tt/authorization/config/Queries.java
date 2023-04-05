package tt.authorization.config;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Queries {

    public final String USERS_BY_USERNAME
        = "SELECT username, password, enabled FROM users WHERE username = ?";
    public final String AUTHORITIES_BY_USERNAME
        = "SELECT u.username, ur.roles FROM users u "
        + "INNER JOIN user_role ur ON u.id = ur.user_id "
        + "WHERE u.username = ?";
}
