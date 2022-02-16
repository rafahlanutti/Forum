package br.com.estudos.forum.repository

import br.com.estudos.forum.model.Topico
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository : JpaRepository<Topico, Long> {
}