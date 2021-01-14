package com.marcelsauter.aycuserservice.service;

import com.ayc.keycloaksecurity.util.SecurityUtil;
import com.marcelsauter.aycuserservice.model.UserEntity;
import com.marcelsauter.aycuserservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private SecurityUtil securityUtil;

    @Autowired
    private UserRepository userRepository;

    public UserEntity saveUserData(UserEntity userData) {
        userData.setUsername(this.securityUtil.getUsername());

        return this.userRepository.save(userData);
    }
}
