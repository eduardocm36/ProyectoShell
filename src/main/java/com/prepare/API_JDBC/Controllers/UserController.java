package com.prepare.API_JDBC.Controllers;


import com.prepare.API_JDBC.DAO.UsersDAO;
import com.prepare.API_JDBC.Models.Users;
import com.prepare.API_JDBC.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/users")
    public ResponseEntity usersList(){
        return new UserService(jdbcTemplate).listarService();
    }

    @PostMapping("/insert-user")
    public ResponseEntity insertUser(@Valid @RequestBody Users user){
        return new UserService(jdbcTemplate).insertService(user);
    }

    @PutMapping("/update-user")
    public ResponseEntity updateUser(@Valid @RequestBody Users user){
        return new UserService(jdbcTemplate).updateService(user);
    }

    @PostMapping("/delete-user/{id}")
    public void deleteUser(@PathVariable int id){
        new UsersDAO(jdbcTemplate).eliminar(id);
    }

    @GetMapping("/get-user/{id}")
    public ResponseEntity<Users> getUser(@PathVariable int id){
        return new UserService(jdbcTemplate).getObjectService(id);
    }

    @GetMapping("/get-userRol/{id}")
    public ResponseEntity<Object> getUserRol(@PathVariable int id){
        return  ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(new UserService(jdbcTemplate).getUserRol(id));
    }

}
