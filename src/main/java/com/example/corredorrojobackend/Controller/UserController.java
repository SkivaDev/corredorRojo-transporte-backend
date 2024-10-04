package com.example.corredorrojobackend.Controller;

import com.example.corredorrojobackend.Dto.UserDto;
import com.example.corredorrojobackend.Entity.User;
import com.example.corredorrojobackend.Repository.UserRepository;
import com.example.corredorrojobackend.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {


    @Autowired
    private UserRepository userRepository;
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // Endpoint para login de usuarios
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String password = loginData.get("password");

        // Verificar si es administrador
        if (email.equals("admin@gmail.com") && password.equals("admin")) {
            Map<String, String> response = new HashMap<>();
            response.put("redirectUrl", "/inicio");
            response.put("message", "Bienvenido Administrador");
            response.put("username", "Administrador");
            return ResponseEntity.ok(response);
        }

        // Verificar si es un usuario registrado en la base de datos
        Optional<User> userOpt = userRepository.findByEmail(email);  // Buscar por correo
        if (!userOpt.isPresent()) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Usuario no encontrado");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        User user = userOpt.get();

        // Verificar contraseña (asegúrate de que sea en texto plano si no usas cifrado)
        if (user.getPassword().equals(password)) {
            Map<String, String> response = new HashMap<>();
            response.put("redirectUrl", "/dashboard");
            response.put("message", "Inicio de sesión exitoso");
            response.put("username", user.getUsername());
            response.put("userId", String.valueOf(user.getId()));
            return ResponseEntity.ok(response);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Contraseña incorrecta");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    // Endpoint para tener un usuario por su ID
    @GetMapping("{id}")
    public  ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId) {
        UserDto userDto = userService.getUserById(userId);

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    // Endpoint para crear un usuario
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto savedUser = userService.createUser(userDto);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // Endpoint para obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    // Endpoint para actualizar un usuario
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId, @RequestBody UserDto updatedUser) {
        UserDto userDto = userService.updateUser(userId, updatedUser);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    // Endpoint para eliminar un usuario
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("Employee deleted successfully.");
    }


}
