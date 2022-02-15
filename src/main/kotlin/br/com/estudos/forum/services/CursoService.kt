package br.com.estudos.forum.services

import br.com.estudos.forum.model.Curso

interface CursoService {

    fun buscarPorId(id: Long): Curso
}
