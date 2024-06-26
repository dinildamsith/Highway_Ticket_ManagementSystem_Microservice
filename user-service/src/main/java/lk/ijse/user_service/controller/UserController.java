package lk.ijse.user_service.controller;

import lk.ijse.user_service.dto.UserDTO;
import lk.ijse.user_service.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/userService")
public class UserController {

    @Autowired
    UserServices userServices;

    @PostMapping
    public void healthChecking() {
        System.out.println("User Worked...");
    }

    @PostMapping
    @RequestMapping("/save")
    public void userSave(@RequestBody  UserDTO userDTO){
        userServices.saveUser(userDTO);
    }
}