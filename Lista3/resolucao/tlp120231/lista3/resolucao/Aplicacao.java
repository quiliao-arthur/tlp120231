package tlp120231.lista3.resolucao;

import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int escolha = -1;
        ArrayList<Lutadora> listaLutadoras = new ArrayList<Lutadora>();
        ArrayList<Competidora> listaCompetidora = new ArrayList<Competidora>();
        Lutadora lutadora = new Lutadora();
        do{
            /*
             * Menu
             */
            System.out.println("Sistema de Gerenciamento de Atletas e Competições:\n"+
                                "1-) Cadastro de Atletas\n"+
                                "2-) Atualização de status para afastamento\n"+
                                "3-) Exibição de lutas\n"+
                                "4-) Premiação\n"+
                                "5-) Exibição de ranking de competidoras\n"+
                                "6-) Atleta sem competição\n"+
                                "0-) Sair");
            switch(escolha=(int) validaNumero(sc)){
                /*
                 * Não sei como faz laço comn try/catch lol
                 */
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
                /*
                 * Cadastro de Atletas
                 */
                case 1:{
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
                    break;
                }
                /*
                 * Afastamento de Atletas
                 */
                case 2:{
                    System.out.println("Atualização de status para afastamento\n"+
                                        "Nome da atleta afastada:");
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
                    System.out.println("Favor escolher um número de 0 a 6;");
                    break;
                }
            }
        }while(escolha!=0);
    }

    public static double validaNumero(Scanner sc){
        boolean erro = false;
        do{
            try{
                erro = false;
                return Double.parseDouble(sc.nextLine());
            }catch(Exception e){
                erro=true;
                System.out.println("Favor inserir um número!");
            }
        }while(erro);
        return (double) -1337;
    }
   
}