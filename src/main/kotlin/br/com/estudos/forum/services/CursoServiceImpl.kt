package br.com.estudos.forum.services

import br.com.estudos.forum.model.Curso
import org.springframework.stereotype.Service

@Service
class CursoServiceImpl(private var cursos: List<Curso>) : CursoService {

    init {
        cursos = listOf(Curso(id = 1, nome = "Curso Legal", categoria = "Programacao"))
    }

    override fun buscarPorId(id: Long): Curso { return cursos.stream().filter{ c -> c.id == id }.findFirst().get()}

}