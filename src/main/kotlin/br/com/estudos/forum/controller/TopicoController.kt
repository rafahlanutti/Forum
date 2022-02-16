package br.com.estudos.forum.controller

import br.com.estudos.forum.dtos.TopicoRequestDTO
import br.com.estudos.forum.dtos.TopicoResponseDTO
import br.com.estudos.forum.dtos.TopicoUpdateRequestDTO
import br.com.estudos.forum.services.TopicoService
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService) {

    @GetMapping
    fun listar(): List<TopicoResponseDTO> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastrar(@Valid @RequestBody topico: TopicoRequestDTO, uriBuilder: UriComponentsBuilder): ResponseEntity<TopicoResponseDTO> {
        var topicoResponse = service.cadastrar(topico)
        val uri = uriBuilder.path("/topicos/${topicoResponse.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicoResponse)
    }

    @PutMapping
    @Transactional
    fun atualizar(@Valid @RequestBody topico: TopicoUpdateRequestDTO): ResponseEntity<TopicoResponseDTO> {
        return ResponseEntity.ok().body(service.atualizar(topico))
    }

    @DeleteMapping("/{id}")
    @Transactional
    fun deletar(@PathVariable id: Long): ResponseEntity<Void> {
        service.deletar(id)
        return ResponseEntity.noContent().build()
    }
}