package com.ejemplo.gestionventas.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.gestionventas.Service.FacturaService;
import com.ejemplo.gestionventas.dto.ClienteDTO;
import com.ejemplo.gestionventas.dto.FacturaResponseDTO;
import com.ejemplo.gestionventas.model.Cliente;
import com.ejemplo.gestionventas.model.Factura;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {
    
    private final FacturaService service;

    public FacturaController(FacturaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Factura> listar() {
         return service.obtenerTodas();
    }

     @PostMapping(value = "/cliente/{clienteId}") 
    public ResponseEntity<FacturaResponseDTO> crear(@PathVariable Long clienteId, @Valid @RequestBody Factura factura) {
        Factura creada = service.crear(clienteId, factura);
      
        Cliente cliente = creada.getCliente();

        ClienteDTO clienteDTO = new ClienteDTO(
            cliente.getId(),
            cliente.getNombre(),
            cliente.getCorreo(),
            cliente.getTelefono()
        );

        FacturaResponseDTO response = new FacturaResponseDTO(
           creada.getId(),
           creada.getFecha(),
           creada.getTotal(), 
           clienteDTO);
      
        return ResponseEntity.status(201).body(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
