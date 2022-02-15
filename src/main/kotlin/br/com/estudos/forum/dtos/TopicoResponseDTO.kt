package br.com.estudos.forum.dtos

import br.com.estudos.forum.model.StatusTopico
import java.time.LocalDateTime

data class TopicoResponseDTO(
    val id: Long?,
    val titulo: String,
    val mensagem: String,
    val status: StatusTopico,
    val dataCriacal: LocalDateTime
)