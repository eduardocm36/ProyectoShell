package com.prepare.API_JDBC.DAO.InterfacesDAO;

import com.prepare.API_JDBC.Models.Users;

import java.util.List;

public interface UserInterface {

    List<Users> listar();

    void insertar(Users user, String eCivil);

    void modificar(Users user, String eCivil);

    void eliminar(int id);

    Users obtenerObjeto(int id);


}
