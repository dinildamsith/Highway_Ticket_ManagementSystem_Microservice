package lk.ijse.user_service.controller;

import lk.ijse.user_service.dto.UserDTO;
import lk.ijse.user_service.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void userSave(@RequestBody  UserDTO userDTO){
        userServices.saveUser(userDTO);
    }

    @PutMapping
    @RequestMapping("/update/{updateUserId}")
    public void userUpdate(@PathVariable("updateUserId") String updateUserId ,@RequestBody UserDTO userDTO){
        userServices.updateUser(updateUserId,userDTO);
    }

    @DeleteMapping
    @RequestMapping("/delete/{deleteUserId}")
    public void userDelete(@PathVariable ("deleteUserId") String deleteUserId){
        userServices.deleteUser(deleteUserId);
    }
}