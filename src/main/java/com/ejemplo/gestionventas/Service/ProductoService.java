package com.ejemplo.gestionventas.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ejemplo.gestionventas.model.Producto;
import com.ejemplo.gestionventas.repository.ProductoRepository;

@Service
public class ProductoService {
    private final ProductoRepository repo;

    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    public List<Producto> obtenerTodos() {
       return repo.findAll();
    }

    public Optional<Producto> obtenerPorId(Long id) {
       return repo.findById(id);
    }

    public Producto crear(Producto producto) {
        return repo.save(producto);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
