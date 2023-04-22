CREATE TABLE Curso(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50),
    codigo INTEGER,
    duracaoH INTEGER
);

CREATE TABLE Estudante(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(40),
    cpf VARCHAR(11),
    idCurso INTEGER,
    CONSTRAINT (fk_cursa) FOREIGN KEY (idCurso) REFERENCES Curso(id)
);