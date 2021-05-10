package pl.jakub.orderorganizer.model.mapper;

import lombok.RequiredArgsConstructor;
import pl.jakub.orderorganizer.model.cook.Cook;
import pl.jakub.orderorganizer.model.service.Service;
import pl.jakub.orderorganizer.model.user.User;
import pl.jakub.orderorganizer.model.user.UserRole;
import pl.jakub.orderorganizer.dto.*;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class UserMapper {

    public UserDto mapToApi(User user) {
        if (user.getCook() != null && user.getService() != null) {
            return new UserDto(user.getId(), user.getLogin(), user.getPassword(), UserRole.valueOf(user.getRole()),
                    user.getService().getId(), user.getCook().getId());
        }
        else if(user.getCook() != null) {
            return new UserDto(user.getId(), user.getLogin(), user.getPassword(), UserRole.valueOf(user.getRole()),
                    null, user.getCook().getId());
        }
        else {
            return new UserDto(user.getId(), user.getLogin(), user.getPassword(), UserRole.valueOf(user.getRole()),
                    user.getService().getId(), null);
        }
    }

    public User mapToEntity(UserDto userDto, Cook cook, Service service) {
        return new User(null, userDto.getLogin(), userDto.getPassword(), userDto.getRole().getName(), null, null);
    }


}
