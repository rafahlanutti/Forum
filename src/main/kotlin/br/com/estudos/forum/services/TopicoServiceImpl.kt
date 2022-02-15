package br.com.estudos.forum.services

import br.com.estudos.forum.dtos.TopicoRequestDTO
import br.com.estudos.forum.dtos.TopicoResponseDTO
import br.com.estudos.forum.mapper.Mapper
import br.com.estudos.forum.mapper.TopicoMapper
import br.com.estudos.forum.mapper.TopicoRequestMapper
import br.com.estudos.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoServiceImpl(
    private var topicos: List<Topico> = ArrayList(),
    private val topicoMapper: TopicoMapper,
    private val topicoRequestMapper: TopicoRequestMapper
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

    override fun cadastrar(topico: TopicoRequestDTO) {
        topicos = topicos.plus(topicoRequestMapper.map(topico))
    }
}