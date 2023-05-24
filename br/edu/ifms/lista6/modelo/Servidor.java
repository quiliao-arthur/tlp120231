package br.edu.ifms.lista6.modelo;

import java.util.ArrayList;

public class Servidor {
    
    private int id;

    private String nome;

    private int siape;

    private ArrayList<Equipamento> equipamentos;

    public int getId() {return id;}
        
    public void setId(int id) {this.id=id;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome=nome;}

    public int getSiape() {return siape;}

    public void setSiape(int siape) {this.siape=siape;}

    public ArrayList<Equipamento> getEquipamentos() {return equipamentos;}

    public void setEquipamentos(ArrayList<Equipamento> equipamentos) {this.equipamentos=equipamentos;}

    public Servidor() {id=0; nome=""; siape=0; equipamentos = new ArrayList<Equipamento>();}
}
