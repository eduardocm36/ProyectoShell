package com.prepare.API_JDBC.DAO.InterfacesDAO;

import com.prepare.API_JDBC.Models.Rol;

import java.util.List;

public interface RolInterface {

    List<Rol> listar() throws Exception;

    void insertar(Rol t);

    void modificar(Rol t);

    Rol obtenerObjeto(Long id);

}
