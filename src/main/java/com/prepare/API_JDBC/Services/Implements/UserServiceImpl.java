package com.prepare.API_JDBC.Services.Implements;

import com.prepare.API_JDBC.DAO.Implements.RolesDAOImpl;
import com.prepare.API_JDBC.DAO.RolDAO;
import com.prepare.API_JDBC.DAO.UserDAO;
import com.prepare.API_JDBC.Models.ResponseServe;
import com.prepare.API_JDBC.Models.Rol;
import com.prepare.API_JDBC.Models.Users;
import com.prepare.API_JDBC.Services.UserService;
import com.prepare.API_JDBC.Utils.Messages;
import com.prepare.API_JDBC.Utils.EstadoCivilEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService {

//    private final JdbcTemplate jdbcTemplate;
    @Autowired
    private UserDAO usersDAO;

    @Autowired
    private RolDAO rolDAO;

    /*public UserServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.usersDAO = new UsersDAO(jdbcTemplate);
    }*/

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

    private void validUser(Users user){
        try {
            Integer.valueOf(user.getDni());
        } catch (Exception error){
            throw new RuntimeException(String.valueOf(Messages.BAD_REQUEST));
        }
    }

    @Override
    public ResponseEntity listarService(){
        try {
            return new ResponseEntity<>(usersDAO.listar(), HttpStatus.OK);
        } catch (DataAccessException error){
            throw new RuntimeException(String.valueOf(Messages.BAD_REQUEST));
        }
    }

    @Override
    public ResponseEntity insertService(Users user){
       String eCivil = getEstadoCivil(user.getEstadoCivil());
       validUser(user);
       usersDAO.insertar(user, eCivil);
       return new ResponseEntity<>(new ResponseServe("200", "Usuario Guardado"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity updateService(Users user){
        String eCivil = getEstadoCivil(user.getEstadoCivil());
        validUser(user);
        usersDAO.modificar(user, eCivil);
        return new ResponseEntity<>(new ResponseServe("200", "Usuario Actualizado"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity getObjectService(int id){
        try {
            return new ResponseEntity<>( usersDAO.obtenerObjeto(id), HttpStatus.OK);
        } catch (DataAccessException error){
            throw new RuntimeException(String.valueOf(Messages.NOT_FOUND));
        }
    }

    @Override
    public ResponseEntity deleteService(int id){
        // userDAO.eliminar(id)
        return null;
    }


    public HashMap<String, String> getUserRol(int id) {
        try {
            Users user = usersDAO.obtenerObjeto(id);
            Rol rol = rolDAO.obtenerObjeto(user.getIdRol());
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
