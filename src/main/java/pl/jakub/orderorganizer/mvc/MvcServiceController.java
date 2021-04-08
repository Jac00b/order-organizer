package pl.jakub.orderorganizer.mvc;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/service")
public class MvcServiceController {

    @GetMapping("/")
    @PreAuthorize("hasRole('ROLE_USER_SERVICE')")
    String showServicePanel() {
        return "service.html";
    }

}
