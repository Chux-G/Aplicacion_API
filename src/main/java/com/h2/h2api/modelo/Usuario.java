package com.h2.h2api.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity /*Identificacion de la Entidad*/
@Table /*Especificacion de Tabla*/
@Data /*Declaracion de la Accesibilidad*/
@AllArgsConstructor /*Agregar el Constructor*/
@NoArgsConstructor
public class Usuario {

    //Atributos del Modelo de Entidad
    @Id /*Llave Primaria*/
    @GeneratedValue(strategy = GenerationType.IDENTITY) /*Especificaciones de la Llave Primaria Ej: Secuencial o Auto - Incrementada*/
    private Long id;
    @Column(nullable = false)/*No Dejar Vacio cuando se haga el POST*/
    private String nombre;
    @Column(nullable = false)/*No Dejar Vacio cuando se haga el POST*/
    private String apellido;
    @Column(length = 16)/*Cantidad de maxima de caracteres*/
    private String telefono;
    @Column(nullable = false)/*No Dejar Vacio cuando se haga el POST*/
    private String direccion;

}
