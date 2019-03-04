package com.cloud.microservicio.config;

import com.cloud.microservicio.model.ClienteModel;
import com.cloud.microservicio.repository.Cliente;
import org.springframework.stereotype.Component;

@Component("ClienteConverter")
public class ClienteConverter {

    public ClienteModel EntityToEntityModel(Cliente cliente){
        ClienteModel clientemodel = new ClienteModel();
        clientemodel.setId(cliente.getId());
        clientemodel.setName(cliente.getName());
        clientemodel.setApellido(cliente.getLastName());
        clientemodel.setEmail(cliente.getEmail());
        clientemodel.setFecha(cliente.getCreatedAt());

        return clientemodel;
    }

    public Cliente EntityModelToEntity(ClienteModel clientemodel){
        Cliente cliente = new Cliente();
        cliente.setId(clientemodel.getId());
        cliente.setName(clientemodel.getName());
        cliente.setLastName(clientemodel.getApellido());
        cliente.setEmail(clientemodel.getEmail());
        cliente.setCreatedAt(clientemodel.getFecha());

        return cliente;
    }
}
