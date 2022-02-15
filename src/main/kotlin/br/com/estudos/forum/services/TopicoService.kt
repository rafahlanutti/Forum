package br.com.estudos.forum.services

import br.com.estudos.forum.dtos.TopicoDTO
import br.com.estudos.forum.model.Topico

interface TopicoService {

    fun listar():List<Topico>
    fun buscarPorId(id: Long): Topico
    fun cadastrar(topico: TopicoDTO)
}