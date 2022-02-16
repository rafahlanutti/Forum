package br.com.estudos.forum.mapper

import br.com.estudos.forum.dtos.TopicoRequestDTO
import br.com.estudos.forum.model.Topico
import br.com.estudos.forum.services.CursoService
import br.com.estudos.forum.services.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoRequestMapper(private val cursoService: CursoService,
                          private val usuarioService: UsuarioService,
                          private var identity: Long = 0) : Mapper<TopicoRequestDTO, Topico> {

    override fun map(topico: TopicoRequestDTO): Topico {
        return Topico(
            titulo = topico.titulo,
            mensagem = topico.mensagem,
            curso = cursoService.buscarPorId(topico.idCurso),
            autor = usuarioService.buscarPorId(topico.idAutor)
        )
    }

}
