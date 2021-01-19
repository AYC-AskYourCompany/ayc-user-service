package com.marcelsauter.aycuserservice.service;

import com.ayc.exceptionhandler.exception.EntityNotFoundException;
import com.ayc.exceptionhandler.exception.NotAuthorizedException;
import com.ayc.keycloaksecurity.util.SecurityUtil;
import com.marcelsauter.aycuserservice.consts.ErrorConst;
import com.marcelsauter.aycuserservice.model.UserEntity;
import com.marcelsauter.aycuserservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private SecurityUtil securityUtil;

    @Autowired
    private UserRepository userRepository;

    public UserEntity getUserData() throws EntityNotFoundException {
        return this.findUser(this.securityUtil.getUsername());
    }

    public UserEntity getUserDataByUsername(String username) throws EntityNotFoundException, NotAuthorizedException {
        this.securityUtil.isAdminOrUser(username);

        return this.findUser(username);
    }

    public UserEntity saveUserData(UserEntity userData) {
        Optional<UserEntity> user = this.userRepository.findById(this.securityUtil.getUsername());

        if (user.isPresent()) {
            userData.setOptionalData(user.get().getOptionalData());
        }
        userData.setUsername(this.securityUtil.getUsername());
        userData.setEmail(this.securityUtil.getEmail());

        return this.userRepository.save(userData);
    }

    public void deleteUser(String username) throws NotAuthorizedException {
        this.securityUtil.isAdminOrUser(username);

        this.userRepository.deleteById(username);
    }

    private UserEntity findUser(String username) throws EntityNotFoundException {
        return this.userRepository.findById(username)
                .orElseThrow(() -> new EntityNotFoundException(String.format(ErrorConst.USER_NOT_FOUND, username)));
    }
}
