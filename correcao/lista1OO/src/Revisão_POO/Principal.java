package Revisão_POO;
import java.util.Scanner; 
import java.util.ArrayList;

public class Principal {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        ArrayList<Atleta> lista = new ArrayList<Atleta>();
        String nome; 
        int aux, totalPontos, maior, opcao, i, qtd, contaAtleta, resposta, pontosVitoria, pontosEmpate; 
        float valor;
        
        do{
            System.out.println("Selecione a opcao desejada: \n1 = realizar cadastro \n2 = remover atleta \n3 = exibir oponentes \n4 = premiacao \n5 = exibir ranking \n6 = atleta sem competição \n7 = sair: ");
            opcao = sc.nextInt();
            
            if(opcao == 1){
               Atleta atleta = new Atleta();               
               atleta.realizarCadastro();                
               lista.add(atleta);
            }
            else if(opcao == 2){
                System.out.println("Informe o nome da atleta: ");
                nome = sc.next();
                System.out.println("Tam: "+lista.size());
                for(i = 0; i < lista.size(); i++){
                    if(nome.equals(lista.get(i).nomeAtleta)){
                        if(i == lista.size()-1){//ultima posicao
                            lista.remove(i);
                        }
                        else{
                            lista.add(lista.get(i));
                            lista.remove(lista.get(i));
                            break;
                        }
                    }
                }
                
            }
            
            else if(opcao == 3){
                System.out.println("Informe o numero de duplas: ");
                qtd = sc.nextInt();
                
                for(i = 0, contaAtleta = 1; contaAtleta <= qtd; 
                        i+=2, contaAtleta++){
                    System.out.println(lista.get(i).nomeAtleta + 
                            " vs "+ lista.get(i+1).nomeAtleta);
                }
                
            }
            else if(opcao == 4){
                System.out.println("Informe o nome da atleta: ");
                nome = sc.next();
                System.out.println("A primeira atleta ganhou (1), perdeu (2) ou houve um empate (3)?: ");
                resposta = sc.nextInt();
                System.out.println("Informe o valor recebido: ");
                valor = sc.nextFloat();
                
                if(resposta == 1){//ganhou
                    for(i = 0; i < lista.size(); i++){
                        if(nome.equals(lista.get(i).nomeAtleta)){
                              lista.get(i).totalVitorias++;
                              lista.get(i+1).totalDerrotas++;
                              lista.get(i).valor += valor;
                        }
                    }
                } 
                else if(resposta == 2){//perdeu
                    for(i = 0; i < lista.size(); i++){
                        if(nome.equals(lista.get(i).nomeAtleta)){
                              lista.get(i+1).totalVitorias++;
                              lista.get(i).totalDerrotas++;
                              lista.get(i+1).valor += valor;
                        }
                    }
                }
                else if(resposta == 3){
                    for(i = 0; i < lista.size(); i++){
                        if(nome.equals(lista.get(i).nomeAtleta)){
                              lista.get(i).totalEmpate++;
                              lista.get(i+1).totalEmpate++;
                        }
                    }
                }
            }
            else if(opcao == 5){
                System.out.println("Informe quantos pontos vale um empate: ");
                pontosEmpate = sc.nextInt();
                System.out.println("Informe quantos pontos vale uma vitória: ");
                pontosVitoria = sc.nextInt();
                
                for(i = 0, maior = 0, aux = 0; i < lista.size(); i++){
                    totalPontos = lista.get(i).calculaPontuacao(pontosVitoria, pontosEmpate);
                    if(totalPontos > maior){
                        maior = totalPontos; 
                        aux = i;
                    }
                }
                
                System.out.println("Nome da atleta com maior pontuação: "+ 
                        lista.get(aux).nomeAtleta);
            }
            else if(opcao == 6){
                for(i = 0;  i < lista.size(); i++){
                    if(lista.get(i).totalVitorias == 0 &&
                       lista.get(i).totalDerrotas == 0 &&
                       lista.get(i).totalEmpate == 0){
                        System.out.println("Nome da atleta que não competiu: "+
                                lista.get(i).nomeAtleta);
                    }
                }
            }
            
            
            System.out.println("Atletas cadastradas\n\n");
            for(i = 0; i < lista.size(); i++){
                System.out.println("Nome: "+lista.get(i).nomeAtleta);
            }
            
            
        }while(opcao != 7);
        
    }
}
