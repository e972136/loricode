package com.gaspar.proyecto.controller;

import com.gaspar.proyecto.entity.UserDto;
import com.gaspar.proyecto.model.User;
import com.gaspar.proyecto.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<User> save(
            @RequestBody UserDto userDto
            ){
        return ResponseEntity.ok(service.save(userDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> update(
            @PathVariable String id,
            @RequestBody UserDto userDto
    ){
        return ResponseEntity.ok(service.update(id,userDto));
    }

    @GetMapping("/list")
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/listProcedure")
    public ResponseEntity<List<User>> findAllByQueryProcedure(){
        return ResponseEntity.ok(service.findAllByQueryProcedure());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(
            @PathVariable String id
    ){
        return ResponseEntity.ok(service.getById(id));
    }
}
