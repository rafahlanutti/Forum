package br.com.estudos.forum.dtos

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class TopicoUpdateRequestDTO(
    @field:NotNull
    val id: Long,
    @field:NotEmpty
    val titulo: String,
    @field:NotEmpty
    val mensagem: String
)
