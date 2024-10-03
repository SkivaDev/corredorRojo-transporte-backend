package com.example.corredorrojobackend.Service.impl;

import com.example.corredorrojobackend.Dto.UserDto;
import com.example.corredorrojobackend.Entity.User;
import com.example.corredorrojobackend.Exception.ResourceNotFoundException;
import com.example.corredorrojobackend.Mapper.UserMapper;
import com.example.corredorrojobackend.Repository.UserRepository;
import com.example.corredorrojobackend.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with the id " + userId + "dont exist" ));

        return UserMapper.mapToCartItemDto(user);
    }
}
