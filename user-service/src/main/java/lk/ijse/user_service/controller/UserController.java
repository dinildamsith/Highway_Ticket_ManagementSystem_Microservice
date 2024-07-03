package lk.ijse.user_service.controller;

import jakarta.validation.Valid;
import lk.ijse.user_service.dto.UserDTO;
import lk.ijse.user_service.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public String userSave( @RequestBody  UserDTO userDTO){
        String resp = userServices.saveUser(userDTO);
        return resp;
    }

    @PutMapping
    @RequestMapping("/update/{updateUserId}")
    public String userUpdate(@PathVariable("updateUserId") String updateUserId ,@RequestBody UserDTO userDTO){
        String resp = userServices.updateUser(updateUserId,userDTO);
        return resp;
    }

    @DeleteMapping
    @RequestMapping("/delete/{deleteUserId}")
    public String userDelete(@PathVariable ("deleteUserId") String deleteUserId){
        String resp = userServices.deleteUser(deleteUserId);
        return resp;
    }
}