--a) Apresente o nome de cada professor cadastrado acompanhado do nome de todas as disciplinas que ele ministra.
SELECT professor.nome NomeProfessor,
 disciplina.nome DisciplinaQueMinistra
FROM professor
 INNER JOIN disciplina ON professor.id = idprofessor;

--b) Apresente o nome de todos os alunos cadastrados em ordem decrescente de idade.
SELECT aluno.nome NomeAlunoPorIdadeDecrescente
 FROM aluno
 ORDER BY aluno.idade DESC;

--c) Apresente o nome de todas as disciplinas cadastradas, o nome do curso que elas estão relacionadas bem como o nome do professor que ministra cada uma das disciplinas.
SELECT disciplina.nome NomeDisciplina,
 