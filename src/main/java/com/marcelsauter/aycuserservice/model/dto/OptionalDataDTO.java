package com.marcelsauter.aycuserservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OptionalDataDTO {

    private String companyId;
    private Skills[] skills;
    private String professionalPosition;
    private String personalDescription;
}
