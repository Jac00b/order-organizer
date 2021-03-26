package pl.jakub.orderorganizer.mvc;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class MvcUserController {
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    String showAdminPanel() {
        return "admin.html";
    }
}
