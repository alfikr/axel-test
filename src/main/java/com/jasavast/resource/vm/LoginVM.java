package com.jasavast.resource.vm;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginVM {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private boolean rememberMe=true;
}
