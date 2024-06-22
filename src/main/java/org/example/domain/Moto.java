package org.example.domain;

import java.util.List;

//Representa uma moto
public class Moto extends Veiculo {
    private List<Moto> novos;
    private List<Moto> usados;

    //Construtor para inicializar uma moto
    public Moto(int id, String marca, String modelo, int ano, double valor) {
        super(id, marca, modelo, ano, valor);
    }

    //Getters e Setters
    public List<Moto> getNovos() {
        return novos;
    }

    public void setNovos(List<Moto> novos) {
        this.novos = novos;
    }

    public List<Moto> getUsados() {
        return usados;
    }

    public void setUsados(List<Moto> usados) {
        this.usados = usados;
    }
}