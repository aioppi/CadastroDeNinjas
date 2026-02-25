-- Migrations para adicionar a coluna "rank" na tabela "tb_cadastro"
-- A coluna "rank" é do tipo INTEGER e tem um valor padrão de 0

ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR(255);