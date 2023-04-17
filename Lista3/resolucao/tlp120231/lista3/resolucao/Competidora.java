package tlp120231.lista3.resolucao;

public class Competidora extends Lutadora {
    private int totalVitorias, 
                totalDerrotas, 
                totalEmpates;
    private double valorPremios;

    public int getVitorias(){return totalVitorias;}

    public void venceu(){totalVitorias++;}
    public void venceu(double valorPremios){
        totalVitorias++;
        this.valorPremios+=valorPremios;
    }

    public int getEmpates(){return totalEmpates;}

    public void empatou(){totalEmpates++;}

    public int getDerrotas(){return totalDerrotas;}

    public void perdeu(){totalDerrotas++;}

    public double getPremios(){return valorPremios;}

    public Competidora(){super(); totalVitorias=0; totalDerrotas=0; totalEmpates=0; valorPremios=0;}

    public Competidora(Lutadora lutadora){
        super(lutadora);
        totalVitorias=0; totalDerrotas=0; totalEmpates=0; valorPremios=0;
    }
}
