package tlp120231.lista3.resolucao;

public class Competidora extends Lutadora{
    private int n_vitorias;
    private int n_empates;
    private int n_derrotas;
    private double valor_premios;
    public int getN_vitorias(){
        return n_vitorias;
    }
    public void setN_vitorias(int n_vitorias){
        this.n_vitorias = n_vitorias;
    }
    public int getN_empates(){
        return n_empates;
    }
    public void setN_empates(int n_empates){
        this.n_empates = n_empates;
    }
    public int getN_derrotas(){
        return n_derrotas;
    }
    public void setN_derrotas(int n_derrotas){
        this.n_derrotas = n_derrotas;
    }
    public double getValor_premios(){
        return valor_premios;
    }
    public void setValor_premios(double valor_premios){
        this.valor_premios = valor_premios;
    }
}