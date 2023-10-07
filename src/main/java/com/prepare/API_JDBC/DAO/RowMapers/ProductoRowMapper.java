package com.prepare.API_JDBC.DAO.RowMapers;

import com.prepare.API_JDBC.Models.Producto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ProductoRowMapper implements RowMapper<Producto> {
    @Override
    public Producto mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Producto producto = new Producto();
        producto.setId(resultSet.getInt("id"));
        producto.setNombre(resultSet.getString("nombre"));
        producto.setDescripcion(resultSet.getString("descripcion"));
        producto.setCantidad(resultSet.getInt("cantidad"));
        return producto;
    }
}
