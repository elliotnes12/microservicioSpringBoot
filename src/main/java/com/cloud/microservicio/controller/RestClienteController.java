package com.cloud.microservicio.controller;

import com.cloud.microservicio.repository.Cliente;
import com.cloud.microservicio.service.ServiceCliente;
import com.cloud.microservicio.service.ServiceClienteImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/rest/cliente")
public class RestClienteController {

    @Autowired
    @Qualifier("ClienteService")
    private ServiceClienteImpl service;

    @GetMapping("/all")
    @ResponseBody
    public List<Cliente> findAll(){
        return service.findAll();
    }
    @GetMapping("/id/{id}")
    public Cliente findId(@PathVariable("id") String id){
        return service.findById(Long.parseLong(id));
    }
    @GetMapping("/data/{nombre}/{id}")
    public Cliente findByNombreAndId(@PathVariable("nombre") String nombre,@PathVariable("id") String id){
        return service.findByNombreAndId(nombre,Long.parseLong(id));
    }
    @GetMapping("/insert")
    public List<Cliente> insertCliente(){

         Cliente cliente = new Cliente("juan","dios","jua@gmail.com", new Date());
         service.addCliente(cliente);

         return service.findAll();
    }
    @PostMapping("/insertPost")
    public List<Cliente> insertClientePost(@RequestBody Cliente cliente){

        service.addCliente(cliente);

        return service.findAll();
    }
}
