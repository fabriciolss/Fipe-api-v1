package service;

public class EnderecoDados {
    private String enderecoMarcas;
    private String enderecoModelos;
    private String enderecoAnos;
    private String enderecoVeiculo;

    protected String getEnderecoMarcas() {
        return enderecoMarcas;
    }

    protected void setEnderecoMarcas(String tipoVeiculo) {
        this.enderecoMarcas = "https://parallelum.com.br/fipe/api/v1/" + tipoVeiculo + "/marcas/";
    }

    protected String getEnderecoModelos() {
        return this.enderecoModelos;
    }

    protected void setEnderecoModelos(int codigoMarca) {
        this.enderecoModelos = this.getEnderecoMarcas() + codigoMarca + "/modelos/";
    }

    protected String getEnderecoAnos() {
        return this.enderecoAnos;
    }

    protected void setEnderecoAnos(int codigoModelo) {
        this.enderecoAnos = this.getEnderecoModelos() + codigoModelo + "/anos/";
    }

    protected String getEnderecoVeiculo() {
        return this.enderecoVeiculo;
    }

    protected void setEnderecoVeiculo(String codigoVeiculo) {
        this.enderecoVeiculo = this.getEnderecoAnos() + codigoVeiculo;
    }
}
