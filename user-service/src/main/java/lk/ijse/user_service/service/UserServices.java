package lk.ijse.user_service.service;

import lk.ijse.user_service.dto.UserDTO;

public interface UserServices {
    String saveUser(UserDTO userDTO);
    String updateUser(String updateUserId , UserDTO userDTO);
    String deleteUser(String deleteUserId);
}
