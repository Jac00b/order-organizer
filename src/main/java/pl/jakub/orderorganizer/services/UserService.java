package pl.jakub.orderorganizer.services;

import org.springframework.security.acls.model.AlreadyExistsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.jakub.orderorganizer.dto.UserDto;
import pl.jakub.orderorganizer.model.user.User;
import pl.jakub.orderorganizer.model.user.UserRole;
import pl.jakub.orderorganizer.repository.CookRepository;
import pl.jakub.orderorganizer.repository.ServiceRepository;
import pl.jakub.orderorganizer.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ServiceRepository serviceRepository;
    private final CookRepository cookRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, ServiceRepository serviceRepository, CookRepository cookRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.serviceRepository = serviceRepository;
        this.cookRepository = cookRepository;
    }

    public void createUserAsService(UserDto userDto, Long serviceId) {
    Optional<User> userByLogin = userRepository.findByLogin(userDto.getLogin());
    if (userByLogin.isPresent()){
        throw new AlreadyExistsException("Użytkownik o podanym loginie już istnieje");
    } else {
        User user = User.builder()
                .login(userDto.getLogin())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .role(UserRole.USER_SERVICE.getName())
                .serviceId(serviceRepository.findServiceById(serviceId).get())
                .build();
        userRepository.save(user);
    }
}

public void createUserAsCook(UserDto userDto, Long cookId){
        Optional<User> userByLogin = userRepository.findByLogin(userDto.getLogin());
        if (userByLogin.isPresent()){
            throw new AlreadyExistsException("Użytkownik o podanym loginie już istnieje");
        } else {
            User user = User.builder()
                    .login(userDto.getLogin())
                    .password(passwordEncoder.encode(userDto.getPassword()))
                    .role(UserRole.USER_COOK.getName())
                    .cookId(cookRepository.findCookById(cookId).get())
                    .build();
            userRepository.save(user);
        }
}


}
