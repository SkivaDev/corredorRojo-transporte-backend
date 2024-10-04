package com.example.corredorrojobackend.Service.impl;

import com.example.corredorrojobackend.Dto.UserDto;
import com.example.corredorrojobackend.Entity.User;
import com.example.corredorrojobackend.Exception.ResourceNotFoundException;
import com.example.corredorrojobackend.Mapper.UserMapper;
import com.example.corredorrojobackend.Repository.UserRepository;
import com.example.corredorrojobackend.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToCartItem(userDto);
        User savedUser = userRepository.save(user);

        return UserMapper.mapToCartItemDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with the id " + userId + "dont exist" ));

        return UserMapper.mapToCartItemDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {

        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> UserMapper.mapToCartItemDto(user))
                .collect(Collectors.toList());

    }

    @Override
    public UserDto updateUser(Long userId, UserDto updatedUser) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User with the id " + userId + "dont exist" )
        );

        user.setDni(updatedUser.getDni());
        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
        user.setEmail(updatedUser.getEmail());
        user.setAddress(updatedUser.getAddress());
        user.setPhone(updatedUser.getPhone());
        user.setRole(updatedUser.getRole());

        User savedUser = userRepository.save(user);

        return UserMapper.mapToCartItemDto(savedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User with the id " + userId + "dont exist" )
        );
        userRepository.delete(user);
    }
}
