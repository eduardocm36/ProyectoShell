package com.prepare.API_JDBC.Models;

public class ResponseServe {

    /*
        404 Not Found: Indica que el recurso solicitado no ha sido encontrado en el servidor.
        400 Bad Request: Indica que el servidor no puede entender la solicitud del cliente debido a una sintaxis incorrecta o condiciones que no pueden ser cumplidas.
        200 OK: Indica que la solicitud fue exitosa y el servidor ha devuelto correctamente el recurso solicitado.
        500 Internal Server Error: Indica que el servidor ha encontrado una situación inesperada y no puede completar la solicitud.
    */

    private String STATUS;
    private String MESSAGE;
    private String FIELD;
    private String OBJECT;

    public ResponseServe(String STATUS, String MESSAGE) {
        this.STATUS = STATUS;
        this.MESSAGE = MESSAGE;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public String getFIELD() {
        return FIELD;
    }

    public void setFIELD(String FIELD) {
        this.FIELD = FIELD;
    }

    public String getOBJECT() {
        return OBJECT;
    }

    public void setOBJECT(String OBJECT) {
        this.OBJECT = OBJECT;
    }
}
