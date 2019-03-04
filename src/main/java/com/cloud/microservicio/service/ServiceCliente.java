package com.cloud.microservicio.service;

import com.cloud.microservicio.repository.Cliente;

import java.util.List;

public interface ServiceCliente {

    public abstract List<Cliente> findAll();
    public Cliente findById(long id);
    public Cliente findByNombreAndId(String nombre,long id);
    public Cliente addCliente(Cliente cliente);
}
