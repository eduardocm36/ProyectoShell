package com.prepare.API_JDBC.DAO;

import com.prepare.API_JDBC.DAO.InterfacesDAO.RolInterface;
import com.prepare.API_JDBC.DAO.RowMapers.RolRowMapper;
import com.prepare.API_JDBC.DAO.RowMapers.UserRowMapper;
import com.prepare.API_JDBC.Models.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RolesDAO implements RolInterface {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RolesDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Rol> listar() throws Exception {
        String query = "SELECT id, nombre FROM roles";
        return jdbcTemplate.query(query, new RolRowMapper());
    }

    @Override
    public void insertar(Rol t) {

    }

    @Override
    public void modificar(Rol t) {

    }

    @Override
    public Rol obtenerObjeto(Long id) {
        String query = "SELECT id, nombre FROM roles WHERE id = ?";
        return jdbcTemplate.queryForObject(query,  new Object[]{id}, new RolRowMapper());
    }
}
