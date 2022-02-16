package br.com.estudos.forum.services

import br.com.estudos.forum.dtos.TopicoRequestDTO
import br.com.estudos.forum.dtos.TopicoResponseDTO
import br.com.estudos.forum.dtos.TopicoUpdateRequestDTO
import br.com.estudos.forum.exceptions.NotFoundException
import br.com.estudos.forum.mapper.TopicoMapper
import br.com.estudos.forum.mapper.TopicoRequestMapper
import br.com.estudos.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoServiceImpl(
    private var topicos: List<Topico> = ArrayList(),
    private val topicoMapper: TopicoMapper,
    private val topicoRequestMapper: TopicoRequestMapper,
    private val notFoundMessage:String = "Objeto não encontrado"
) : TopicoService {

    override fun listar(): List<TopicoResponseDTO> {
        return topicos.stream().map { t ->
            topicoMapper.map(t)
        }.collect(Collectors.toList())
    }

    override fun buscarPorId(id: Long): TopicoResponseDTO {
        val topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()

        return topicoMapper.map(topico)
    }

    override fun cadastrar(topico: TopicoRequestDTO): TopicoResponseDTO {
        var created = topicoRequestMapper.map(topico)
        topicos = topicos.plus(created)
        return topicoMapper.map(created)
    }

    override fun atualizar(topico: TopicoUpdateRequestDTO) : TopicoResponseDTO {
       val finded = topicos.stream().filter{ t -> t.id == topico.id}.findFirst().get()
        val updated = Topico(
            id = finded.id,
            titulo = topico.titulo,
            mensagem = topico.mensagem,
            autor = finded.autor,
            curso = finded.curso,
            respostas = finded.respostas,
            status = finded.status,
            dataCriacao = finded.dataCriacao,
        )
        topicos = topicos.minus(finded).plus(updated)
        return topicoMapper.map(updated)
    }

    override fun deletar(id: Long) {
        val finded = topicos.stream().filter{ t -> t.id == id}.findFirst().orElseThrow{NotFoundException(notFoundMessage)}
        topicos = topicos.minus(finded)
    }
}