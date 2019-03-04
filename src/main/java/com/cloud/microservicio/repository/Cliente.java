package com.cloud.microservicio.repository;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "apellido")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    public Cliente(String name, String lastName, String email, Date createdAt) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.createdAt = createdAt;
    }

    public Cliente() {
    }

    /*
    @PrePersist
    public void prePersis(){
        createdAt = new Date();
    }
    */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
