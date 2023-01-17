package tt.authorization.service.impl;

import java.util.Collections;
import java.util.HashSet;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tt.authorization.entity.Role;
import tt.authorization.entity.User;
import tt.authorization.error.factory.exception.UserAlreadyExistsException;
import tt.authorization.repository.UserRepository;
import tt.authorization.service.UserService;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User register(User user) {
        userRepository.findByUsername(user.getUsername())
            .ifPresent(u -> {
                throw new UserAlreadyExistsException(
                    "User \"" + u.getUsername() + "\" already exists");
            });

        var newUser = User.builder()
            .enabled(true)
            .username(user.getUsername())
            .password(passwordEncoder.encode(user.getPassword()))
            .roles(Collections.singleton(Role.USER))
            .build();

        return userRepository.save(newUser);
    }
}
