-- Arthur Quilião Mangini Macedo 227 Informática
-- Tópicos em Linguagem de Programação 1: Lista 1

-- a) Apresente o nome de todos os produtos que são produzidos com chocolate e pesam, em média, mais de 3kg e custam mais de R$126,00.
SELECT doce.nome AS Nome_do_Doce 
FROM doce 
 INNER JOIN doceingrediente ON doce.id = doceingrediente.iddoce 
 INNER JOIN ingrediente ON doceingrediente.idingrediente = ingrediente.id 
WHERE ingrediente.nome = 'chocolate' 
 AND doce.pesomedio > 3 AND doce.valor > 126;

-- b) Apresente a média de pesos de todos os doces cadastrados.
SELECT AVG(doce.pesomedio) AS Média_de_Pesos_Médios 
FROM doce;

-- c) Apresente o nome de cada confeiteiro junto com o nome de todos os cursos relacionados a ele.
SELECT confeiteiro.nome AS Nome_do_confeiteiro, curso.nome Curso_do_Confeiteiro 
FROM confeiteiro 
 INNER JOIN cursoconfeiteiro ON confeiteiro.id = cursoconfeiteiro.idconfeiteiro 
 INNER JOIN curso ON cursoconfeiteiro.idcurso = curso.id;

-- d) Apresente o nome de todos os cursos ordenados em ordem decrescente de duração.
SELECT curso.nome AS Cursos_por_Ordem_Decrescente_de_Duração 
FROM curso ORDER BY curso.duracao DESC;

-- e) Apresente o nome de todos os cursos que possuem duração superior a 20 horas, são ofertados pela instituição "Mundo dos doces" e possuem algum aluno com a especialidade em "Bolos".
SELECT curso.nome AS Cursos_de_Mais_de_20_Horas_da_Instituição_Mundodosdoces_e_com_Aluno_com_Especialidade_em_Bolos 
FROM curso 
 INNER JOIN cursoinstituicao ON curso.id = cursoinstituicao.idcurso 
 INNER JOIN instituicao ON cursoinstituicao.idinstituicao = instituicao.id 
 INNER JOIN cursoconfeiteiro ON curso.id = cursoconfeiteiro.idcurso 
 INNER JOIN confeiteiro ON cursoconfeiteiro.idconfeiteiro = confeiteiro.id
WHERE curso.duracao > 20
 AND instituicao.nome = 'Mundo dos doces'
 AND confeiteiro.especialidade = 'Bolos';

-- f) Apresente o nome de cada ingrediente, o nome dos doces que eles estão vinculados e o nome do confeiteiro que criou cada doce.
SELECT ingrediente.nome AS Ingrediente,
 doce.nome AS Doce_composto_pelo_Ingrediente,
 confeiteiro.nome AS Confeiteiro_criador_do_Doce
FROM ingrediente 
 INNER JOIN doceingrediente ON ingrediente.id = doceingrediente.id.ingrediente 
 INNER JOIN doce ON doceingrediente.iddoce = doce.id
 INNER JOIN confeiteiro ON doce.idconfeiteiro = confeiteiro.id;

---- g) Apresente o nome dos confeiteiros que fizeram algum curso da modalidade "Bolos para casamento" com duração de 80 horas e criaram algum doce que contenha o ingrediente "leite condensado".
--SELECT confeiteiro.nome AS
-- Confeiteiro_Curso_Modalidade_BoloCasamento_Doce_Ingrediente_LeiteCondensado
--FROM confeiteiro
-- INNER JOIN cursoconfeiteiro ON confeiteiro.id = cursoconfeiterio.idconfeiterio
-- INNER JOIN curso ON cursoconfeiteiro.idcurso = curso.id
-- INNER JOIN doce ON confeiteiro.id = doce.idconfeiteiro
-- INNER JOIN doceingrediente ON doce.id = doceingrediente.iddoce
-- INNER JOIN ingrediente ON doceingrediente.idingrediente = ingrediente.id
--WHERE curso.modalidade = 'Bolos para casamento'
-- AND curso.duracao = 80
-- AND ingrediente.nome = 'leite condensado';

-- g) Apresente o nome e a modalidade (especialidade) dos confeiteiros que fizeram algum curso com o nome "Bolos para casamento" com duração de 80 horas e que estão vinculados a algum doce.
SELECT confeiteiro.nome AS Confeiteiro_Cursou80h_CriouDoce,
 confeiteiro.especialidade AS EspecialidadeConfeiteiro
FROM confeiteiro
 INNER JOIN cursoconfeiteiro ON confeiteiro.id = cursoconfeiteiro.idconfeiteiro
 INNER JOIN curso ON cursoconfeiteiro.idcurso = curso.id
 INNER JOIN doce ON confeiteiro.id = doce.idconfeiteiro
WHERE curso.nome = 'Bolos para casamento'
 AND curso.duracao = 80;

-- h) Apresente o nome dos confeiteiros que fizeram algum curso da modalidade "Bolos para casamento" e criaram algum doce que contenha o ingrediente "leite condensado".
SELECT confeiteiro.nome AS Confeiteiro_Cursou_BolosCasamento_Criou_Doce_Ingrediente_Leite_Condensado
FROM confeiteiro
 INNER JOIN cursoconfeiteiro ON confeiteiro.id = cursoconfeiteiro.idconfeiteiro
 INNER JOIN curso ON cursoconfeiteiro.idcurso = curso.id
 INNER JOIN doce ON confeiteiro.id = doce.idconfeiteiro
 INNER JOIN doceingrediente ON doce.id = doceingrediente.iddoce
 INNER JOIN ingrediente ON doceingrediente.idingrediente = ingrediente.id
WHERE curso.modalidade = 'Bolos para casamento'
 AND ingrediente.nome = 'leite condensado';

-- i) Apresente o nome de todos os doces que possuem "chocolate" no nome.
SELECT nome 
FROM doce
WHERE nome LIKE '%chocolate%'