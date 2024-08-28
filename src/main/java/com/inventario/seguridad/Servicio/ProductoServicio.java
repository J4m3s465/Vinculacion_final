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
        public List<Producto> getEntrada() {return productoRepositorio.findAll(); }
        public Optional<Producto> getEntrada(Long id){
            return productoRepositorio.findById(id);
        }
        public List<Producto> getSalida() {return productoRepositorio.findAll(); }
        public Optional<Producto> getSalida(Long id){
            return productoRepositorio.findById(id);
        }
        public void guardar(Producto producto){
            productoRepositorio.save(producto);
        }
        public Producto actualizarEntradas(Long productoId, int entradas) {
            Optional<Producto> productoOpt = productoRepositorio.findById(productoId);
            if (productoOpt.isPresent()) {
                Producto producto = productoOpt.get();
                producto.setEntradas(producto.getEntradas() + entradas);
                producto.calcularTotal();
                return productoRepositorio.save(producto);
            }
            return null;
        }

        public Producto actualizarSalidas(Long productoId, int salidas) {
            Optional<Producto> productoOpt = productoRepositorio.findById(productoId);
            if (productoOpt.isPresent()) {
                Producto producto = productoOpt.get();
                producto.setSalidas(producto.getSalidas() + salidas);
                producto.calcularTotal();
                return productoRepositorio.save(producto);
            }
            return null;
        }
        public void guardarEntrada(Producto producto){
            productoRepositorio.save(producto);
        }
        public void guardarSalida(Producto producto){
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
        public void eliminarEntrada(Long id){
            try {
                productoRepositorio.deleteById(id);
            } catch (EmptyResultDataAccessException e) {
                // Manejar el caso donde el producto no existe
                System.out.println("El producto con ID " + id + " no existe.");
            }
        }
        public void eliminarSalida(Long id){
            try {
                productoRepositorio.deleteById(id);
            } catch (EmptyResultDataAccessException e) {
                // Manejar el caso donde el producto no existe
                System.out.println("El producto con ID " + id + " no existe.");
            }
        }
        public List<Producto> buscarPorNombre(String productoNombre) {
            return productoRepositorio.findByNombreContaining(productoNombre);
        }

    }
