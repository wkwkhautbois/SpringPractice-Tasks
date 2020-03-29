package dev.wkwk.tasks.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @PreAuthorize("hasRole('Users')")
    @GetMapping("/abc")
    public String abc() {
        return "abc";
    }

    @PreAuthorize("hasRole('Users')")
    @ResponseBody
    @GetMapping("/token")
    public Object token(HttpServletRequest request) {
        final CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        Object ret = new Object() {
            public String header = "X-CSRF-TOKEN";
            public String value = csrf.getToken();
        };
        return ret;
    };
}
