package br.edu.ifms.lista5.organizadados;

import java.util.ArrayList;

import br.edu.ifms.lista5.banco.EstudanteBanco;
import br.edu.ifms.lista5.modelo.Estudante;

public class OrganizaEstudante {
    public ArrayList<Estudante> buscaEstudante(String busca) {
        
        EstudanteBanco estudanteBanco = new EstudanteBanco();
        ArrayList<Estudante> listaEstudantes = estudanteBanco.buscarTudo();
        ArrayList<Estudante> listaEstudantesBuscados = new ArrayList<Estudante>();
        for (int i=0; i<listaEstudantes.size(); i++) {
            if (busca.equals(listaEstudantes.get(i).getNome()) ||
                busca.equals(listaEstudantes.get(i).getCpf())) {
                    listaEstudantesBuscados.add(listaEstudantes.get(i));
                }
        }

        return listaEstudantesBuscados;
    }

    public boolean duplicataEstudante(Estudante estudante) {

        EstudanteBanco estudanteBanco = new EstudanteBanco();
        ArrayList<Estudante> listaEstudantes = estudanteBanco.buscarTudo();

        for (int i=0; i<listaEstudantes.size(); i++) {
            if (estudante.equals(listaEstudantes.get(i)) ||
               (estudante.getNome().equals(listaEstudantes.get(i).getNome()) &&
                estudante.getCpf().equals(listaEstudantes.get(i).getCpf()))) {
                return true;
            }
        }
        return false;
    }

    public boolean validaCpf(String cpf) {
        if (cpf.length()==11) {
            int cpfDigito;
            int digitoVerificador = Integer.parseInt(cpf.substring(9, 10));
            int somaDigitos = 0;
            for (int i=0; i<9; i++) {
                cpfDigito = Character.getNumericValue(cpf.charAt(i));
                somaDigitos += cpfDigito*10-i;
            }
            if (11-(somaDigitos%11)==digitoVerificador) {
                return true;
            }
        }
        return false;
    }
}
