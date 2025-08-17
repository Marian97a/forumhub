package br.com.alura.forumhub.service;

import br.com.alura.forumhub.DTO.TopicoRequest;
import br.com.alura.forumhub.DTO.TopicoResponse;
import br.com.alura.forumhub.model.Topico;
import br.com.alura.forumhub.model.Usuario;
import br.com.alura.forumhub.repository.TopicoRepository;
import br.com.alura.forumhub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepo;
    @Autowired private UsuarioRepository usuarioRepo;

    public List<TopicoResponse> listar() {
        return topicoRepo.findAll().stream()
                .map(t -> new TopicoResponse(t.getId(), t.getTitulo(), t.getMensagem(), t.getAutor().getNome()))
                .toList();
    }

    public TopicoResponse criar(TopicoRequest req) {
        Usuario autor = usuarioRepo.findById(req.autorId()).orElseThrow();
        Topico topico = new Topico();
        topico.setTitulo(req.titulo());
        topico.setMensagem(req.mensagem());
        topico.setAutor(autor);
        topicoRepo.save(topico);
        return new TopicoResponse(topico.getId(), topico.getTitulo(), topico.getMensagem(), autor.getNome());
    }

    public TopicoResponse buscar(Long id) {
        Topico t = topicoRepo.findById(id).orElseThrow();
        return new TopicoResponse(t.getId(), t.getTitulo(), t.getMensagem(), t.getAutor().getNome());
    }

    public void atualizar(Long id, TopicoRequest req) {
        Topico t = topicoRepo.findById(id).orElseThrow();
        t.setTitulo(req.titulo());
        t.setMensagem(req.mensagem());
        topicoRepo.save(t);
    }

    public void deletar(Long id) {
        topicoRepo.deleteById(id);
    }
}
