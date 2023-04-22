package br.edu.ifms.lista4.modelo;

public class Livro {
    
    private int id;
    
    private String nome;
    
    private int anoPublicacao;
    
    private Editora editora;

    public int getId(){return id;}

    public void setId(int id){this.id=id;}

    public String getNome(){return nome;}

    public void setNome(String nome){this.nome=nome;}

    public int getAnoPublicacao(){return anoPublicacao;}

    public void setAnoPublicacao(int anoPublicacao){this.anoPublicacao=anoPublicacao;}

    public Editora getEditora(){return editora;}

    public void setEditora(Editora editora){this.editora=editora;}

    public Livro(){super();}

    public Livro(Livro livro){
        super(); 
        this.id=livro.getId();
        this.nome=livro.getNome();
        this.anoPublicacao=livro.getAnoPublicacao();
        this.editora=livro.getEditora();
    }

    public Livro(int id, String nomeLivro, int anoPublicacao, int codigo, String nomeEditora){
        this.id=id;
        this.nome=nomeLivro;
        this.anoPublicacao=anoPublicacao;
        this.editora = new Editora(codigo, nomeEditora);
    }

    public String toString(){
        return "Livro:\n Nome: "+nome+", Ano de Publicação: "+anoPublicacao+" "+editora.toString();
    }

    public boolean equals(Livro livro){
        if(this.id==livro.getId()&&
            this.nome.equals(livro.getNome())&&
            this.anoPublicacao==livro.getAnoPublicacao() &&
            this.editora.equals(livro.getEditora())){
                return true;
            }else{
                return false;
            }
    }

    public boolean hasId(int id){
        if(this.id==id){
            return true;
        }else{
            return false;
        }
    }
}

