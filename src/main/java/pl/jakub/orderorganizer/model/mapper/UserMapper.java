package pl.jakub.orderorganizer.model.mapper;

import lombok.RequiredArgsConstructor;
import pl.jakub.orderorganizer.model.cook.Cook;
import pl.jakub.orderorganizer.dto.UserDto;
import pl.jakub.orderorganizer.model.service.Service;
import pl.jakub.orderorganizer.model.user.User;
import pl.jakub.orderorganizer.model.user.UserRole;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class UserMapper {

    public UserDto mapToApi(User user) {
        if (user.getCookId() != null && user.getServiceId() != null) {
            return new UserDto(user.getId(), user.getLogin(), user.getPassword(), UserRole.valueOf(user.getRole()),
                    user.getServiceId().getId(), user.getCookId().getId());
        }
        else if(user.getCookId() != null) {
            return new UserDto(user.getId(), user.getLogin(), user.getPassword(), UserRole.valueOf(user.getRole()),
                    null, user.getCookId().getId());
        }
        else {
            return new UserDto(user.getId(), user.getLogin(), user.getPassword(), UserRole.valueOf(user.getRole()),
                    null, null);
        }
    }

    public User mapToEntity(UserDto userDto, Cook cook, Service service) {
        return new User(null, userDto.getLogin(), userDto.getPassword(), userDto.getRole().getName(), null, null);
    }


}
