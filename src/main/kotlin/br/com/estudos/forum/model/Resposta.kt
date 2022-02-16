package br.com.estudos.forum.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class Resposta(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val mensagem: String,
    val dataCriacao: LocalDateTime,
    @ManyToOne
    val autor: Usuario,
    @ManyToOne
    val topico: Topico,
    val solucao: Boolean
)
