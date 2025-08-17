package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.DTO.TopicoRequest;
import br.com.alura.forumhub.DTO.TopicoResponse;
import br.com.alura.forumhub.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoService service;

    @GetMapping
    public List<TopicoResponse> listar() {
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<TopicoResponse> criar(@RequestBody TopicoRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(req));
    }

    @GetMapping("/{id}")
    public TopicoResponse buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody TopicoRequest req) {
        service.atualizar(id, req);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

