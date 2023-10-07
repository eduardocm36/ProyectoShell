package com.prepare.API_JDBC.DAO;

import java.util.List;

public interface CrudDAO<objetc> {

    List<objetc> listar();

    void insetar(objetc t);

    void modificar(objetc t);

    void eliminar(int id);

    objetc obtenerObjeto(int id);

}
