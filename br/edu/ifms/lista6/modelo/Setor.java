package br.edu.ifms.lista6.modelo;

import java.util.ArrayList;

public class Setor {
    
    private int id;

    private String nome;

    private String descricao;

    private ArrayList<Equipamento> equipamentos;

    public int getId() {return id;}

    public void setId(int id) {this.id=id;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome=nome;}

    public String getDescricao() {return descricao;}

    public void setDescricao(String descricao) {this.descricao=descricao;}

    public ArrayList<Equipamento> getEquipamentos() {return equipamentos;}

    public void setEquipamentos(ArrayList<Equipamento> equipamentos) {this.equipamentos=equipamentos;}
}
