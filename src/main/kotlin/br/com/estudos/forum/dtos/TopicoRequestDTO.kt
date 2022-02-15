package br.com.estudos.forum.dtos

data class TopicoRequestDTO (
    val titulo: String,
    val mensagem: String,
    val idCurso: Long,
    val idAutor: Long
)