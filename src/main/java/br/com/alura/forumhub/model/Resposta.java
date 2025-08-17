package br.com.alura.forumhub.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @ManyToOne
    private Topico topico;

    @ManyToOne
    private Usuario autor;
}

