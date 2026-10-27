import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ModuloProduto {
    private List<Produto> listaProdutos = new ArrayList<>();

    public void cadastrarProduto(Scanner sc) {
        System.out.println("\n--- CADASTRO DE PRODUTOS ---");

        System.out.print("Digite o código do produto (número inteiro): ");
        int codigo = sc.nextInt();
        sc.nextLine();

        for (Produto p : listaProdutos) {
            if (p.getCodigo() == codigo) {
                System.out.println("❌ Código já cadastrado!");
                return;
            }
        }

        System.out.print("Digite o nome do produto: ");
        String nome = sc.nextLine().trim();

        if (nome.isEmpty() || nome.length() < 3 || nome.length() > 30) {
            System.out.println("❌ Nome inválido! Deve ter entre 3 e 30 caracteres.");
            return;
        }

        System.out.print("Digite o preço do produto (entre 1 e 10000): ");
        double preco = sc.nextDouble();
        sc.nextLine();

        if (preco < 1 || preco > 10000) {
            System.out.println("❌ Preço inválido! Deve estar entre 1 e 10000.");
            return;
        }

        Produto novoProduto = new Produto(codigo, nome, preco, 0);
        listaProdutos.add(novoProduto);

        System.out.println("✅ Produto cadastrado com sucesso!");
    }

    public void relatorioProdutos() {
        System.out.println("\n--- RELATÓRIO DE PRODUTOS ---");
        if (listaProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        for (Produto p : listaProdutos) {
            System.out.println("Código: " + p.getCodigo() + " | Nome: " + p.getNome() + " | Preço: R$ " + p.getPreco() + " | Estoque: " + p.getQuantidade());
        }
    }

    public void buscarProduto(Scanner sc) {
        System.out.println("\n--- BUSCA DE PRODUTO ---");
        System.out.println("1 - Buscar por código");
        System.out.println("2 - Buscar por nome");
        System.out.print("Escolha uma opção: ");
        int opcao = sc.nextInt();
        sc.nextLine();

        if (opcao == 1) {
            System.out.print("Digite o código do produto: ");
            int codigo = sc.nextInt();
            sc.nextLine();

            for (Produto p : listaProdutos) {
                if (p.getCodigo() == codigo) {
                    System.out.println("Produto encontrado: Código: " + p.getCodigo() + ", Nome: " + p.getNome() + ", Preço: R$ " + p.getPreco() + ", Estoque: " + p.getQuantidade());
                    return;
                }
            }
            System.out.println("❌ Produto não encontrado.");
        } else if (opcao == 2) {
            System.out.print("Digite o nome do produto: ");
            String nome = sc.nextLine().trim();

            boolean encontrado = false;
            for (Produto p : listaProdutos) {
                if (p.getNome().toLowerCase().contains(nome.toLowerCase())) {
                    System.out.println("Produto encontrado: Código: " + p.getCodigo() + ", Nome: " + p.getNome() + ", Preço: R$ " + p.getPreco() + ", Estoque: " + p.getQuantidade());
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("❌ Produto não encontrado.");
            }
        } else {
            System.out.println("Opção inválida.");
        }
    }

    public void removerProduto(Scanner sc) {
        System.out.print("Digite o código do produto para remover: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        boolean removido = listaProdutos.removeIf(p -> p.getCodigo() == codigo);

        if (removido) {
            System.out.println("✅ Produto removido com sucesso.");
        } else {
            System.out.println("❌ Produto não encontrado.");
        }
    }

    public void menuProduto(Scanner sc) {
        int opcao;
        do {
            System.out.println("\n--- MÓDULO PRODUTO ---");
            System.out.println("1. Cadastro de Produtos");
            System.out.println("2. Relatório de Produtos");
            System.out.println("3. Busca de Produtos");
            System.out.println("4. Remoção de Produtos");
            System.out.println("9. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> cadastrarProduto(sc);
                case 2 -> relatorioProdutos();
                case 3 -> buscarProduto(sc);
                case 4 -> removerProduto(sc);
                case 9 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 9);
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }
}
