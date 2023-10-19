package com.prepare.API_JDBC.DAO.Implements;

import com.prepare.API_JDBC.DAO.UserDAO;
import com.prepare.API_JDBC.DAO.RowMapers.UserRowMapper;
import com.prepare.API_JDBC.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class UsersDAOImpl implements UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*@Autowired
    public UsersDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }*/

    @Override
    public List<Users> listar(){
        StringBuilder query = new StringBuilder("SELECT id, nombres, ape_paterno, ape_materno, dni, " +
                "codigo, fecha_nacimiento, direccion, id_rol, estado_civil, estado_comunal " +
                "FROM users");
        return jdbcTemplate.query(String.valueOf(query), new UserRowMapper());
    }

    @Override
    public void insertar(Users user, String eCivil) {
        StringBuilder query = new StringBuilder("INSERT INTO Users (nombres, ape_paterno,\n" +
                "ape_materno, fecha_nacimiento, direccion,\n" +
                "id_rol, estado_civil, estado_comunal, dni, codigo)\n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        jdbcTemplate.update(String.valueOf(query), new Object[] { user.getNombres(), user.getApePaterno(), user.getApeMaterno(),
                LocalDate.now(), user.getDireccion(), user.getIdRol(),
                eCivil, user.getEstadoComunal(), user.getDni(), user.getCodigo()});
    }

    @Override
    public void modificar(Users user, String eCivil) {
        StringBuilder query = new StringBuilder("UPDATE users " +
                "SET nombres = ?, ape_paterno = ?, ape_materno = ?, " +
                "fecha_nacimiento = ?, direccion = ?, id_rol = ?, " +
                "estado_civil = ?, estado_comunal = ?,  dni = ?, codigo = ? " +
                "WHERE id = ?");
        jdbcTemplate.update(String.valueOf(query), user.getNombres(), user.getApePaterno(), user.getApeMaterno(),
                LocalDate.now(), user.getDireccion(), user.getIdRol(),
                eCivil, user.getEstadoComunal(), user.getDni(), user.getCodigo(), user.getId());
    }

    @Override
    public void eliminar(int id) {
        String query = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(query, id);

    }

    @Override
    public Users obtenerObjeto(int id) {
        String query = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(query,  new Object[]{id}, new UserRowMapper());
    }
}
