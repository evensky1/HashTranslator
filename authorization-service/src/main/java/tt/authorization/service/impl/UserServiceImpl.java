package tt.authorization.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tt.authorization.entity.User;
import tt.authorization.repository.UserRepository;
import tt.authorization.service.UserService;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void register(User user) {
        userRepository.save(user);
    }
}
