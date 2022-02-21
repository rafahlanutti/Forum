package br.com.estudos.forum.services

import br.com.estudos.forum.dtos.TopicoRequestDTO
import br.com.estudos.forum.dtos.TopicoResponseDTO
import br.com.estudos.forum.dtos.TopicoUpdateRequestDTO
import br.com.estudos.forum.exceptions.NotFoundException
import br.com.estudos.forum.mapper.TopicoMapper
import br.com.estudos.forum.mapper.TopicoRequestMapper
import br.com.estudos.forum.repository.TopicoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoServiceImpl(
    private val repository: TopicoRepository,
    private val topicoMapper: TopicoMapper,
    private val topicoRequestMapper: TopicoRequestMapper,
    private val notFoundMessage: String = "Objeto não encontrado"
) : TopicoService {

    override fun listar(nomeCurso: String?, paginacao: Pageable): Page<TopicoResponseDTO> {
        val topicos = if(nomeCurso == null) {
            repository.findAll(paginacao)
        } else {
            repository.findByCursoNome(nomeCurso,paginacao)
        }
        return topicos.map { t ->topicoMapper.map(t)}
    }

    override fun buscarPorId(id: Long): TopicoResponseDTO {
        val topico = repository.findById(id).orElseThrow { NotFoundException(notFoundMessage) }
        return topicoMapper.map(topico)
    }

    override fun cadastrar(topico: TopicoRequestDTO): TopicoResponseDTO {
        var created = topicoRequestMapper.map(topico)
        repository.save(created)
        return topicoMapper.map(created)
    }

    override fun atualizar(topico: TopicoUpdateRequestDTO): TopicoResponseDTO {
        val finded = repository.findById(topico.id).orElseThrow { NotFoundException(notFoundMessage) }
        finded.titulo = topico.titulo
        finded.mensagem = topico.mensagem
        repository.save(finded)
        return topicoMapper.map(finded)
    }

    override fun deletar(id: Long) {
        val topico = repository.findById(id).orElseThrow { NotFoundException(notFoundMessage) }
        repository.delete(topico)
    }
}