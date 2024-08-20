    package com.inventario.seguridad.Servicio;

    import com.inventario.seguridad.Entidad.Producto;
    import com.inventario.seguridad.Repositorio.ProductoRepositorio;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.dao.EmptyResultDataAccessException;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.Optional;

    @Service
    public class ProductoServicio {
        @Autowired
        ProductoRepositorio productoRepositorio;
        public List<Producto> getProducto(){
            return productoRepositorio.findAll();
        }
        public Optional<Producto> getProducto(Long id){
            return productoRepositorio.findById(id);
        }
        public void guardar(Producto producto){
            productoRepositorio.save(producto);
        }
        public void eliminar(Long id){
            try {
                productoRepositorio.deleteById(id);
            } catch (EmptyResultDataAccessException e) {
                // Manejar el caso donde el producto no existe
                System.out.println("El producto con ID " + id + " no existe.");
            }
        }

    }
