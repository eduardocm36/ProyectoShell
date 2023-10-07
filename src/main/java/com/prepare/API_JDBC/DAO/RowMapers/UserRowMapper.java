package com.prepare.API_JDBC.DAO.RowMapers;

import com.prepare.API_JDBC.Models.Users;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserRowMapper implements RowMapper<Users> {

    @Override
    public Users mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Users user = new Users();
        user.setId(resultSet.getLong("id"));
        user.setNombres(resultSet.getString("nombres"));
        user.setApePaterno(resultSet.getString("ape_paterno"));
        user.setDni(resultSet.getString("dni"));
        user.setCodigo(resultSet.getString("codigo"));
        user.setApeMaterno(resultSet.getString("ape_materno"));
        user.setFechaNacimiento(resultSet.getDate("fecha_nacimiento"));
        user.setDireccion(resultSet.getString("direccion"));
        user.setIdRol(resultSet.getLong("id_rol"));
        user.setEstadoCivil(resultSet.getString("estado_civil"));
        user.setEstadoComunal(resultSet.getLong("estado_comunal"));
        return user;
    }
}