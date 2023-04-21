package aula1;

import java.util.ArrayList;

public class Principal{
    public static void main(String args[]){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Joana");
        pessoa.setIdade(20);
        
        PessoaBanco pb = new PessoaBanco();
        pb.adicionar(pessoa);
        
        Setor setor = new Setor();
        setor.setNome("Diren");
        setor.setSigla("Diren");
        setor.setDescricao("Direção de ensino");
        
        SetorBanco sb = new SetorBanco();
        sb.adicionar(setor);
        System.out.println("Id: "+setor.getId());
    }
}
