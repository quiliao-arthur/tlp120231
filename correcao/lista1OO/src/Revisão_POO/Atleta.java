package Revisão_POO;
import java.util.Scanner;

public class Atleta {
    Scanner sc = new Scanner(System.in);
    String nomeAtleta, nomeEquipe; 
    int idade, totalVitorias, totalDerrotas, totalEmpate; 
    float altura, valor; 
    
    public void realizarCadastro(){
        System.out.println("Informe o nome da atleta: ");
        nomeAtleta = sc.next();
        System.out.println("Informe a idade da atleta: ");
        idade = sc.nextInt();
        System.out.println("Informe a altura da atleta: ");
        altura = sc.nextFloat();
        System.out.println("Informe o nome da equipe da atleta: ");
        nomeEquipe = sc.next(); 
   }
    
    public int calculaPontuacao(int pontosVitoria, int pontosEmpate){
        return totalVitorias * pontosVitoria + 
                totalEmpate * pontosEmpate;   
    }
}
