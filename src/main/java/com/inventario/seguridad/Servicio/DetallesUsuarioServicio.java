package com.inventario.seguridad.Servicio;


import com.inventario.seguridad.Entidad.CredencialesUsuario;
import com.inventario.seguridad.Entidad.Rol;
import com.inventario.seguridad.Repositorio.CredencialesUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetallesUsuarioServicio implements UserDetailsService {
    @Autowired
    private CredencialesUsuarioRepositorio credencialesUsuarioRepositorio;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CredencialesUsuario credencialesUsuario = credencialesUsuarioRepositorio.findByUsername(username);

        if (credencialesUsuario == null) {
            throw new UsernameNotFoundException("USUARIO INCORRECTO: " + username);
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Rol rol : credencialesUsuario.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(rol.getName()));
        }

        return new User(credencialesUsuario.getUsername(), credencialesUsuario.getPassword(), authorities);
    }

}