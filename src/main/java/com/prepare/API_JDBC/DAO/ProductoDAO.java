package com.prepare.API_JDBC.DAO;

import com.prepare.API_JDBC.DAO.RowMapers.ProductoRowMapper;
import com.prepare.API_JDBC.Models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProductoDAO implements CrudDAO<Producto> {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductoDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Producto> listar() {
        String sql = "SELECT * FROM Users";
        return jdbcTemplate.query(sql, new ProductoRowMapper());
    }

    @Override
    public void insetar(Producto producto) {
        String sql = "INSERT INTO producto (nombre, descripcion, cantidad) values (?, ?, ?)";
        jdbcTemplate.update(sql, new Object[] {producto.getNombre(), producto.getDescripcion(), producto.getCantidad()});
    }

    @Override
    public void modificar(Producto t) {

    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public Producto obtenerObjeto(int id) {
        return null;
    }
}
