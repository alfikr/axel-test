package com.jasavast.resource;

import com.jasavast.resource.vm.UserVM;
import com.jasavast.service.UserService;
import com.jasavast.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserResources {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public Mono<UserDTO> createUser(@RequestBody @Valid UserVM userVM){
        return userService.createUser(userVM,userVM.getPassword()).map(UserDTO::new);
    }
}
