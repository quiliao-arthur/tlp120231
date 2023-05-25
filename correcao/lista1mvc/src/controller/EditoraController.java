package correcao.lista1mvc.src.controller;

import model.dao.EditoraDAO;
import model.entity.Editora;

public class EditoraController {
    EditoraDAO ed = new EditoraDAO();
    
    public void adicionar(String nomeEditora, int codigo){
        
        Editora editora = new Editora();
        editora.setNome(nomeEditora);
        editora.setCodigo(codigo);

        ed.adicionar(editora);
    }
    
    public Editora buscarEditora(String nome){
        Editora editora = ed.buscarPorNome(nome);
        return editora;
        
        //op��o 2
        //return ed.buscarPorNome(nome);
    }
}
