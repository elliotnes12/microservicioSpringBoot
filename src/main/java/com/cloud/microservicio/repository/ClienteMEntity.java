package com.cloud.microservicio.repository;

import java.util.List;

public interface ClienteMEntity {

    public abstract List<Cliente> findAll();
    public abstract void save(Cliente cliente);
    public abstract Cliente findById(long id);
}
