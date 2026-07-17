package com.anupam.springSecurity.dto;

import com.anupam.springSecurity.entities.enums.Permission;
import com.anupam.springSecurity.entities.enums.Role;
import lombok.Data;

import java.util.Set;

@Data
public class SignUpDto {
    private String email;
    private String password;
    private String name;
    private Set<Role> roles;
    private Set<Permission> permissions;
}
