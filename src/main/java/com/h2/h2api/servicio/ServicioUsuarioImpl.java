package com.h2.h2api.servicio;

import com.h2.h2api.modelo.Usuario;
import com.h2.h2api.repositorio.RepositorioUsuario;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service /*Indicacion del servicio en la clase*/
public class ServicioUsuarioImpl implements ServicioUsuario{

    private final RepositorioUsuario repositorioUsuario;

    public ServicioUsuarioImpl(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    @Override
    public Optional<Usuario> obtenerUsuario(Long idUsuario) {
        return Optional.ofNullable(repositorioUsuario.findById(idUsuario).orElseThrow(() -> {
            throw new RuntimeException();
        }));
    }

    @Override
    public Usuario usuarioAModificar(Long id, Usuario usuarioModificar) {
        Usuario usuarioBuscado = repositorioUsuario.findById(id).get();
        usuarioBuscado.setDireccion(usuarioModificar.getDireccion());
        usuarioBuscado.setTelefono(usuarioModificar.getTelefono());
        return repositorioUsuario.save(usuarioBuscado);
    }

    @Override
    public boolean usuarioEliminar(Long id) {
        try {
            repositorioUsuario.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
