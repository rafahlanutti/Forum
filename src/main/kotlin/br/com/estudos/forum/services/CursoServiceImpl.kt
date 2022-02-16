package br.com.estudos.forum.services

import br.com.estudos.forum.model.Curso
import br.com.estudos.forum.repository.CursoRepository
import org.springframework.stereotype.Service

@Service
class CursoServiceImpl(private val repository: CursoRepository) : CursoService {

    override fun buscarPorId(id: Long): Curso {
        return repository.getById(id)
    }

}