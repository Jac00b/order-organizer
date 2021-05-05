package pl.jakub.orderorganizer.mvc;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.acls.model.AlreadyExistsException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.jakub.orderorganizer.dto.CookDto;
import pl.jakub.orderorganizer.dto.ServiceDto;
import pl.jakub.orderorganizer.dto.UserDto;
import pl.jakub.orderorganizer.model.service.CookWithCredencials;
import pl.jakub.orderorganizer.model.service.ServiceWithCredencials;
import pl.jakub.orderorganizer.services.CookService;
import pl.jakub.orderorganizer.services.ServiceService;
import pl.jakub.orderorganizer.services.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class MvcUserController {

    private final ServiceService serviceService;
    private final UserService userService;
    private final CookService cookService;

    public MvcUserController(ServiceService service, UserService userService, CookService cookService) {
        this.serviceService = service;
        this.userService = userService;
        this.cookService = cookService;
    }


    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    String showAdminPanel() {
        return "admin.html";
    }

    @GetMapping("/admin/createService")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    ModelAndView addServicePage() {
        ModelAndView mav = new ModelAndView();
       mav.setViewName("createService.html");
       mav.addObject("service", new ServiceWithCredencials());
       mav.addObject("isAdmin", true);
        return mav;
    }

    @PostMapping("/admin/createService")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    String addNewService(@Valid @ModelAttribute("service") ServiceWithCredencials service, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "createService.html";
        }
        try {
            ServiceDto serviceToCreate = new ServiceDto(null, service.getFirstName(), service.getLastName());
            Long serviceId = serviceService.createService(serviceToCreate);
            UserDto userDto = UserDto.builder()
                    .login(service.getLogin())
                    .password(service.getPassword())
                    .build();
            userService.createUserAsService(userDto, serviceId);
            return "redirect:/users/admin";

        } catch (AlreadyExistsException e) {
            bindingResult.rejectValue("login", "service.error", e.getMessage());
            service.setLogin("");
            return "createService.html";
        }
    }

    @GetMapping("/admin/createCook")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    ModelAndView addCookPage(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("createCook.html");
        mav.addObject("cook", new CookWithCredencials());
        mav.addObject("isAdmin", true);
        return mav;
    }

    @PostMapping("/admin/createCook")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    String addNewCook(@Valid @ModelAttribute("cook") CookWithCredencials cook, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "createCook.html";
        }

        try {
            CookDto cookToCreate = new CookDto(null, cook.getFirstName(), cook.getLastName());
            Long cookId = cookService.createCook(cookToCreate);
            UserDto userDto = UserDto.builder()
                    .login(cook.getLogin())
                    .password(cook.getPassword())
                    .build();
            userService.createUserAsCook(userDto, cookId);
            return "redirect:/users/admin";

        } catch (AlreadyExistsException e) {
            bindingResult.rejectValue("login", "cook.error", e.getMessage());
            cook.setLogin("");
            return "createCook.html";
        }
    }


}
