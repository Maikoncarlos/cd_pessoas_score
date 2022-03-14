--INSERT INTO tb_pessoa (nome, telefone, idade, cidade, estado, score) VALUES ('Ingrid', '11 9876-5431',  42, 'São Paulo', 'São Paulo', 150);
--INSERT INTO tb_pessoa (nome, telefone, idade, cidade, estado, score) VALUES ('Netly',  '11 9876-5432',  35, 'São Paulo', 'São Paulo', 320);
--INSERT INTO tb_pessoa (nome, telefone, idade, cidade, estado, score) VALUES ('Wagner', '11 9876-5433',  62, 'São Paulo', 'São Paulo', 680);
--INSERT INTO tb_pessoa (nome, telefone, idade, cidade, estado, score) VALUES ('Maikon', '11 9876-5434',  32, 'São Paulo', 'São Paulo',1000);


INSERT INTO tb_score (score_Descricao, score_Inicial, score_Final) VALUES ('Insuficiente', 0, 200);
INSERT INTO tb_score (score_Descricao, score_Inicial, score_Final) VALUES ('Inaceitável', 201, 500);
INSERT INTO tb_score (score_Descricao, score_Inicial, score_Final) VALUES ('Aceitável', 501, 700);
INSERT INTO tb_score (score_Descricao, score_Inicial, score_Final) VALUES ('Recomendável', 701, 1000);