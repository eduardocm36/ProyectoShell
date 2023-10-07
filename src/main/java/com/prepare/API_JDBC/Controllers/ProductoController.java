package com.prepare.API_JDBC.Controllers;

import com.prepare.API_JDBC.DAO.ProductoDAO;
import com.prepare.API_JDBC.Models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ProductoController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/products")
    public ResponseEntity<List<Producto>> consulta(){
        return  ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(new ProductoDAO(jdbcTemplate).listar());
    }

    @PostMapping("/insertar-productos")
    public void insertar(@RequestBody Producto producto){
        new ProductoDAO(jdbcTemplate).insetar(producto);
    }

}
