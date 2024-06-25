package lk.ijse.user_service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @PostMapping
    public void healthChecking() {
        System.out.println("User Worked...");
    }
}