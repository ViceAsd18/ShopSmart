package com.ShopSmart.Clientes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ShopSmart.Clientes.models.entities.Cliente;
import com.ShopSmart.Clientes.models.request.ActualizarCliente;
import com.ShopSmart.Clientes.models.request.AgregarCliente;
import com.ShopSmart.Clientes.repositories.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obtenerClientes(){
        return clienteRepository.findAll();
    }

    public Cliente obtenerClientePorId(Integer id_cliente){

        Cliente clienteEncontrado = clienteRepository.findById(id_cliente).orElse(null);

        if (clienteEncontrado == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "No se encontró el cliente con ID: " + id_cliente
            );
        }

        return clienteEncontrado;
    }

    public Cliente crearCliente(AgregarCliente cliente){

        Cliente nuevoCliente = new Cliente();

        if(clienteRepository.existsByRun_cli(cliente.getRun_cli())){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Ya existe un cliente con el RUN: " + cliente.getRun_cli()
            );
        }

        if(clienteRepository.existsByEmail_cli(cliente.getEmail_cli())){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Ya existe un cliente con el email: " + cliente.getEmail_cli()
            );
        }

        nuevoCliente.setPnombre_cli(cliente.getPnombre_cli());
        nuevoCliente.setSnombre_cli(cliente.getSnombre_cli());
        nuevoCliente.setApaterno_cli(cliente.getApaterno_cli());
        nuevoCliente.setAmaterno_cli(cliente.getAmaterno_cli());
        nuevoCliente.setRun_cli(cliente.getRun_cli());
        nuevoCliente.setEmail_cli(cliente.getEmail_cli());
        nuevoCliente.setTelefono_cli(cliente.getTelefono_cli());
        nuevoCliente.setContrasena(cliente.getContrasena());
        
        return clienteRepository.save(nuevoCliente);

    }

    public Cliente actualizarCliente(ActualizarCliente cliente, Integer id_cliente){

        Cliente clienteEncontrado = obtenerClientePorId(id_cliente);

        clienteEncontrado.setPnombre_cli(cliente.getPnombre_cli());
        clienteEncontrado.setSnombre_cli(cliente.getSnombre_cli());
        clienteEncontrado.setApaterno_cli(cliente.getApaterno_cli());
        clienteEncontrado.setAmaterno_cli(cliente.getAmaterno_cli());
        clienteEncontrado.setEmail_cli(cliente.getEmail_cli());
        clienteEncontrado.setTelefono_cli(cliente.getTelefono_cli());
        clienteEncontrado.setContrasena(cliente.getContrasena());

        return clienteRepository.save(clienteEncontrado);
    }



    public String eliminarCliente(Integer id_cliente){

        Cliente clienteEncontrado = obtenerClientePorId(id_cliente);

        clienteRepository.deleteById(clienteEncontrado.getId_cliente());

        return "Cliente eliminado correctamente";
    }
    

}
