package com.jasavast.resource.vm;

import com.jasavast.service.dto.UserDTO;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserVM extends UserDTO {
    @NotBlank
    private String password;
}
