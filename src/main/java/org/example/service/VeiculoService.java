package org.example.service;

import com.fasterxml.jackson.core.type.TypeReference;
import org.example.domain.Veiculo;
import org.example.domain.Carro;
import org.example.domain.Moto;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Serviço para operações relacionadas a veículos
public class VeiculoService {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final String FILE_PATH = "src/main/resources/veiculos.json";

    private static List<Veiculo> lerVeiculosDoArquivo() throws IOException {
        byte[] jsonData = Files.readAllBytes(Paths.get(FILE_PATH));

        //Mapeia o JSON para uma lista de veículos
        List<Veiculo> todosVeiculos = objectMapper.readValue(jsonData, new TypeReference<List<Veiculo>>() {});

        return todosVeiculos;
    }

    //Filtra os veículos por marca
    public List<Veiculo> filtrarVeiculosPorMarca(String marca) throws IOException {
        List<Veiculo> veiculos = lerVeiculosDoArquivo();

        return veiculos.stream()
                .filter(veiculo -> veiculo.getMarca().equalsIgnoreCase(marca))
                .collect(Collectors.toList());
    }

    //Calcula a soma dos valores de veículos por marca
    public double somarValorVeiculosPorMarca(String marca) throws IOException {
        List<Veiculo> veiculos = lerVeiculosDoArquivo();

        return veiculos.stream()
                .filter(veiculo -> veiculo.getMarca().equalsIgnoreCase(marca))
                .mapToDouble(Veiculo::getValor)
                .sum();
    }

    //Filtra os veículos que são mais novos que o ano especificado
    public List<Veiculo> filtrarVeiculosMaisNovosQue(int ano) throws IOException {
        List<Veiculo> veiculos = lerVeiculosDoArquivo();

        return veiculos.stream()
                .filter(veiculo -> veiculo.getAno() > ano)
                .collect(Collectors.toList());
    }
}
