package br.com.estudos.forum.dtos

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class TopicoRequestDTO (
   @field:NotEmpty(message = "O titulo não pode ser vazio") val titulo: String,
   @field:NotEmpty(message = "A mensagem não pode ser vazia") val mensagem: String,
   @field:NotNull(message =  "O curso deve ser fornecido") val idCurso: Long,
   @field:NotNull(message = "O autor deve ser fornecido") val idAutor: Long
)