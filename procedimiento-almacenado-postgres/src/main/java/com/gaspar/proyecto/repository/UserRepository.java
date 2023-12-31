package com.gaspar.proyecto.repository;
import com.gaspar.proyecto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository  extends JpaRepository<User,String> {
    @Query(value = "select * FROM sp_get_users()",nativeQuery = true)
    List<User> findAllByQueryProcedure();

    @Query(value = "CALL public.sp_save_user(:nombre,:correo,:rid)",nativeQuery = true)
    String saveUserByQueryProcedure(
            String nombre,
            String correo,
            String rid
    );
}
