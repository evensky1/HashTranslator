package tt.authorization.dto.converter;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import tt.authorization.dto.UserDto;
import tt.authorization.entity.User;

@AllArgsConstructor
@Component
public class UserToUserDtoConverter implements Converter<User, UserDto> {

    private final ModelMapper modelMapper;

    @Override
    public UserDto convert(User source) {
        return modelMapper.map(source, UserDto.class);
    }
}
