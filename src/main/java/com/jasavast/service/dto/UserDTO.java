package com.jasavast.service.dto;

import com.jasavast.domain.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class UserDTO {
    private String id;
    @NotBlank
    private String login;
    @NotBlank
    private String email;
    private Set<String> authority;
    public UserDTO(){}
    public UserDTO(User user){
        this.id=user.getId();
        this.login=user.getLogin();
        this.email=user.getEmail();
        this.authority=user.getAuthorities().stream()
                .map(a->a.getName()).collect(Collectors.toSet());
    }
}
