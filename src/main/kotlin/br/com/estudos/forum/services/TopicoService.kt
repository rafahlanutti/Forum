package br.com.estudos.forum.services

import br.com.estudos.forum.dtos.TopicoRequestDTO
import br.com.estudos.forum.dtos.TopicoResponseDTO
import br.com.estudos.forum.dtos.TopicoUpdateRequestDTO
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface TopicoService {

    fun listar(nomeCurso: String?, paginacao: Pageable): Page<TopicoResponseDTO>
    fun buscarPorId(id: Long): TopicoResponseDTO
    fun cadastrar(topico: TopicoRequestDTO): TopicoResponseDTO
    fun atualizar(topico: TopicoUpdateRequestDTO): TopicoResponseDTO
    fun deletar(id: Long)
}