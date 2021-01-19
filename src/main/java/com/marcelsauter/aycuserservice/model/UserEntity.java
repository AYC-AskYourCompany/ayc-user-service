package com.marcelsauter.aycuserservice.model;

import com.marcelsauter.aycuserservice.model.dto.OptionalDataDTO;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("user")
public class UserEntity {

    @Id
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private OptionalDataDTO optionalData;
}
