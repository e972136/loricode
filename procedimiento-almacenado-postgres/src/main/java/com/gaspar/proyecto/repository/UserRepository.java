package com.gaspar.proyecto.repository;
import com.gaspar.proyecto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,String> {
}
