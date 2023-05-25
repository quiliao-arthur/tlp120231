package aula1;


public class Pessoa{
    private String nome; 
    private int idade; 
    private Setor setor;    
    
    public Setor getSetor(){
        return setor; 
    }
    
    public void setSetor(Setor setor){
        this.setor = setor;
    }

    public String getNome(){
        return nome; 
    }

    public int getIdade(){
        return idade;
    }

    public void setNome(String nome){
        this.nome = nome; 
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

 
}