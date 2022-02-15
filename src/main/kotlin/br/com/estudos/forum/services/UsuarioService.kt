package br.com.estudos.forum.services

import br.com.estudos.forum.model.Usuario

interface UsuarioService {

    fun buscarPorId(id: Long): Usuario
}
