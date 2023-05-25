package correcao.lista1mvc.src.controller;

import java.util.ArrayList;
import model.dao.LivroDAO;
import model.entity.Livro;
import view.EditoraView;

public class LivroController {
    LivroDAO ld = new LivroDAO();
    EditoraView ev = new EditoraView();    
    
    public void adicionar(String nome, int ano){
        
        Livro livro = new Livro();
        livro.setNome(nome);                
        livro.setAnoPublicacao(ano);        
           
        livro.setEditora(ev.buscarEditora());
                
        ld.adicionar(livro);
    }
    
    public ArrayList<Livro> buscarLivros(){
    
        ArrayList<Livro> lista = ld.buscar(ev.buscarEditora());
        return lista;
        
        //op��o 2
        //return ld.buscar(ev.buscarEditora());
    }
}
