package edu.sunway.pustak.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class HomeController {

    @ResponseBody
    @RequestMapping(method = POST,path = "/home")
    public String index()
    {
        return "WOrking!!!";
    }

    @GetMapping("/user/me")
    public Principal user(Principal principal) {
        return principal;
    }
}

