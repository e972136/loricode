package com.gaspar.proyecto.service;

import com.gaspar.proyecto.entity.UserDto;
import com.gaspar.proyecto.model.User;

import java.util.List;

public interface UserService {

    User save(UserDto userDto);

    List<User> getAll();

    User getById(String id);

    User update(String id, UserDto userDto);

    List<User> findAllByQueryProcedure();
}
