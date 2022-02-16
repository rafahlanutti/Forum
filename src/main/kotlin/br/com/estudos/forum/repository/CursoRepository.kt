package br.com.estudos.forum.repository

import br.com.estudos.forum.model.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository : JpaRepository<Curso, Long> {
}