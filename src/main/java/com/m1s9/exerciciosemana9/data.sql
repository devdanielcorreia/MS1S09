INSERT INTO Livro (titulo, autor, anoPublicacao) VALUES ('Dom Casmurro', 'Machado de Assis', 1899);
INSERT INTO Membro (nome, endereco, telefone) VALUES ('José Silva', 'Rua dos Bobos, 0', '123456789');
INSERT INTO Visitante (nome, telefone) VALUES ('Maria Oliveira', '987654321');
INSERT INTO Bibliotecario (nome, email, senha) VALUES ('Ana Pereira', 'ana@biblioteca.com', 'senha123');


INSERT INTO Emprestimo (id_livro, id_membro, dataEmprestimo, dataDevolucao) VALUES (1, 1, '2023-01-01', '2023-01-15');
