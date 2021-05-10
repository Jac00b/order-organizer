package pl.jakub.orderorganizer.mvc;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.jakub.orderorganizer.dto.ServiceDto;
import pl.jakub.orderorganizer.dto.UserDto;
import pl.jakub.orderorganizer.model.service.Service;
import pl.jakub.orderorganizer.model.user.User;
import pl.jakub.orderorganizer.services.ServiceService;
import pl.jakub.orderorganizer.services.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/service")
public class MvcServiceController {
    private final UserService userService;
    private final ServiceService serviceService;

    public MvcServiceController(UserService userService, ServiceService service) {
        this.userService = userService;
        this.serviceService = service;
    }


    @GetMapping("/panel")
    @PreAuthorize("hasRole('ROLE_USER_SERVICE')")
    ModelAndView showServicePanel(Model model) {
        ModelAndView mav = new ModelAndView("service.html");
        String name = getUsername();
        UserDto user = userService.getByLogin(name);
        Long serviceId = user.getServiceId();
        model.addAttribute("service", serviceService.getById(serviceId));
        return mav;
    }

    private static String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}
