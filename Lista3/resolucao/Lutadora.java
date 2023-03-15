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
    public void setId(Long novoId){
        id=novoId;
    }
    public int getIdade(){
        return idade;
    }
    public void setIdade(int novaIdade){
        idade=novaIdade;
    }
    public double getPeso_kg(){
        return peso_kg;
    }
    public void setPeso_kg(double novoPeso_kg){
        peso_kg=novoPeso_kg;
    }
    public double getAltura_m(){
        return altura_m;
    }
    public void setAltura_m(double novaAltura_m){
        altura_m=novaAltura_m;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String novoNome){
        nome=novoNome;
    }
    public Equipe getEquipe(){
        return equipe;
    }
    public void setEquipe(Equipe novaEquipe){
        equipe=novaEquipe;
    }
}