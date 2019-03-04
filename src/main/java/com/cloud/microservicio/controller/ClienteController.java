package com.cloud.microservicio.controller;

import com.cloud.microservicio.config.ClienteConverter;
import com.cloud.microservicio.model.ClienteModel;
import com.cloud.microservicio.repository.Cliente;
import com.cloud.microservicio.service.ServiceCliente;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Qualifier("ServiceClienteEntity")
    @Autowired
    private ServiceCliente service;

    private Log log = LogFactory.getLog(ClienteController.class);

    @Autowired
    private ClienteConverter converter;

    @GetMapping("/listar")
    public String index(Model model){

        model.addAttribute("clientes",service.findAll());
        return "listar";
    }
    @GetMapping("/form")
    public String formularioAddAndUpdate(@RequestParam(name = "id",required =  false) String id,Map<String,Object> map){

        if(id != null) {

            log.info("El id a buscar es "+id);
            map.put("titulo","modificar Usuario");
            Cliente cliente = service.findById(Long.parseLong(id));
            log.info("El cliente tiene el id "+cliente);
            map.put("clientemodel", converter.EntityToEntityModel(cliente));
        }
        else
        {

            map.put("titulo","Ingresar Usuario");
            Cliente cliente = new Cliente();
            ClienteModel modelocliente =  converter.EntityToEntityModel(cliente);
            map.put("clientemodel", modelocliente);

        }
        return "form";
    }

    @PostMapping("/form")
    public String agregar(@ModelAttribute("clientemodel") ClienteModel clientemodel,Model model){


        Cliente cliente = converter.EntityModelToEntity(clientemodel);
        service.addCliente(cliente);

        return "redirect:/cliente/listar";
    }
}
