package br.com.aula.conexao;

import java.util.Scanner;

public class MainCLI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("===== MENU =====");
            System.out.println("1. Inserir dados");
            System.out.println("2. Ler dados");
            System.out.println("3. Atualizar dados");
            System.out.println("4. Deletar dados");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    inserirDados();
                    break;
                case 2:
                    LerDados.ler();
                    break;
                case 3:
                    AtualizarDados.atualizar();
                    break;
                case 4:
                    DeletarDados.deletar();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void inserirDados() {
        // Aqui você pode implementar a função de inserção caso ainda não tenha feito
        System.out.println("Função de inserção de dados chamada.");
    }
}
