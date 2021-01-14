package com.marcelsauter.aycuserservice.model.dto;

import lombok.Data;

@Data
public class OptionalDataDTO {

    private String companyId;
    private String[] skills;
    private String professionalPosition;
    private String personalDescription;
}
