package tlp120231.lista3.resolucao;

public class Lutadora {
    
    private String nome;

    private int idade;

    private double peso_kg;

    private double altura_cm;

    private String equipe;

    private int vitorias;
                
    private int derrotas;

    private int empates;

    private double valorPremios;

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

    public int getVitorias(){return vitorias;}

    public void vencer(){vitorias++;}

    public int getEmpates(){return empates;}

    public void empatar(){empates++;}

    public int getDerrotas(){return derrotas;}

    public void perder(){derrotas++;}

    public double getValorPremios(){return valorPremios;}

    public void premiar(double premiacao){valorPremios+=premiacao;}

    public Lutadora(String nome, int idade, double peso_kg, double altura_cm, String equipe){
        super();
        this.nome=nome; this.idade=idade; this.peso_kg=peso_kg; this.altura_cm=altura_cm;
        this.equipe=equipe; this.vitorias=0; this.derrotas=0; this.empates=0; this.valorPremios=0;
    }

    public Lutadora(Lutadora lutadora){
        super();
        this.nome=lutadora.getNome(); this.idade=lutadora.getIdade(); 
        this.peso_kg=lutadora.getPeso_kg(); this.altura_cm=lutadora.getAltura_cm(); 
        this.equipe=lutadora.getEquipe(); this.vitorias=lutadora.getVitorias();
        this.empates=lutadora.getEmpates(); this.derrotas=lutadora.getDerrotas();
        this.valorPremios=lutadora.getValorPremios();
    }

    public Lutadora(){super(); this.nome=""; this.idade=0; this.peso_kg=0; this.altura_cm=0; this.equipe=""; this.vitorias=0; this.derrotas=0; this.empates=0; this.valorPremios=0;}

    public String toString(){
        return "Atleta:\n Nome: "+nome+", Idade: "+idade+", Peso(kg): "+peso_kg+", Altura(cm): "+altura_cm+", Equipe: "+equipe;
    }

    public boolean equals(Lutadora lutadora){
        if(lutadora.getNome().equals(this.getNome()) &&
            lutadora.getIdade()==this.getIdade() &&
            lutadora.getPeso_kg()==this.getPeso_kg() &&
            lutadora.getAltura_cm()==this.getAltura_cm() &&
            lutadora.getEquipe().equals(this.getEquipe()) &&
            lutadora.getVitorias()==this.getVitorias() &&
            lutadora.getEmpates()==this.getEmpates() &&
            lutadora.getDerrotas()==this.getDerrotas() &&
            lutadora.getValorPremios()==this.getValorPremios())
        {
            return true;
        }else{
            return false;
        }
    }
}