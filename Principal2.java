import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ModuloProduto moduloProduto = new ModuloProduto();
        ModuloCliente moduloCliente = new ModuloCliente();
        ModuloEstoque moduloEstoque = new ModuloEstoque(moduloProduto);
        ModuloVenda moduloVenda = new ModuloVenda(moduloProduto.getListaProdutos());


        int opcao;
        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Produto");
            System.out.println("2. Cliente");
            System.out.println("3. Estoque");
            System.out.println("4. Venda");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> moduloProduto.menuProduto(sc);
                case 2 -> moduloCliente.menuCliente(sc);
                case 3 -> moduloEstoque.menuEstoque(sc);
                case 4 -> moduloVenda.menuVenda(sc);
                case 9 -> System.out.println("Saindo do programa...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 9);

        sc.close();
    }
}
