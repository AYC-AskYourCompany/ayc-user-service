package com.marcelsauter.aycuserservice.controller;

import com.ayc.exceptionhandler.exception.EntityNotFoundException;
import com.marcelsauter.aycuserservice.model.UserEntity;
import com.marcelsauter.aycuserservice.model.dto.OptionalDataDTO;
import com.marcelsauter.aycuserservice.service.OptionalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/optional-data")
public class OptionalDataController {

    @Autowired
    private OptionalDataService optionalDataService;

    @GetMapping
    public OptionalDataDTO getOptionalData() throws EntityNotFoundException {
        return this.optionalDataService.getOptionalData();
    }

    @GetMapping("/{username}")
    public OptionalDataDTO getOptionalDataByUsername(@PathVariable("username") String username) throws EntityNotFoundException {
        return this.optionalDataService.getOptionalDataByUsername(username);
    }

    @PostMapping
    public UserEntity saveOptionalData(@RequestBody OptionalDataDTO optionalData) throws EntityNotFoundException {
        return this.optionalDataService.saveOptionalData(optionalData);
    }
}
