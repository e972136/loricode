package com.gaspar.proyecto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(length = 36)
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private String id;

    @Column(name="fullname",length = 180)
    private String fullName;

    @Column(name="email",length = 180)
    private String email;

}
