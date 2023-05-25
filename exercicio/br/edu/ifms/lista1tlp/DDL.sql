CREATE TABLE Editora{
    codigo INTEGER PRIMARY KEY,
    nome VARCHAR(30)
};

CREATE TABLE Livro{
    id SERIAL PRIMARY KEY,
    nome VARCHAR(40),
    anoPublicacao INTEGER,
    codigoEditora INTEGER,
    CONSTRAINT fk_editoraLivro FOREIGN KEY (codigoEditora) REFERENCES Editora (codigo)
};