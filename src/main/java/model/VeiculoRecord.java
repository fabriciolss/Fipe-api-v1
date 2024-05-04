package model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VeiculoRecord(@JsonAlias("Valor") String valorVeiculo,
                      @JsonAlias("Marca") String marcaVeiculo,
                      @JsonAlias("Modelo") String modeloVeiculo,
                      @JsonAlias("AnoModelo") int lancamentoVeiculo,
                      @JsonAlias("Combustivel") String combustivelVeiculo,
                      @JsonAlias("CodigoFipe") String codigoFipeVeiculo
) {
}
