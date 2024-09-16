package com.code_room_backend.backend.service;

import java.util.Optional;


import org.springframework.stereotype.Service;

import com.code_room_backend.backend.model.User;
import com.code_room_backend.backend.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user){
        // Verificar si el email ya está registrado
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new IllegalStateException("El email ya está registrado");
        }

        //Guardar el nuevo usuario
        return userRepository.save(user);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
