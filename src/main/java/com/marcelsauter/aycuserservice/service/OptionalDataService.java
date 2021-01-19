package com.marcelsauter.aycuserservice.service;

import com.ayc.exceptionhandler.exception.EntityNotFoundException;
import com.ayc.keycloaksecurity.util.SecurityUtil;
import com.marcelsauter.aycuserservice.consts.ErrorConst;
import com.marcelsauter.aycuserservice.model.UserEntity;
import com.marcelsauter.aycuserservice.model.dto.OptionalDataDTO;
import com.marcelsauter.aycuserservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionalDataService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityUtil securityUtil;

    public OptionalDataDTO getOptionalData() throws EntityNotFoundException {
        return this.findUser(this.securityUtil.getUsername()).getOptionalData();
    }

    public OptionalDataDTO getOptionalDataByUsername(String username) throws EntityNotFoundException {
        return this.findUser(username).getOptionalData();
    }

    public UserEntity saveOptionalData(OptionalDataDTO optionalData) throws EntityNotFoundException {
        UserEntity userData = this.findUser(this.securityUtil.getUsername());

        userData.setOptionalData(optionalData);

        return this.userRepository.save(userData);
    }

    private UserEntity findUser(String username) throws EntityNotFoundException {
        return this.userRepository.findById(username)
                .orElseThrow(() -> new EntityNotFoundException(String.format(ErrorConst.USER_NOT_FOUND, username)));
    }
}
