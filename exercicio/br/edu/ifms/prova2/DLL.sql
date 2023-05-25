CREATE TABLE Shopping (
    nome VARCHAR(50),
    id SERIAL PRIMARY KEY
);

CREATE TABLE Loja (
    nome VARCHAR(50),
    categoria VARCHAR(60),
    idShopping INTEGER,
    id SERIAL PRIMARY KEY,
    FOREIGN KEY(idShopping) REFERENCES Shopping(id) ON DELETE CASCADE
);

CREATE TABLE Funcionario (
    nome VARCHAR(50),
    rg INTEGER UNIQUE,
    idLoja INTEGER,
    id SERIAL PRIMARY KEY,
    FOREIGN KEY(idLoja) REFERENCES Loja(id) ON DELETE CASCADE
);