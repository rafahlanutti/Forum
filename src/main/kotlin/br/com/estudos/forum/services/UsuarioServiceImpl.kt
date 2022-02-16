package br.com.estudos.forum.services

import br.com.estudos.forum.model.Usuario
import br.com.estudos.forum.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioServiceImpl(private val repository: UsuarioRepository) : UsuarioService {

    override fun buscarPorId(id: Long): Usuario {
        return repository.getById(id)
    }

}