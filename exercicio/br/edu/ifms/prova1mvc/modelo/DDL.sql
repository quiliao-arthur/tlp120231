CREATE TABLE Servidor (
    nome VARCHAR(60),
    siape INTEGER UNIQUE,
    id SERIAL PRIMARY KEY
);

CREATE TABLE Setor (
    nome VARCHAR(60),
    descricao VARCHAR(255),
    id SERIAL PRIMARY KEY
);

CREATE TABLE Equipamento (
    modelo VARCHAR(70),
    descricao VARCHAR(255),
    valor DOUBLE PRECISION,
    idSetor INTEGER,
    idServidor INTEGER,
    id SERIAL PRIMARY KEY,
    FOREIGN KEY(idSetor) REFERENCES Setor(id) ON DELETE CASCADE,
    FOREIGN KEY(idServidor) REFERENCES Servidor(id) ON DELETE CASCADE
);