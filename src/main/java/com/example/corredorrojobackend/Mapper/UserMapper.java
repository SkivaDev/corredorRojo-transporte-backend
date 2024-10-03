package com.example.corredorrojobackend.Mapper;


import com.example.corredorrojobackend.Dto.UserDto;
import com.example.corredorrojobackend.Entity.User;

public class UserMapper {

    public static UserDto mapToCartItemDto(User user) {
        return new UserDto(
                user.getId(),
                user.getDni(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getAddress(),
                user.getPhone(),
                user.getRole()
        );
    }

    public static User mapToCartItem(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getDni(),
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getEmail(),
                userDto.getAddress(),
                userDto.getPhone(),
                userDto.getRole()
        );
    }
}
