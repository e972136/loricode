package com.gaspar.proyecto.entity;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserDto {

    private String fullName;
    private String email;
}
