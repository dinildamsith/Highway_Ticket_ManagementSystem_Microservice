package lk.ijse.user_service.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.user_service.convert.DataConvert;
import lk.ijse.user_service.dao.UserRepo;
import lk.ijse.user_service.dto.UserDTO;
import lk.ijse.user_service.service.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class UserServiceIMPL implements UserServices {

    @Autowired
    UserRepo userRepo;

    @Autowired
    DataConvert dataConvert;

    Logger logger = LoggerFactory.getLogger(UserServiceIMPL.class);

    @Override
    public void saveUser(UserDTO userDTO) {

        if (userRepo.existsById(userDTO.getUserId())){
            logger.info("This Id Have User");
        }else{
            userRepo.save(dataConvert.userDTOConvertUserEntity(userDTO));
        }

    }

    @Override
    public void updateUser(String updateUserId ,UserDTO userDTO) {

    }

    @Override
    public void deleteUser(String deleteUserId) {

    }
}
