package com.inventario.seguridad.Entidad;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario_inventario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long usuarioId;
    private String username;
    private String password;

  //  @Column(unique = true, nullable = false)


}
