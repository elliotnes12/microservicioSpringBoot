package com.cloud.microservicio.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class ClienteModel {

    private long id;

    private String name;

    private String apellido;

    private String email;

    private Date fecha;

    public ClienteModel() {
    }

    public ClienteModel(long id, String name, String apellido, String email, Date fecha) {
        this.id = id;
        this.name = name;
        this.apellido = apellido;
        this.email = email;
        this.fecha = fecha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
