package com.inventario.seguridad.Repositorio;

import com.inventario.seguridad.Entidad.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolRepositorio extends JpaRepository <Rol, Long> {
    List<Rol> findByName(String name);
}