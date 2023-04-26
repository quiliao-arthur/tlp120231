CREATE TABLE Servidor (

    nome VARCHAR(50),
    siape INTEGER UNIQUE,
    id SERIAL PRIMARY KEY
);

CREATE TABLE Setor (

    nome VARCHAR(40),
    descricao VARCHAR(255),
    id SERIAL PRIMARY KEY
);

CREATE TABLE Equipamento (

    modelo VARCHAR(30),
    descricao VARCHAR(255),
    valor DOUBLE PRECISION,
    idSetor INTEGER,
    idServidor INTEGER,
    id SERIAL PRIMARY KEY,
    CONSTRAINT fk_servidor
        FOREIGN KEY(idServidor)
            REFERENCES Servidor(id),
    CONSTRAINT fk_setor
        FOREIGN KEY(idSetor)
            REFERENCES Setor(id)
);