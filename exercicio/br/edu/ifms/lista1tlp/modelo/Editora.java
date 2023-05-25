package exercicio.br.edu.ifms.lista1tlp.modelo;

public class Editora {
    
    private int codigo;

    private String nome;

    public int getCodigo(){return codigo;}

    public void setCodigo(int codigo){this.codigo=codigo;}

    public String getNome(){return nome;}

    public void setNome(String nome){this.nome=nome;}

    public Editora(){super();}

    public Editora(Editora editora){
        super();
        this.codigo=editora.getCodigo();
        this.nome=editora.getNome();
    }

    public Editora(int codigo, String nome){
        super();
        this.codigo=codigo;
        this.nome=nome;
    }

    public String toString(){
        return "Editora: \n Código: "+codigo+", Nome: "+nome;
    }

    public boolean equals(Editora editora){
        if(this.codigo==editora.getCodigo() &&
            this.nome.equals(editora.getNome())){
                return true;
            }else{
                return false;
            }
    }

    public boolean hasId(int codigo){
        if(this.codigo==codigo){
            return true;
        }else{
            return false;
        }
    }
}
