package com.gaspar.proyecto.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaspar.proyecto.entity.UserDto;
import com.gaspar.proyecto.model.User;
import com.gaspar.proyecto.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    public UserServiceImpl(UserRepository userRepository, ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public User save(UserDto userDto) {
        User user = null;
        try {
            user = objectMapper.readValue(objectMapper.writeValueAsString(userDto),User.class);
        } catch (JsonProcessingException e) {
            return null;
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User update(String id, UserDto userDto) {
        User user = null;
        try {
            user = objectMapper.readValue(objectMapper.writeValueAsString(userDto),User.class);
        } catch (JsonProcessingException e) {
            return null;
        }
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllByQueryProcedure() {
        return userRepository.findAllByQueryProcedure();
    }
}
