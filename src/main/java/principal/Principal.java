package principal;

import exception.InputInvalidoException;
import model.*;
import service.*;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class Principal {
    ObterDados obterDados = new ObterDados();
    ConverterDados converterDados = new ConverterDados();
    UsuarioDados usuarioDados = new UsuarioDados();
    ConsumoDados consumoDados = new ConsumoDados();

    public void exibeMenu() throws IOException, InterruptedException {
        String opcaoUsuario = usuarioDados.getInputUsuarioTipoVeiculo();
        String opcaoUsuarioPadronizado = opcaoUsuario.toLowerCase().replace("õ", "o");

        if (opcaoUsuarioPadronizado.contains("carros")
                | opcaoUsuarioPadronizado.contains("motos")
                | opcaoUsuarioPadronizado.contains("caminhoes")
        ) {
            this.centralDeProcessos(opcaoUsuario);
        }

        throw new InputInvalidoException(opcaoUsuarioPadronizado + " inválido. Tente novamente conforme instrução");
    }

    private void centralDeProcessos(String opcaoUsuario) throws IOException, InterruptedException {
        this.exibeMarcas(opcaoUsuario);
        this.exibeModelos();
        List<Dados> dadosCarros = this.exibeAnos();

        dadosCarros.forEach(v -> {
            try {
                this.exibeVeiculos(v.codigo());
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

    }

    private void exibeMarcas(String opcaoUsuario) throws IOException, InterruptedException {
        String enderecoVeiculo = obterDados.obterDadosMarcas(opcaoUsuario);

        String jsonMarcas = consumoDados.consumoFipeApi(enderecoVeiculo);

        List<Dados> marcasVeiculos = converterDados.obterLista(jsonMarcas, Dados.class);

        marcasVeiculos.stream()
                .sorted(Comparator.comparing(Dados::nomeCodigo))
                .forEach(e -> System.out.println("Código: " + e.codigo() + " - " + e.nomeCodigo()));
    }

    private void exibeModelos() throws IOException, InterruptedException {
        int opcaoUsuarioMarca = usuarioDados.getInputUsuarioMarcas();
        String enderecoModelos = obterDados.obterDadosModelos(opcaoUsuarioMarca);
        String jsonModelos = consumoDados.consumoFipeApi(enderecoModelos);
        Modelos modelosVeiculo = converterDados.obterDados(jsonModelos, Modelos.class);
        modelosVeiculo.modelos().stream()
                .sorted(Comparator.comparing(Dados::nomeCodigo))
                .forEach(e -> System.out.println("Código: " + e.codigo() + " - " + e.nomeCodigo()));
    }

    private List<Dados> exibeAnos() throws IOException, InterruptedException {
        int opcaoUsuarioModelo = usuarioDados.getInputUsuarioModelos();
        String enderecoAnos = obterDados.obterDadosAnos(opcaoUsuarioModelo);
        String jsonAnos = consumoDados.consumoFipeApi(enderecoAnos);
        return converterDados.obterLista(jsonAnos, Dados.class);
    }

    private void exibeVeiculos(String codigoVeiculo) throws IOException, InterruptedException {
        String enderecoVeiculo = obterDados.obterDadosVeiculo(codigoVeiculo);
        String jsonVeiculo = consumoDados.consumoFipeApi(enderecoVeiculo);
        VeiculoRecord veiculoRecord = converterDados.obterDados(jsonVeiculo, VeiculoRecord.class);
        Veiculo veiculo = new Veiculo(veiculoRecord);
        System.out.println(veiculo);
    }
}
