package com.jasavast.service;

import com.jasavast.core.error.EmailAlreadyUsedException;
import com.jasavast.core.error.UsernameAlreadyUsedException;
import com.jasavast.domain.Authority;
import com.jasavast.domain.User;
import com.jasavast.repository.AuthorityRepository;
import com.jasavast.repository.UserRepository;
import com.jasavast.service.dto.UserDTO;
import liquibase.pro.packaged.U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthorityRepository authorityRepository;
    public Mono<User> createUser(UserDTO userDTO,String password){
        return Mono.fromCallable(()->{
            Optional<User> existUser = userRepository.findOneByLogin(userDTO.getLogin());
            if (existUser.isPresent()){
                if (!existUser.get().isAktif()){
                    userRepository.delete(existUser.get());
                }else {
                    throw new UsernameAlreadyUsedException();
                }
            }
            existUser=userRepository.findOneByEmail(userDTO.getEmail());
            if (existUser.isPresent()){
                if (!existUser.get().isAktif()){
                    userRepository.delete(existUser.get());
                }else {
                    throw new EmailAlreadyUsedException();
                }
            }
            User user = new User();
            user.setCreatedAt(LocalDateTime.now());
            user.setLogin(userDTO.getLogin());
            user.setPassword(passwordEncoder.encode(password));
            user.setEmail(userDTO.getEmail());
            user.setModifiedAt(LocalDateTime.now());
            user.setAktif(true);
            Set<Authority> authoritySet=new HashSet<>();
            authoritySet.add(authorityRepository.findById("ROLE_USER").orElse(new Authority("ROLE_USER")));
            user.setAuthorities(authoritySet);
            return userRepository.save(user);
        });

    }
}
