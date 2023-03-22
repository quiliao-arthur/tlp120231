package aula1;

import java.util.ArrayList;

public class Principal{
	public static void main(String args[]){
                Pessoa pessoa = new Pessoa();
                pessoa.setNome("Joana");
                pessoa.setIdade(20);
                
                PessoaBanco pb = new PessoaBanco();
                pb.adicionar(pessoa);
        }
}
