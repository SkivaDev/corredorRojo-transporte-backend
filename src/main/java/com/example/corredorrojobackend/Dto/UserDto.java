package com.example.corredorrojobackend.Dto;

import com.example.corredorrojobackend.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String dni;
    private String username;
    private String password;
    private String email;
    private String address;
    private String phone;
    private User.Role role;
}
