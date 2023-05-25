CREATE TABLE Endereco (
    rua VARCHAR(100),
    numero INTEGER,
    bairro VARCHAR(100),
    id SERIAL PRIMARY KEY
);

CREATE TABLE Pessoa (
    nome VARCHAR(255),
    rg VARCHAR(12) UNIQUE,
    idEndereco INTEGER,
    id SERIAL PRIMARY KEY,
    CONSTRAINT moradia FOREIGN KEY(idEndereco) REFERENCES Endereco(id) ON DELETE CASCADE
)