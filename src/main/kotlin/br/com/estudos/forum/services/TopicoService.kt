package br.com.estudos.forum.services

import br.com.estudos.forum.dtos.TopicoRequestDTO
import br.com.estudos.forum.dtos.TopicoResponseDTO

interface TopicoService {

    fun listar():List<TopicoResponseDTO>
    fun buscarPorId(id: Long): TopicoResponseDTO
    fun cadastrar(topico: TopicoRequestDTO)
}