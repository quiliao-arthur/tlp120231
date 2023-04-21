CREATE TABLE Editora{
    codigo INTEGER PRIMARY KEY AUTOINCREMENT,
    nome VARCHAR(30)
};

CREATE TABLE Livro{
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome VARCHAR(40),
    anoDePublicacao INTEGER,
    codigoEditora INTEGER,
    CONSTRAINT fk_editoraLivro FOREIGN KEY (codigoEditora) REFERENCES Editora (codigo)
};