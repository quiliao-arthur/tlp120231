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
 curso.nome CursoDaDisciplina,
 professor.nome ProfessorMinistrante
FROM disciplina
 INNER JOIN professor ON idprofessor = professor.id
 INNER JOIN disciplinacurso ON disciplina.id=iddisciplina
 INNER JOIN curso ON idcurso=curso.id;

--d) Apresente o nome de todos os professores que possuem doutorado e o nome da universidade que eles trabalham.
SELECT professor.nome ProfessoresDoutores,
 universidade.nome UniversidadeAtuacao
FROM professor
 INNER JOIN universidade ON iduniversidade=universidade.id
WHERE professor.titulacao = 'Doutor';

--e) Apresente o nome das universidades que possuem professores que atuam na área de programação de computadores, que possuem mestrado e que ministram alguma disciplina com carga horária superior a 40 horas.
SELECT DISTINCT universidade.nome 
 Universidade_ProfessoresMestresProgramaçãoComputadores_DisciplinaMaisde40H
FROM universidade
 INNER JOIN professor ON universidade.id=iduniversidade
 INNER JOIN disciplina ON professor.id=idprofessor
WHERE professor.areadeatuacao = 'Programação de Computadores'
 AND professor.titulacao = 'Mestre'
 AND disciplina.cargahoraria>40;

--f) Apresente o nome de todos os cursos que possuem disciplinas ministradas por professores com mestrado que atuam na área de matemática. O curso apresenteado deve ter algum aluno do sexo masculino.
SELECT DISTINCT curso.nome
 Curso_ProfessorMestreMatemática_AlunoMasculino
FROM curso 
 INNER JOIN aluno ON curso.id=aluno.idcurso
 INNER JOIN disciplinacurso ON curso.id=disciplinacurso.idcurso
 INNER JOIN disciplina ON iddisciplina=disciplina.id
 INNER JOIN professor ON idprofessor=professor.id
WHERE professor.titulacao = 'Mestre'
 AND professor.areadeatuacao = 'Matemática'
 AND aluno.sexo = 'Masculino';

--g) Apresente o nome das universidades que possuem professores que ministram a disciplina de ética, com carga horária de 20 horas e que está vinculada ao curso de engenharia de computação.
SELECT universidade.nome
 Universidade_DisciplinaÉticaCarga=20h_CursoEngenhariaDeComputação
FROM universidade
 INNER JOIN professor ON universidade.id=iduniversidade
 INNER JOIN disciplina ON professor.id=idprofessor
 INNER JOIN disciplinacurso ON disciplina.id=iddisciplina
 INNER JOIN curso ON idcurso=curso.id
WHERE disciplina.nome = 'Ética'
 AND disciplina.cargahoraria=20
 AND curso.nome='Engenharia de Computação';

--h) Apresente o nome de cada aluno do sexo masculino cadastrado, junto com o nome do curso que ele está vinculado, o nome de toas as disciplinas vinculadas ao curso que ele escolheu, o nome do professor responsável por cada uma das disciplinas e o nome da universidade que o professor está vinculado.
SELECT aluno.nome AlunoMasculino,
 curso.nome Curso,
 disciplina.nome Disciplinas,
 professor.nome Professores,
 universidade.nome Universidade
FROM aluno
 INNER JOIN curso ON aluno.idcurso=curso.id
 INNER JOIN disciplinacurso ON curso.id=disciplinacurso.idcurso
 INNER JOIN disciplina ON iddisciplina=disciplina.id
 INNER JOIN professor ON idprofessor=professor.id
 INNER JOIN universidade ON iduniversidade=universidade.id
WHERE aluno.sexo='Masculino';