package pl.jakub.orderorganizer.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import pl.jakub.orderorganizer.model.user.UserRole;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
public class SecurityHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        String redirectUrl = "";
        if(roles.contains("ROLE_"+ UserRole.USER_SERVICE.getName())){
            redirectUrl = "/service/";
        }
        if(roles.contains("ROLE_"+UserRole.ADMIN.getName())) {
            redirectUrl = "/users/admin";
        }
        if (roles.contains("ROLE_"+UserRole.USER_COOK.getName())) {
            redirectUrl = "/users/cook";
        }
        new DefaultRedirectStrategy().sendRedirect(httpServletRequest, httpServletResponse, redirectUrl);
    }
}
