package com.prepare.API_JDBC.DAO.Implements;

import com.prepare.API_JDBC.DAO.RolDAO;
import com.prepare.API_JDBC.DAO.RowMapers.RolRowMapper;
import com.prepare.API_JDBC.Models.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RolesDAOImpl implements RolDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

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
