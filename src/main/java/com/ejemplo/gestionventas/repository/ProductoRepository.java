package com.ejemplo.gestionventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ejemplo.gestionventas.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
   
}
