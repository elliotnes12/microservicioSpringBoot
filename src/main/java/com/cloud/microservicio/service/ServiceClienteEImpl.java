package com.cloud.microservicio.service;

import com.cloud.microservicio.repository.Cliente;
import com.cloud.microservicio.repository.ClienteMEntity;
import com.cloud.microservicio.repository.ClienteMEntityImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("ServiceClienteEntity")
public class ServiceClienteEImpl implements ServiceCliente {


    @Autowired
    @Qualifier("ClienteRepositoryEntity")
    private ClienteMEntity repository;

    @Override
    public List<Cliente> findAll() {
        return repository.findAll();
    }

    @Override
    public Cliente findById(long id) {
        return null;
    }


    @Override
    public Cliente findByNombreAndId(String nombre, long id) {
        return null;
    }

    @Override
    @Transactional
    public Cliente addCliente(Cliente cliente) {
        repository.save(cliente);
        return cliente;
    }
}
