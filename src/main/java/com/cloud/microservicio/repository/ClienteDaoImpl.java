package com.cloud.microservicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("ClienteRepository")
public interface ClienteDaoImpl extends JpaRepository<Cliente,Serializable>{
    public abstract Cliente findById(long id);
    public abstract Cliente findByNameAndId(String nombre,long id);
}
