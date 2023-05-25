package correcao.lista1mvc.src.view;

import controller.LivroController;
import java.util.Scanner;
import model.entity.Livro;

public class LivroView {
    
    Scanner sc = new Scanner(System.in);
    LivroController lc = new LivroController();
    
    public void adicionar(){
        String nomeLivro; 
        int ano;                

        System.out.println("Informe o nome: ");
        nomeLivro = sc.next();
        System.out.println("Informe o ano: ");
        ano = sc.nextInt();
        
        lc.adicionar(nomeLivro, ano);
    }
    
    public void buscarLivros(){
       
        for(Livro livro: lc.buscarLivros()){
            System.out.println("Nome: "+livro.getNome());
        }
  
    }
}
