package com.prepare.API_JDBC.Utils;

import com.prepare.API_JDBC.Models.ResponseServe;

public enum Messages {

    OK,
    NOT_FOUND,
    BAD_REQUEST;
    //ERROR_SERVE


    public ResponseServe obtenerError(){
        switch (this) {
            case NOT_FOUND:
                return new ResponseServe("401",  "Objeto no encontrado");
            case BAD_REQUEST:
                return new ResponseServe("400",  "Error al obtener datos");
            default:
                return null;

        }
    }


}
