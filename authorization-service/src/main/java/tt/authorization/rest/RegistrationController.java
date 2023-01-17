package tt.authorization.rest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tt.authorization.dto.UserDto;
import tt.authorization.entity.User;
import tt.authorization.service.UserService;

@Slf4j
@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
public class RegistrationController {

    private final UserService userService;
    private final ConversionService conversionService;

    @PostMapping
    public UserDto registerUser(@RequestBody UserDto userDto) {
        log.info("new user registration {}", userDto);

        var user = conversionService.convert(userDto, User.class);
        var registeredUser = userService.register(user);

        return conversionService.convert(registeredUser, UserDto.class);
    }
}
