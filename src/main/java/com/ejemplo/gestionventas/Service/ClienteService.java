package com.ejemplo.gestionventas.Service;

import org.springframework.stereotype.Service;

import com.ejemplo.gestionventas.model.Cliente;
import com.ejemplo.gestionventas.repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public List<Cliente> obtenerTodos() {
        return repository.findAll();
    }

    public Cliente crear(Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente actualizar(Long id, Cliente clienteActualizado) {
        return repository.findById(id).map(cliente -> {
            cliente.setNombre(clienteActualizado.getNombre());
            cliente.setCorreo(clienteActualizado.getCorreo());
            cliente.setTelefono(clienteActualizado.getTelefono());
            return repository.save(cliente);
        }).orElseThrow(() -> new RuntimeException("Cliente no encontrado con id " + id));
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}