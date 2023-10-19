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
                return new ResponseServe("401 NOT_FOUND",  "Objeto no encontrado");
            case BAD_REQUEST:
                return new ResponseServe("400 BAD_REQUEST",  "Algunos datos son inválidos");
            default:
                return null;

        }
    }


}
