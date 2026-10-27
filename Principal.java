import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            // Menu principal
            System.out.println("====== MENU PRINCIPAL ======");
            System.out.println("1. Módulo Produto");
            System.out.println("2. Módulo Cliente");
            System.out.println("3. Módulo Estoque");
            System.out.println("4. Módulo Vendas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    moduloProduto(sc);
                    break;
                case 2:
                    moduloCliente(sc);
                    break;
                case 3:
                    moduloEstoque(sc);
                    break;
                case 4:
                    moduloVendas(sc);
                    break;
                case 5:
                    System.out.println("Saindo do sistema... Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 5);

        sc.close();
    }

    // ----- MÓDULO PRODUTO -----
    public static void moduloProduto(Scanner sc) {
        int opcao;
        do {
            System.out.println("\n--- MÓDULO PRODUTO ---");
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Listar produtos");
            System.out.println("3. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Cadastrar produto - (implementar depois)");
                    break;
                case 2:
                    System.out.println("Listar produtos - (implementar depois)");
                    break;
                case 3:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 3);
    }

    // ----- MÓDULO CLIENTE -----
    public static void moduloCliente(Scanner sc) {
        int opcao;
        do {
            System.out.println("\n--- MÓDULO CLIENTE ---");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Cadastrar cliente - (implementar depois)");
                    break;
                case 2:
                    System.out.println("Listar clientes - (implementar depois)");
                    break;
                case 3:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 3);
    }

    // ----- MÓDULO ESTOQUE -----
    public static void moduloEstoque(Scanner sc) {
        int opcao;
        do {
            System.out.println("\n--- MÓDULO ESTOQUE ---");
            System.out.println("1. Consultar estoque");
            System.out.println("2. Atualizar estoque");
            System.out.println("3. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Consultar estoque - (implementar depois)");
                    break;
                case 2:
                    System.out.println("Atualizar estoque - (implementar depois)");
                    break;
                case 3:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 3);
    }

    // ----- MÓDULO VENDAS -----
    public static void moduloVendas(Scanner sc) {
        int opcao;
        do {
            System.out.println("\n--- MÓDULO VENDAS ---");
            System.out.println("1. Realizar venda");
            System.out.println("2. Listar vendas");
            System.out.println("3. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Realizar venda - (implementar depois)");
                    break;
                case 2:
                    System.out.println("Listar vendas - (implementar depois)");
                    break;
                case 3:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 3);
    }
}
