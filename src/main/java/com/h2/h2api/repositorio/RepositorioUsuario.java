package com.h2.h2api.repositorio;

import com.h2.h2api.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {

}
