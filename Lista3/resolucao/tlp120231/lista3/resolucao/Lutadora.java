package tlp120231.lista3.resolucao;

public class Lutadora {
    
    private String nome;

    private int idade;

    private double peso_kg;

    private double altura_cm;

    private String equipe;

    public String getNome(){return nome;}

    public void setNome(String nome){this.nome=nome;}

    public int getIdade(){return idade;}

    public void setIdade(int idade){this.idade=idade;}

    public double getPeso_kg(){return peso_kg;}

    public void setPeso_kg(double peso_kg){this.peso_kg=peso_kg;}

    public double getAltura_cm(){return altura_cm;}
    
    public void setAltura_cm(double altura_cm){this.altura_cm=altura_cm;}

    public String getEquipe(){return equipe;}

    public void setEquipe(String equipe){this.equipe=equipe;}

    public Lutadora(String nome, int idade, double peso_kg, double altura_cm, String equipe){
        super();
        this.nome=nome; this.idade=idade; this.peso_kg=peso_kg; this.altura_cm=altura_cm;
        this.equipe=equipe;
    }

    public Lutadora(Lutadora lutadora){
        super();
        this.nome=lutadora.getNome(); this.idade=lutadora.getIdade(); 
        this.peso_kg=lutadora.getPeso_kg(); this.altura_cm=lutadora.getAltura_cm(); 
        this.equipe=lutadora.getEquipe();
    }

    public Lutadora(){super();}

    public String toString(){
        return "Atleta:\n-Nome: "+nome+"\n-Idade: "+idade+"\n-Peso(kg): "+peso_kg+"\n-Altura(cm): "+altura_cm+"\n-Equipe: "+equipe+"\n";
    }

    public boolean getByName(String nome){
        if(this.nome.equals(nome)){
            return true;
        }else{
            return false;
        }
    }
}
