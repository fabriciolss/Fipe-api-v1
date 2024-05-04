package service;

import java.util.Scanner;

public class UsuarioDados {
    private Scanner leitor = new Scanner(System.in);

    public UsuarioDados() {
        String textoMenu = "**** OPÇÕES ****";
        System.out.println(textoMenu);
    }

    public String getInputUsuarioTipoVeiculo() {
        System.out.println("Digite uma das opções para consultar valores:");
        System.out.println("Carros");
        System.out.println("Motos");
        System.out.println("Caminhões");

        return leitor.nextLine().toLowerCase().replace("õ", "o");
    }

    public Integer getInputUsuarioMarcas() {
        System.out.println("Informe o código da marca para consulta:");
        return leitor.nextInt();
    }

    public String getInputUsuarioTrechoCarro() {
        System.out.println("Digite um trecho do nome do veículo para consulta:");
        return leitor.nextLine();
    }

    public Integer getInputUsuarioModelos() {
        System.out.println("Informe o código da modelo para consulta:");
        return leitor.nextInt();
    }
}
