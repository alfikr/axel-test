package com.jasavast.resource.vm;

import com.jasavast.service.dto.UserDTO;
import lombok.Data;

@Data
public class UserVM extends UserDTO {
    private String password;
}
