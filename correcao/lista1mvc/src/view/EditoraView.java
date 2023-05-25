package correcao.lista1mvc.src.view;

import controller.EditoraController;
import java.util.Scanner;
import model.entity.Editora;

public class EditoraView {
    Scanner sc = new Scanner(System.in);
    EditoraController ec = new EditoraController();
    
    public void adicionar(){
        String nomeEditora; 
        int codigo; 

        System.out.println("Informe o nome: ");
        nomeEditora = sc.next();
        System.out.println("Informe o c�digo: ");
        codigo = sc.nextInt();  
        
        ec.adicionar(nomeEditora, codigo);
    }
    
    public Editora buscarEditora(){
        String nome;
        
        System.out.println("Informe o nome da editora: ");
        nome = sc.next();
        
        return ec.buscarEditora(nome);
    }
}
