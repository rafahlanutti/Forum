package br.com.estudos.forum.mapper

import br.com.estudos.forum.dtos.TopicoResponseDTO
import br.com.estudos.forum.model.Topico
import org.springframework.stereotype.Component

@Component
class TopicoMapper : Mapper<Topico, TopicoResponseDTO> {

    override fun map(t: Topico): TopicoResponseDTO {
      return  TopicoResponseDTO(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            status = t.status,
            dataCriacal = t.dataCriacao
        )
    }
}