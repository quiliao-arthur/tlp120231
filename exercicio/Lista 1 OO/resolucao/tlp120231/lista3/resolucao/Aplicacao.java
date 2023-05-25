package tlp120231.lista3.resolucao;

import java.util.ArrayList;
import java.util.Scanner;
/*
 * @author Arthur Quilião
 */
public class Aplicacao {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ArrayList<Lutadora> listaLutadoras = new ArrayList<Lutadora>();
        int opcao = 0;
        do{
            switch(opcao=menu(sc)){

                case -1337:{
                    System.out.println("Algo deu muito errado.");
                    break;
                }
    
                /*
                * Saída da Aplicação
                */
                case 0:{
                    break;
                }
    
                case 1:{
                    listaLutadoras = cadastroAtleta(listaLutadoras, sc);
                    break;
                }

                case 2:{
                    listaLutadoras = afastamentoAtleta(listaLutadoras, sc);
                    break;
                }
    
                case 3:{
                    visualizacaoLutas(listaLutadoras, sc);
                    break;
                }

                case 4:{
                    listaLutadoras = competicaoLutadoras(listaLutadoras, sc);
                    break;
                }
                
                case 5:{
                    visualizacaoRanking(listaLutadoras, sc);
                    break;
                }
    
                case 6:{
                    atletaSemCompeticao(listaLutadoras);
                    break;
                }
    
                default:{
                    System.out.println("Favor escolher um número de 0 a 6;");
                    break;
                }
            }
        }while(opcao!=0);
        
    }

    public static int menu(Scanner sc){
        System.out.println("Sistema de Gerenciamento de Atletas e Competições:\n"+
                            "1-) Cadastro de Atletas\n"+
                            "2-) Atualização de status para afastamento\n"+
                            "3-) Exibição de lutas\n"+
                            "4-) Premiação\n"+
                            "5-) Exibição de ranking de competidoras\n"+
                            "6-) Atleta sem competição\n"+
                            "0-) Sair");
        return (int) validaNumero(sc);
    }

    /*
    * Cadastro de Atletas
    */
    public static ArrayList<Lutadora> cadastroAtleta(ArrayList<Lutadora> listaLutadoras, Scanner sc){
        Lutadora lutadora = new Lutadora();
        System.out.println("Cadastro de Atleta!\n" +
                           "Nome da atleta:");
        lutadora.setNome(sc.nextLine());
        System.out.println("Idade da atleta:");
        lutadora.setIdade((int) validaNumero(sc));
        System.out.println("Peso(kg) da atleta:");
        lutadora.setPeso_kg(validaNumero(sc));
        System.out.println("Altura(cm) da atleta:");
        lutadora.setAltura_cm(validaNumero(sc));
        System.out.println("Equipe da atleta:");
        lutadora.setEquipe(sc.nextLine());
        listaLutadoras.add(lutadora);
        return listaLutadoras;
    }

    /*
    * Afastamento de Atletas
    */
    public static ArrayList<Lutadora> afastamentoAtleta(ArrayList<Lutadora> listaLutadoras, Scanner sc){
        Lutadora lutadora = new Lutadora();
        System.out.println("Atualização de status para afastamento\n"+
                                        "Nome da atleta afastada:");
        lutadora.setNome(sc.nextLine());
        for(int i=0; i<listaLutadoras.size(); i++){
            if(listaLutadoras.get(i).getNome().equals(lutadora.getNome())){
                if(i!=listaLutadoras.size()-1){
                    lutadora = new Lutadora(listaLutadoras.get(i));
                    listaLutadoras.remove(i);
                    listaLutadoras.add(lutadora);
                    i=listaLutadoras.size();
                }else{
                    listaLutadoras.remove(i);
                }
            }
            if(i==listaLutadoras.size()-1){
                System.out.println("Atleta não encontrada!");
            }
        }
        return listaLutadoras;
    }

    /*
    * Exibição de Lutas
    */
    public static void visualizacaoLutas(ArrayList<Lutadora> listaLutadoras, Scanner sc){
        int numLutas = 0;
        do{
            System.out.println("Favor inserir o número de lutas:");
            numLutas = (int) validaNumero(sc);
            if(numLutas>listaLutadoras.size()/2||numLutas<0){
                System.out.println("Favor inserir um número válido.");
            }
        }while(numLutas>listaLutadoras.size()/2||numLutas<0);
        visualizacaoLutas(listaLutadoras, numLutas);
    }
    public static void visualizacaoLutas(ArrayList<Lutadora> listaLutadoras, int numLutas){
        for(int i=0; i<numLutas*2; i+=2){
        System.out.println("Luta:\n"+
                           listaLutadoras.get(i).toString()+"\n"+
                           "VS.\n"+
                           listaLutadoras.get(i+1).toString());
        }
    }

    /*
    * Premiação
    */
    public static ArrayList<Lutadora> competicaoLutadoras(ArrayList<Lutadora> listaLutadoras, Scanner sc){
        Lutadora lutadora = new Lutadora();
        double valorCompeticao = 0;
        int resultado = 0;
        visualizacaoLutas(listaLutadoras, listaLutadoras.size());
        System.out.println("Qual a \"primeira\" atleta (de cima para baixo) a competir dentre as possíveis lutas?");
        lutadora.setNome(sc.nextLine());
        for(int i=0; i<listaLutadoras.size(); i++){
            if(listaLutadoras.get(i).getNome().equals(lutadora.getNome())){
                System.out.println("Competição:\n"+
                                    listaLutadoras.get(i).toString()+"\n"+
                                    listaLutadoras.get(i+1).toString());
                System.out.println("Qual o valor de premiação dessa competição?");
                valorCompeticao=validaNumero(sc);
                do{
                    System.out.println("A \"primeira\" atleta ganhou (1), perdeu (2) ou empatou (3)?");
                    switch(resultado = (int) validaNumero(sc)){
                        case 1:{
                            listaLutadoras.get(i).vencer();
                            listaLutadoras.get(i).premiar(valorCompeticao);
                            listaLutadoras.get(i+1).perder();
                            break;
                        }
                        case 2:{
                            listaLutadoras.get(i).perder();
                            listaLutadoras.get(i+1).vencer();
                            listaLutadoras.get(i+1).premiar(valorCompeticao);
                            break;
                        }
                        case 3:{
                            listaLutadoras.get(i).empatar();
                            listaLutadoras.get(i+1).empatar();
                        }
                    }
                }while(resultado<0||resultado>3);
            }else{
                if(i==listaLutadoras.size()-1){
                    System.out.println("Atleta não encontrada.");
                }
            }
        }
        return listaLutadoras;
    }

    /*
    * Exibição Ranking
    */
    public static void visualizacaoRanking(ArrayList<Lutadora> listaLutadoras, Scanner sc){
        int ptoVitoria = 0;
        int ptoEmpate = 0;
        System.out.println("Quantos pontos vale uma vitória?");
        ptoVitoria = (int) validaNumero(sc);
        System.out.println("Quantos pontos vale um empate?");
        ptoEmpate = (int) validaNumero(sc);

        Lutadora lutadora = new Lutadora(listaLutadoras.get(0));
        for(int i=0; i<listaLutadoras.size(); i++){
            if((lutadora.getVitorias()*ptoVitoria+lutadora.getEmpates()*ptoEmpate)<(listaLutadoras.get(i).getVitorias()*ptoVitoria+listaLutadoras.get(i).getEmpates()*ptoEmpate)){
                lutadora = new Lutadora(listaLutadoras.get(i));
            }
        }
        System.out.println("Atleta mais premiada:\n"+
                           lutadora.toString());
    }

    /*
     * Atleta Sem Competição
     */
    public static void atletaSemCompeticao(ArrayList<Lutadora> listaLutadoras){
        System.out.println("Atletas sem competir:");
        for(int i=0; i<listaLutadoras.size(); i++){
            if(listaLutadoras.get(i).getVitorias()==0 &&
                listaLutadoras.get(i).getEmpates()==0 &&
                listaLutadoras.get(i).getDerrotas()==0){
                System.out.println(listaLutadoras.get(i).toString());
            }
        }
    }

    public static double validaNumero(Scanner sc){
        boolean erro = false;
        do{
            try{
                return Double.parseDouble(sc.nextLine());
            }catch(Exception e){
                erro=true;
                System.out.println("Favor inserir um número!");
            }
        }while(erro);
        return (double) -1337;
    }
}