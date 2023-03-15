--a) Apresente o nome de cada professor cadastrado acompanhado do nome de todas as disciplinas que ele ministra.
SELECT professor.nome NomeProfessor,
 disciplina.nome DisciplinaQueMinistra
FROM professor
 INNER JOIN