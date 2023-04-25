package br.edu.ifms.lista5.organizadados;

import java.util.ArrayList;

import br.edu.ifms.lista5.banco.CursoBanco;
import br.edu.ifms.lista5.modelo.Curso;

public class OrganizaCurso {
    public ArrayList<Curso> buscaCurso(String busca) {

        CursoBanco cursoBanco = new CursoBanco();
        ArrayList<Curso> listaCursos = cursoBanco.buscarTudo();
        ArrayList<Curso> listaCursosBuscados = new ArrayList<Curso>();
        for (int i=0; i<listaCursos.size(); i++) {
            if (busca.equals(listaCursos.get(i).getNome()) ||
                listaCursos.get(i).getCodigo()==Integer.parseInt(busca)) {
                    listaCursosBuscados.add(listaCursos.get(i));
                }
        }

        return listaCursosBuscados;
    }

    public boolean duplicataCurso(Curso curso) {

        CursoBanco cursoBanco = new CursoBanco();
        ArrayList<Curso> listaCursos = cursoBanco.buscarTudo();

        for (int i=0; i<listaCursos.size(); i++) {
            if (curso.equals(listaCursos.get(i)) ||
                (curso.getNome().equals(listaCursos.get(i).getNome()) &&
                 curso.getCodigo()==listaCursos.get(i).getCodigo() &&
                 curso.getDuracaoH()==listaCursos.get(i).getDuracaoH())) {
                return true;
            }
        }
        return false;
    }
}
