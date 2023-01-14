package tt.authorization.dto.converter;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import tt.authorization.dto.UserDto;
import tt.authorization.entity.User;

@AllArgsConstructor
@Component
public class UserDtoToUserConverter implements Converter<UserDto, User> {

    private final ModelMapper modelMapper;

    @Override
    public User convert(UserDto source) {
        return modelMapper.map(source, User.class);
    }
}
