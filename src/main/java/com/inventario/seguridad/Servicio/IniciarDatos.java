package com.inventario.seguridad.Servicio;

import com.inventario.seguridad.Entidad.CredencialesUsuario;


import com.inventario.seguridad.Entidad.Rol;
import com.inventario.seguridad.Repositorio.CredencialesUsuarioRepositorio;
import com.inventario.seguridad.Repositorio.RolRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class IniciarDatos {
    @Autowired
    private CredencialesUsuarioRepositorio credencialesUsuarioRepositorio;

    @Autowired
    private RolRepositorio rolRepositorio;

    @Bean
    public CommandLineRunner init() {
        return args -> {
            // Verificar si los roles ya existen
            if (rolRepositorio.count() == 0) {
                Rol adminRole = new Rol();
                adminRole.setName("ROLE_ADMIN");
                rolRepositorio.save(adminRole);

                Rol userRole = new Rol();
                userRole.setName("ROLE_USER");
                rolRepositorio.save(userRole);
            }

            // Verificar si los usuarios ya existen
            if (credencialesUsuarioRepositorio.count() == 0) {
                CredencialesUsuario admin = new CredencialesUsuario();
                admin.setUsername("Admin");
                admin.setPassword("1234");

                // Obtener el rol ADMIN
                List<Rol> adminRoles = rolRepositorio.findByName("ROLE_ADMIN");
                if (!adminRoles.isEmpty()) {
                    admin.setRoles(adminRoles);
                }
                credencialesUsuarioRepositorio.save(admin);

                CredencialesUsuario user = new CredencialesUsuario();
                user.setUsername("user");
                user.setPassword("4321");

                // Obtener el rol USER
                List<Rol> userRoles = rolRepositorio.findByName("ROLE_USER");
                if (!userRoles.isEmpty()) {
                    user.setRoles(userRoles);

                }
                credencialesUsuarioRepositorio.save(user);
            }
        };
    }
}
