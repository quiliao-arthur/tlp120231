CREATE TABLE Medico (
    nome VARCHAR(45),
    crm INTEGER UNIQUE,
    id SERIAL PRIMARY KEY
);

CREATE TABLE Paciente (
    nome VARCHAR(45),
    cpf VARCHAR(11) UNIQUE,
    id SERIAL PRIMARY KEY
);

CREATE TABLE Consulta (
    data DATE,
    idMedico INTEGER,
)