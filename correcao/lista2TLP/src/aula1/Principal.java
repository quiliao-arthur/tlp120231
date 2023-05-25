package aula1;

import java.util.ArrayList;

public class Principal{
    public static void main(String args[]){
        Setor setor = new Setor();
        setor.setNome("Diren");
        setor.setSigla("Diren");
        setor.setDescricao("Direção de ensino");
        
        SetorBanco sb = new SetorBanco();
        sb.adicionar(setor);
        System.out.println("Id: "+setor.getId());
        
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Joana");
        pessoa.setIdade(20);
        pessoa.setSetor(setor);
        
        PessoaBanco pb = new PessoaBanco();
        pb.adicionar(pessoa);
        
        
    }
}
/*
create table pessoa(
	nome varchar, 
	idade int, 
	idsetor int references setor(id),
	id serial primary key
);

create table setor(
	nome varchar, 
	sigla varchar, 
	descricao varchar, 
	id serial primary key

);

*/