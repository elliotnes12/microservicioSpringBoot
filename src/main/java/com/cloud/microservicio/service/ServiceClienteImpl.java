package com.cloud.microservicio.service;

import com.cloud.microservicio.repository.Cliente;
import com.cloud.microservicio.repository.ClienteDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ClienteService")
public class ServiceClienteImpl implements ServiceCliente {

    @Autowired
    @Qualifier("ClienteRepository")
    private ClienteDaoImpl repository;

    @Override
    public List<Cliente> findAll() {
        return repository.findAll();
    }

    @Override
    public Cliente findById(long id) {
        return repository.findById(id);
    }


    @Override
    public Cliente findByNombreAndId(String nombre, long id) {
        return repository.findByNameAndId(nombre,id);
    }

    @Override
    public Cliente addCliente(Cliente cliente) {
        return repository.save(cliente);
}
}
