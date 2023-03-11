package com.h2.h2api.servicio;

import com.h2.h2api.modelo.Usuario;

import java.util.Optional;

public interface ServicioUsuario { //Creacion de los metodos para la Interfaz
    Usuario guardarUsuario(Usuario usuario); //Declaracion del metodo para guargar el usuario

    Optional<Usuario> obtenerUsuario(Long idUsuario); //Declaracion del metodo para obtener el usuario

    Usuario usuarioAModificar(Long id, Usuario usuarioModificar); //Declaracion del metodo para modificar el usuario

    boolean usuarioEliminar(Long id); //Declaracion del metodo para eliminar el usuario

}
