package com.prepare.API_JDBC.Models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class Users {

    private Long id, idRol;
    @NotBlank
    private String nombres, apePaterno, apeMaterno;
    private String direccion;
    @Size(max = 8, min = 8)
    @NotBlank
    private String dni;
    @NotBlank
    private String codigo;
    private String estadoCivil;
    private Date fechaNacimiento;
    private Long estadoComunal; //1: activo - 0: inactivo

    public Users() {
    }

    public Users(Long idRol, String nombres,
                 String ape_paterno, String apeMaterno,
                 String direccion, Date fechaNacimiento,
                 String estadoCivil, Long estadoComunal, String dni, String codigo) {
        this.idRol = idRol;
        this.nombres = nombres;
        this.apePaterno = ape_paterno;
        this.apeMaterno = apeMaterno;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoCivil = estadoCivil;
        this.dni = dni;
        this.codigo = codigo;
        if (estadoComunal != null) {
            this.estadoComunal = estadoComunal;
        } else {
            this.estadoComunal = 1L;
        }
    }

    public Users(Long id, Long idRol,
                 String nombres, String ape_paterno,
                 String apeMaterno, String direccion,
                 Date fechaNacimiento, String estadoCivil, Long estadoComunal, String dni, String codigo) {
        this(idRol, nombres, ape_paterno, apeMaterno, direccion, fechaNacimiento, estadoCivil, estadoComunal, dni, codigo);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Long getEstadoComunal() {
        return estadoComunal;
    }

    public void setEstadoComunal(Long estadoComunal) {
        this.estadoComunal = estadoComunal;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
