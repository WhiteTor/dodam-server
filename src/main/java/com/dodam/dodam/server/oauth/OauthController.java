package com.dodam.dodam.server.oauth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/oauth2", produces = "application/json")
public class OauthController {

    LoginService loginService;

    public void LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/code/{registrationId}")
    public void googleLogin(@RequestParam String code, @PathVariable String registrationId) {
        loginService.socialLogin(code, registrationId);
    }


}
