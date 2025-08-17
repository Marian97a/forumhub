INSERT INTO usuario (nome, email, senha) VALUES
('Maria Teste', 'maria@forumhub.com', '$2a$10$7QJwYxYxYxYxYxYxYxYxYexYxYxYxYxYxYxYxYxYxYxYxYxYxYxYxYxYxY'); -- senha: 123456 (bcrypt)

INSERT INTO usuario_roles (usuario_id, roles) VALUES
(1, 'USER');

INSERT INTO topico (titulo, mensagem, data_criacao, autor_id) VALUES
('Primeiro Tópico', 'Esse é o conteúdo do primeiro tópico.', NOW(), 1);

INSERT INTO resposta (mensagem, data_criacao, autor_id, topico_id) VALUES
('Essa é uma resposta ao primeiro tópico.', NOW(), 1, 1);
