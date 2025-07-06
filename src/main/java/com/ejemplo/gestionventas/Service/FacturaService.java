package com.ejemplo.gestionventas.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ejemplo.gestionventas.model.Cliente;
import com.ejemplo.gestionventas.model.Factura;
import com.ejemplo.gestionventas.repository.ClienteRepository;
import com.ejemplo.gestionventas.repository.FacturaRepository;

@Service
public class FacturaService {
    
    private final FacturaRepository facturaRepo;
    private final ClienteRepository clienteRepo;

    public FacturaService(FacturaRepository facturaRepo, ClienteRepository clienteRepo) {
        this.facturaRepo = facturaRepo;
        this.clienteRepo = clienteRepo;
    }

    public List<Factura> obtenerTodas() {
      return facturaRepo.findAll();
    }

    public Factura crear(Long clienteId, Factura facturas) {
        Cliente cliente = clienteRepo.findById(clienteId)
                .orElseThrow(()-> new RuntimeException("Cliente no encontrado: " + clienteId)); 

        facturas.setCliente(cliente);
        return facturaRepo.save(facturas);
    }

    public void eliminar(Long id) {
        facturaRepo.deleteById(id);    }
}
