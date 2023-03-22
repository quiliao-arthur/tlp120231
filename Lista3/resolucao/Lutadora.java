package tlp120231.lista3.resolucao;

public class Lutadora{
    private Long id;
    private int idade;
    private double peso_kg;
    private double altura_m;
    private String nome;
    private Equipe equipe;
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public int getIdade(){
        return idade;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
    public double getPeso_kg(){
        return peso_kg;
    }
    public void setPeso_kg(double peso_kg){
        this.peso_kg = peso_kg;
    }
    public double getAltura_m(){
        return altura_m;
    }
    public void setAltura_m(double altura_m){
        this.altura_m = altura_m;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public Equipe getEquipe(){
        return equipe;
    }
    public void setEquipe(Equipe equipe){
        this.equipe = equipe;
    }
}