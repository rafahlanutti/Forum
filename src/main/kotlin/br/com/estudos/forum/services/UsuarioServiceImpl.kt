package br.com.estudos.forum.services

import br.com.estudos.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class UsuarioServiceImpl(private var usuarios: List<Usuario>) : UsuarioService {

    init {
        usuarios = listOf(Usuario(id = 1, nome = "Curso Legal", email = "email@email.com"))
    }

    override fun buscarPorId(id: Long): Usuario { return usuarios.stream().filter{ c -> c.id == id }.findFirst().get()}

}