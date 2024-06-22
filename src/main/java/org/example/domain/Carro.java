package org.example.domain;

import java.util.List;

//Representa um carro
public class Carro extends Veiculo {
    private List<Carro> novos;
    private List<Carro> usados;

    //Construtor para inicializar um carro
    public Carro(int id, String marca, String modelo, int ano, double valor) {
        super(id, marca, modelo, ano, valor);
    }

    //Getters e Setters
    public List<Carro> getNovos() {
        return novos;
    }

    public void setNovos(List<Carro> novos) {
        this.novos = novos;
    }

    public List<Carro> getUsados() {
        return usados;
    }

    public void setUsados(List<Carro> usados) {
        this.usados = usados;
    }
}