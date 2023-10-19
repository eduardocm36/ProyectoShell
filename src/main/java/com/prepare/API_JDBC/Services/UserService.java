package com.prepare.API_JDBC.Services;

import com.prepare.API_JDBC.Models.Users;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity listarService();

    ResponseEntity insertService(Users user);

    ResponseEntity updateService(Users user);

    ResponseEntity getObjectService(int id);

    ResponseEntity deleteService(int id);

}
