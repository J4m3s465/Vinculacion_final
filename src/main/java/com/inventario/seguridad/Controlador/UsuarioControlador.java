package com.inventario.seguridad.Controlador;

import com.inventario.seguridad.Entidad.Usuario;
import com.inventario.seguridad.Servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class UsuarioControlador {
    @Autowired
    private UsuarioServicio usuarioServicio;

   /* @GetMapping("/usuario_vista")
    public String mostrarProductos(Model model){
        List<Usuario> alumnos = usuarioServicio.getAlumno();
        model.addAttribute("alumnos", alumnos);
        return "/alumno/vw_alumno";
    }*/

}
