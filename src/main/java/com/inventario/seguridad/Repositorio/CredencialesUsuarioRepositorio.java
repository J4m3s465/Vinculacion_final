package com.inventario.seguridad.Repositorio;


import com.inventario.seguridad.Entidad.CredencialesUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredencialesUsuarioRepositorio extends JpaRepository <CredencialesUsuario, Long> {
    CredencialesUsuario findByUsername(String username);
}