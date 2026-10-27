import java.util.List;
import java.util.Scanner;

public class ModuloEstoque {
    private ModuloProduto moduloProduto;

    public ModuloEstoque(ModuloProduto moduloProduto) {
        this.moduloProduto = moduloProduto;
    }

    public void cadastrarEstoque(Scanner sc) {
        System.out.print("Digite o código do produto para adicionar ao estoque: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        List<Produto> produtos = moduloProduto.getListaProdutos();
        Produto produtoEncontrado = null;

        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) {
                produtoEncontrado = p;
                break;
            }
        }

        if (produtoEncontrado == null) {
            System.out.println("❌ Produto não encontrado no cadastro.");
            return;
        }

        System.out.println("Produto: " + produtoEncontrado.getNome());
        System.out.print("Digite a quantidade a adicionar no estoque: ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        if (quantidade <= 0) {
            System.out.println("❌ Quantidade inválida.");
            return;
        }

        // Atualiza estoque do produto
        int novaQuantidade = produtoEncontrado.getQuantidade() + quantidade;
        produtoEncontrado.setQuantidade(novaQuantidade);

        System.out.println("✅ Estoque atualizado. Quantidade atual: " + novaQuantidade);
    }

    public void menuEstoque(Scanner sc) {
        int opcao;
        do {
            System.out.println("\n--- MÓDULO ESTOQUE ---");
            System.out.println("1. Cadastro de produtos no estoque");
            System.out.println("9. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> cadastrarEstoque(sc);
                case 9 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 9);
    }
}
