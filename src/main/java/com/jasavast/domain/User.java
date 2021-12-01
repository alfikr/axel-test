package com.jasavast.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "jsv_user")
@Entity
public class User {
    @Id
    private String id;
    @NotBlank
    private String login;
    @NotBlank
    private String password;
    @NotBlank
    private String email;
    private boolean aktif;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    @Transient
    @JsonIgnore
    private Set<Authority> authorities= new HashSet<>();
}
