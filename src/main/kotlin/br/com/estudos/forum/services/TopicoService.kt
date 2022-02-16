package br.com.estudos.forum.services

import br.com.estudos.forum.dtos.TopicoRequestDTO
import br.com.estudos.forum.dtos.TopicoResponseDTO
import br.com.estudos.forum.dtos.TopicoUpdateRequestDTO

interface TopicoService {

    fun listar(): List<TopicoResponseDTO>
    fun buscarPorId(id: Long): TopicoResponseDTO
    fun cadastrar(topico: TopicoRequestDTO): TopicoResponseDTO
    fun atualizar(topico: TopicoUpdateRequestDTO): TopicoResponseDTO
    fun deletar(id: Long)
}