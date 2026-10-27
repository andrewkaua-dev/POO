import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ModuloVenda {
    private List<Produto> listaProdutos;
    private List<Venda> listaVendas;

    public ModuloVenda(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
        this.listaVendas = new ArrayList<>();
    }

    // 1 - Realização da venda
    public void realizarVenda(Scanner sc) {
        System.out.println("\n--- REALIZAÇÃO DE VENDA ---");

        List<ItemVenda> itensVenda = new ArrayList<>();
        double total = 0.0;

        String continuar = "s";

        do {
            System.out.print("Digite 1 para buscar por código ou 2 para buscar por nome: ");
            int tipoBusca = sc.nextInt();
            sc.nextLine(); // limpa buffer

            Produto produto = null;

            if (tipoBusca == 1) {
                System.out.print("Digite o código do produto: ");
                int codigo = sc.nextInt();
                sc.nextLine();

                for (Produto p : listaProdutos) {
                    if (p.getCodigo() == codigo) {
                        produto = p;
                        break;
                    }
                }
            } else if (tipoBusca == 2) {
                System.out.print("Digite o nome do produto: ");
                String nome = sc.nextLine();

                for (Produto p : listaProdutos) {
                    if (p.getNome().equalsIgnoreCase(nome)) {
                        produto = p;
                        break;
                    }
                }
            } else {
                System.out.println("Opção inválida para tipo de busca.");
                continue;
            }

            if (produto == null) {
                System.out.println("❌ Produto não encontrado!");
                continue;
            }

            System.out.println("Produto encontrado: " + produto.getNome() + " | Estoque: " + produto.getQuantidade());

            System.out.print("Digite a quantidade desejada: ");
            int qtd = sc.nextInt();
            sc.nextLine();

            if (qtd <= 0 || qtd > produto.getQuantidade()) {
                System.out.println("❌ Quantidade inválida ou indisponível no estoque!");
                continue;
            }

            // Atualiza estoque
            produto.setQuantidade(produto.getQuantidade() - qtd);

            // Adiciona item na lista da venda
            itensVenda.add(new ItemVenda(produto.getNome(), qtd, produto.getPreco()));
            total += produto.getPreco() * qtd;

            System.out.print("Deseja adicionar outro produto? (s/n): ");
            continuar = sc.nextLine().trim().toLowerCase();

        } while (continuar.equals("s"));

        if (itensVenda.isEmpty()) {
            System.out.println("Nenhum produto vendido.");
            return;
        }

        Venda venda = new Venda(itensVenda, total);
        listaVendas.add(venda);

        System.out.println("✅ Venda registrada com sucesso! Total: R$ " + total);
    }

    // 2 - Relatório de produtos vendidos (nome e preço)
    public void relatorioProdutosVendidos() {
        System.out.println("\n--- RELATÓRIO DE PRODUTOS VENDIDOS (NOME E PREÇO) ---");
        if (listaVendas.isEmpty()) {
            System.out.println("Nenhuma venda realizada.");
            return;
        }
        for (Venda v : listaVendas) {
            for (ItemVenda item : v.getItens()) {
                System.out.println("Produto: " + item.getNome() + " | Preço: R$ " + item.getPreco());
            }
        }
    }

    // 3 - Relatório de quantidades vendidas
    public void relatorioQuantidadesVendidas() {
        System.out.println("\n--- RELATÓRIO DE QUANTIDADES VENDIDAS ---");
        if (listaVendas.isEmpty()) {
            System.out.println("Nenhuma venda realizada.");
            return;
        }
        for (Venda v : listaVendas) {
            for (ItemVenda item : v.getItens()) {
                System.out.println("Produto: " + item.getNome() + " | Quantidade: " + item.getQuantidade());
            }
        }
    }

    // 4 - Total de vendas
    public void totalVendas() {
        double soma = 0.0;
        for (Venda v : listaVendas) {
            soma += v.getTotal();
        }
        System.out.println("\n💰 Total de vendas realizadas: R$ " + soma);
    }

    // 5 - Maior e menor venda
    public void maiorMenorVenda() {
        if (listaVendas.isEmpty()) {
            System.out.println("\nNenhuma venda realizada ainda.");
            return;
        }

        Venda maior = listaVendas.get(0);
        Venda menor = listaVendas.get(0);

        for (Venda v : listaVendas) {
            if (v.getTotal() > maior.getTotal()) maior = v;
            if (v.getTotal() < menor.getTotal()) menor = v;
        }

        System.out.println("\n📈 Maior venda: R$ " + maior.getTotal());
        System.out.println("📉 Menor venda: R$ " + menor.getTotal());
    }

    // Menu do módulo venda
    public void menuVenda(Scanner sc) {
        int opcao;
        do {
            System.out.println("\n--- MÓDULO VENDA ---");
            System.out.println("1. Realizar venda");
            System.out.println("2. Relatório de produtos vendidos (nome e preço)");
            System.out.println("3. Relatório de quantidades vendidas");
            System.out.println("4. Total de vendas");
            System.out.println("5. Maior e menor venda");
            System.out.println("9. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> realizarVenda(sc);
                case 2 -> relatorioProdutosVendidos();
                case 3 -> relatorioQuantidadesVendidas();
                case 4 -> totalVendas();
                case 5 -> maiorMenorVenda();
                case 9 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 9);
    }
}
