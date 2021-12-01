package com.jasavast.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jasavast.core.security.filter.TokenProvider;
import com.jasavast.resource.vm.LoginVM;
import com.jasavast.resource.vm.UserVM;
import com.jasavast.service.UserService;
import com.jasavast.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserResources {
    @Autowired
    private UserService userService;
    @Autowired
    private ReactiveAuthenticationManager authenticationManager;
    @Autowired
    private TokenProvider tokenProvider;
    @PostMapping("/register")
    public Mono<UserDTO> createUser(@RequestBody @Valid UserVM userVM){
        return userService.createUser(userVM,userVM.getPassword()).map(UserDTO::new);
    }
    public Mono<JWTToken> authorize(@Valid @RequestBody Mono<LoginVM> loginVM){
        return loginVM
                .flatMap(login->authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(),login.getPassword()))
                        .flatMap(auth->Mono.fromCallable(()->tokenProvider.createToken(auth,login.isRememberMe()))))
                .map(s->{
                    return new JWTToken(s);
                });
    }

    static class JWTToken {

        private String idToken;

        JWTToken(String idToken) {
            this.idToken = idToken;
        }

        @JsonProperty("id_token")
        String getIdToken() {
            return idToken;
        }

        void setIdToken(String idToken) {
            this.idToken = idToken;
        }
    }
}
