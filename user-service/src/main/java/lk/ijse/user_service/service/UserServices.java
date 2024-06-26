package lk.ijse.user_service.service;

import lk.ijse.user_service.dto.UserDTO;

public interface UserServices {
    void saveUser(UserDTO userDTO);
    void updateUser(UserDTO userDTO);
    void deleteUser(UserDTO userDTO);
}
