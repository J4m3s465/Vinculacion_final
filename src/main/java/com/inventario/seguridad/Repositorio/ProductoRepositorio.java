package com.inventario.seguridad.Repositorio;

import com.inventario.seguridad.Entidad.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
    List<Producto> findByNombreContaining(String nombre);
}
