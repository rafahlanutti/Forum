package br.com.estudos.forum.services

import br.com.estudos.forum.dtos.TopicoDTO
import br.com.estudos.forum.model.Topico
import org.springframework.stereotype.Service
import kotlin.math.roundToInt
@Service
class TopicoServiceImpl(private var topicos: List<Topico> = ArrayList(),
                        private var cursoService: CursoService,
                        private var usuarioService: UsuarioService)  : TopicoService {


    override fun listar(): List<Topico> {
        return topicos
    }

    override fun buscarPorId(id: Long): Topico {
        return topicos.stream().filter { t ->
            t.id == id
        }
            .findFirst().get()
    }

    override fun cadastrar(topico: TopicoDTO) {
        topicos = topicos.plus(
            Topico(id = topicos.size + 1L ,
                   titulo = topico.titulo,
                   mensagem =  topico.mensagem,
                   curso = cursoService.buscarPorId(topico.idCurso),
                   autor = usuarioService.buscarPorId(topico.idAutor))
        )
    }
}