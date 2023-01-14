package tt.authorization.rest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tt.authorization.dto.UserDto;
import tt.authorization.entity.User;
import tt.authorization.service.UserService;

@Slf4j
@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final ConversionService conversionService;

    @PostMapping
    public ResponseEntity<Void> registerUser(@RequestBody UserDto userDto) {
        log.info("new user registration {}", userDto);

        var user = conversionService.convert(userDto, User.class);
        userService.register(user);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
