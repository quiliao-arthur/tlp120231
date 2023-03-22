package tlp120231.lista3.resolucao;

import java.util.Scanner;
import java.util.ArrayList;

public class Aplicacao{
    public static void main(String[] args){
        //Menu
        Scanner sc = new Scanner(System.in);
        ArrayList<Lutadora> lista_lutadoras = new ArrayList<Lutadora>();
        int opcao = 0;
        do{
            System.out.println("Sistema MMA Peso-pena Feminino v1.0\n" +
                               "1 - Cadastro de Atletas\n" +
                               "2 - Atualização de status\n" +
                               "3 - Exibição de oponentes\n" +
                               "4 - Premiação\n" +
                               "5 - Exibição de ranking\n" +
                               "6 - Atleta sem competição\n" +
                               "0 - Sair");
            switch(entradaNumero(sc.nextLine())){
                case 1:{
                    break;
                }
                case 2:{
                    break;
                }
                case 3:{
                    break;
                }
                case 4:{
                    break;
                }
                case 5:{
                    break;
                }
                case 6:{
                    break;
                }
                default:{
                    System.out.println("Insira um número de 0 a 6 para executar uma opção!");
                }
            }
        }while(opcao!=0);
    }
    public static int entradaNumero(String entrada){
        boolean erro = false;
        do{
            try{
                return parseInt(entrada);
            }catch(Exception e){
                erro = true;
                e.printStackTrace();
                System.out.println("Insira um número, por favor");
            }
        }while(!erro);
    }
    public static void competicao(ArrayList<Lutadora> lista_lutadoras){

    }
}