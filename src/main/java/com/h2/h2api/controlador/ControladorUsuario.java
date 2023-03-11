package com.h2.h2api.controlador;

import com.h2.h2api.modelo.Usuario;
import com.h2.h2api.servicio.ServicioUsuario;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController /*Indicacion del controlador en la clase*/
@RequestMapping("/usuarios") /*Indicacion de la ruta que debe seguir el controlador*/
public class ControladorUsuario {

    private final ServicioUsuario servicioUsuario;

    public ControladorUsuario(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    @PostMapping /*Indicacion que se guardan los metodos del controlador*/
    public ResponseEntity guardarUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity(servicioUsuario.guardarUsuario(usuario), HttpStatus.CREATED);
    }

    @GetMapping("/{id}") /*Indicacion que se obtienen los recursos a partir del id del usuario*/
    public ResponseEntity obtenerUsuario(@PathVariable("id") Long idUsuario){
        return new ResponseEntity(servicioUsuario.obtenerUsuario(idUsuario), HttpStatus.OK);
    }

    @PutMapping("/{id}") /*Indicacion que se modifican los recursos a partir del id del usuario*/
    public ResponseEntity modificarUsuario(@PathVariable("id") Long idUsuario, @RequestBody Usuario usuario){
        return new ResponseEntity(servicioUsuario.usuarioAModificar(idUsuario, usuario), HttpStatus.OK);
    }

    @DeleteMapping("/{id}") /*Indicacion que se eliminan los recursos a partir del id del usuario*/
    public ResponseEntity modificarUsuario(@PathVariable("id") Long idUsuario){
        boolean respuesta = servicioUsuario.usuarioEliminar(idUsuario);
        if(respuesta == true){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
