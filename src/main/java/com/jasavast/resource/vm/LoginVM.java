package com.jasavast.resource.vm;

import lombok.Data;

@Data
public class LoginVM {
    private String username;
    private String password;
    private boolean rememberMe;
}
