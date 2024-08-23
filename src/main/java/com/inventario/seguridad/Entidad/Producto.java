package com.inventario.seguridad.Entidad;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "productos_registro")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productoId;
    private String productoNombre;
    private String descripcion;
    private String nombre;
    private int stockInicial;
    private int entradas;
    private int salidas;
    private int facturaEntrada;
    private int facturaSalida;
    private LocalDate fechaEntrada;
    private LocalDate  fechaSalida;

    private int total;

    public void calcularTotal() {
        this.total = this.entradas + this.stockInicial - this.salidas;
    }
}
