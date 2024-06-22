package com.exemplo.service;

import org.example.domain.Veiculo;
import org.example.service.VeiculoService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VeiculoServiceTest {
    private static VeiculoService veiculoService;

    @BeforeAll
    public static void setup() {
        veiculoService = new VeiculoService();
    }

    @Test
    public void testFiltrarVeiculosPorMarca() throws IOException {
        List<Veiculo> veiculos = veiculoService.filtrarVeiculosPorMarca("Chevrolet");
        assertEquals(2, veiculos.size());
        assertTrue(veiculos.stream().allMatch(v -> v.getMarca().equalsIgnoreCase("Chevrolet")));
    }

    @Test
    public void testSomarValorVeiculosPorMarca() throws IOException {
        double soma = veiculoService.somarValorVeiculosPorMarca("VolksWagen");
        assertEquals(273000.00, soma);
    }

    @Test
    public void testFiltrarVeiculosMaisNovosQue() throws IOException {
        List<Veiculo> veiculos = veiculoService.filtrarVeiculosMaisNovosQue(2020);
        assertEquals(8, veiculos.size());
        assertTrue(veiculos.stream().allMatch(v -> v.getAno() > 2020));
    }
}
