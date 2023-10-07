package com.prepare.API_JDBC.DAO.RowMapers;

import com.prepare.API_JDBC.Models.Rol;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class RolRowMapper implements RowMapper<Rol> {

    @Override
    public Rol mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Rol rol = new Rol();
        rol.setId(resultSet.getLong("id"));
        rol.setNombre(resultSet.getString("nombre"));
        return rol;
    }
}