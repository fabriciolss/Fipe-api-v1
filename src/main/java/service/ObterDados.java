package service;

public class ObterDados extends EnderecoDados {
    EnderecoDados enderecoDados = new EnderecoDados();

    public String obterDadosMarcas(String tipoVeiculo) {
        this.enderecoDados.setEnderecoMarcas(tipoVeiculo);
        return this.enderecoDados.getEnderecoMarcas();
    }

    public String obterDadosModelos(int codigoMarca) {
        this.enderecoDados.setEnderecoModelos(codigoMarca);
        return this.enderecoDados.getEnderecoModelos();
    }

    public String obterDadosAnos(int codigoAnos) {
        this.enderecoDados.setEnderecoAnos(codigoAnos);
        return this.enderecoDados.getEnderecoAnos();
    }

    public String obterDadosVeiculo(String codigoVeiculo) {
        this.enderecoDados.setEnderecoVeiculo(codigoVeiculo);
        return this.enderecoDados.getEnderecoVeiculo();
    }
}
