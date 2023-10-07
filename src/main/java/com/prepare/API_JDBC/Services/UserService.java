package com.prepare.API_JDBC.Services;

import com.prepare.API_JDBC.DAO.RolesDAO;
import com.prepare.API_JDBC.DAO.UsersDAO;
import com.prepare.API_JDBC.Models.Rol;
import com.prepare.API_JDBC.Models.Users;
import com.prepare.API_JDBC.Utils.Messages;
import com.prepare.API_JDBC.Utils.EstadoCivilEnum;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashMap;

public class UserService {

    private JdbcTemplate jdbcTemplate;
    private UsersDAO usersDAO;

    public UserService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.usersDAO = new UsersDAO(jdbcTemplate);
    }

    private String getEstadoCivil(String estado){
        String eCivil;
        switch (estado){
            case "2":
                eCivil = String.valueOf(EstadoCivilEnum.Casado);
                break;
            case "3":
                eCivil = String.valueOf(EstadoCivilEnum.Viudo);
                break;
            case "4":
                eCivil = String.valueOf(EstadoCivilEnum.Conviviente);
                break;
            default:
                eCivil = String.valueOf(EstadoCivilEnum.Soltero);
        }
        return eCivil;
    }

    public ResponseEntity listarService(){
        try {
            return new ResponseEntity<>(usersDAO.listar(), HttpStatus.OK);
        } catch (DataAccessException error){
            throw new RuntimeException(String.valueOf(Messages.BAD_REQUEST));
        }
    }

    public void insertService(Users user){
       String eCivil = getEstadoCivil(user.getEstadoCivil());
       // VALIDACION PARA INSERTAR DATOS
        usersDAO.insertar(user, eCivil);
    }

    public void updateService(Users user){
        String eCivil = getEstadoCivil(user.getEstadoCivil());
        // VALIDACION PARA ACTUALIZAR DATOS
        usersDAO.modificar(user, eCivil);
    }

    public ResponseEntity getObjectService(int id){
        try {
            return new ResponseEntity<>( usersDAO.obtenerObjeto(id), HttpStatus.OK);
        } catch (DataAccessException error){
            throw new RuntimeException(String.valueOf(Messages.NOT_FOUND));
        }
    }

    public HashMap<String, String> getUserRol(int id) {
        try {
            Users user = usersDAO.obtenerObjeto(id);

            Rol rol = new RolesDAO(jdbcTemplate).obtenerObjeto(user.getIdRol());
            HashMap<String, String> userRol = new HashMap<>();
            userRol.put("id", String.valueOf(user.getId()));
            userRol.put("nombre", String.valueOf(new StringBuilder(user.getNombres() + " " +
                    user.getApePaterno() + " " + user.getApeMaterno())));
            userRol.put("dni", user.getDni());
            userRol.put("codigo", user.getCodigo());
            userRol.put("rol", rol.getNombre());
            return userRol;
        } catch (Exception error) {
            return null;
        }
    }


}
