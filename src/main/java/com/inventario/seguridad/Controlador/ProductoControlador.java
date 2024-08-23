package com.inventario.seguridad.Controlador;

import com.inventario.seguridad.Entidad.Producto;
import com.inventario.seguridad.Servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class ProductoControlador {

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("/home")
    public String home(){
        return "/index";
    }

    // Leer productos
    @GetMapping("/productos")
    public String mostrarProductos(Model model){
        List<Producto> productos = productoServicio.getProducto();
        model.addAttribute("productos", productos);
        return "/productos/producto";
    }
    @GetMapping("/entradas")
    public String mostrarEntradas(Model model) {
        List<Producto> productos = productoServicio.getProducto();
        model.addAttribute("productos", productos);
        return "/productos/entradas"; // html  tabla de entradas
    }
    @GetMapping("/salidas")
    public String mostrarSalidas(Model model) {
        List<Producto> productos = productoServicio.getProducto();
        model.addAttribute("productos", productos);
        return "/productos/salidas"; // html  tabla de salidas
    }

    // Crear productos
    @GetMapping("/productos/modal")
    public String modalFormulario(Model model){

        model.addAttribute("producto", new Producto());
        return "/productos/modal";
    }
    @PostMapping("/productos/guardar")
    public String guardar(Producto producto){
        producto.calcularTotal(); // Calcula el total antes de guardar
        productoServicio.guardar(producto);
        return "redirect:/productos";
    }
    // Crear entradas
    @GetMapping("/productos/entradas")
    public String modalEntrada(Model model){

        model.addAttribute("producto", new Producto());
        return "/productos/modalEntradas";
    }
    @PostMapping("/productos/entradas/guardar")
    public String guardarEntrada(Producto producto){
        producto.calcularTotal(); // Calcula el total antes de guardar
        productoServicio.guardar(producto);
        return "redirect:/entradas";
    }
    // Crear salidas
    @GetMapping("/productos/salidas")
    public String modalSalida(Model model){

        model.addAttribute("producto", new Producto());
        return "/productos/modalSalidas";
    }
    @PostMapping("/productos/salidas/guardar")
    public String guardarSalidas(Producto producto){
        producto.calcularTotal(); // Calcula el total antes de guardar
        productoServicio.guardar(producto);
        return "redirect:/salidas";
    }





    // Actualizar datos del producto
    @GetMapping("/productos/editar/{productoId}")
    public String actualiza(@PathVariable Long productoId, Model model){
        Optional<Producto> producto = productoServicio.getProducto(productoId);
        if (producto.isPresent()) {
            model.addAttribute("producto", producto.get());
        } else {
            // Manejar el caso donde el producto no existe
            return "redirect:/productos";
        }
        return "/productos/modal";
    }

    // Eliminar
    @GetMapping("/productos/eliminar/{productoId}")
    public String elimina(@PathVariable("productoId") Long productoId){
        productoServicio.eliminar(productoId);
        return "redirect:/productos";
    }

    @GetMapping("/buscar")
    public String buscarProductos(@RequestParam("query") String query, Model model) {
        List<Producto> productos = productoServicio.buscarPorNombre(query);
        model.addAttribute("productos", productos);
        return "productos";
    }
}
