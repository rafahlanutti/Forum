package br.com.estudos.forum.repository

import br.com.estudos.forum.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<Usuario, Long> {
}