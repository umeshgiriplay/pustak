package edu.sunway.pustak.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

@RestController
@RequestMapping("/api/v1")
public class HomeController {

    public static final String BASE_URL = "/api/v1";

    @GetMapping("/home")
    public String index()
    {
        return "WOrking!!!";
    }

    @GetMapping("/user/me")
    public Principal user(Principal principal) {
        return principal;
    }
}

