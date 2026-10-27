import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ModuloCliente {
    private List<Cliente> listaClientes = new ArrayList<>();

    public void cadastrarCliente(Scanner sc) {
        System.out.println("\n--- CADASTRO DE CLIENTE ---");

        System.out.print("Digite CPF/CNPJ (mínimo 8 caracteres): ");
        String cpfCnpj = sc.nextLine().trim();

        if (cpfCnpj.isEmpty() || cpfCnpj.length() < 8) {
            System.out.println("❌ CPF/CNPJ inválido!");
            return;
        }

        // Verifica se já existe cliente com esse CPF/CNPJ
        for (Cliente c : listaClientes) {
            if (c.getCpfCnpj().equals(cpfCnpj)) {
                System.out.println("❌ CPF/CNPJ já cadastrado!");
                return;
            }
        }

        System.out.print("Digite o nome do cliente: ");
        String nome = sc.nextLine().trim();

        if (nome.isEmpty() || nome.length() < 3 || nome.length() > 50) {
            System.out.println("❌ Nome inválido! Deve ter entre 3 e 50 caracteres.");
            return;
        }

        System.out.print("Digite o email do cliente (pode deixar vazio): ");
        String email = sc.nextLine().trim();

        System.out.print("Digite o endereço do cliente (máximo 30 caracteres): ");
        String endereco = sc.nextLine().trim();

        if (endereco.isEmpty() || endereco.length() > 30) {
            System.out.println("❌ Endereço inválido!");
            return;
        }

        Cliente novoCliente = new Cliente(cpfCnpj, nome, email, endereco);
        listaClientes.add(novoCliente);

        System.out.println("✅ Cliente cadastrado com sucesso!");
    }

    public void relatorioClientes() {
        System.out.println("\n--- RELATÓRIO DE CLIENTES ---");
        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        for (Cliente c : listaClientes) {
            System.out.println("CPF/CNPJ: " + c.getCpfCnpj() + " | Nome: " + c.getNome() + " | Email: " + c.getEmail() + " | Endereço: " + c.getEndereco());
        }
    }

    public void buscarCliente(Scanner sc) {
        System.out.println("\n--- BUSCA DE CLIENTE ---");
        System.out.println("1 - Buscar por CPF/CNPJ");
        System.out.println("2 - Buscar por nome");
        System.out.println("3 - Buscar por endereço");
        System.out.print("Escolha uma opção: ");
        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1 -> {
                System.out.print("Digite o CPF/CNPJ: ");
                String cpfCnpj = sc.nextLine().trim();

                for (Cliente c : listaClientes) {
                    if (c.getCpfCnpj().equals(cpfCnpj)) {
                        System.out.println("Cliente encontrado: CPF/CNPJ: " + c.getCpfCnpj() + ", Nome: " + c.getNome() + ", Email: " + c.getEmail() + ", Endereço: " + c.getEndereco());
                        return;
                    }
                }
                System.out.println("❌ Cliente não encontrado.");
            }
            case 2 -> {
                System.out.print("Digite o nome: ");
                String nome = sc.nextLine().trim();

                boolean encontrado = false;
                for (Cliente c : listaClientes) {
                    if (c.getNome().equalsIgnoreCase(nome)) {
                        System.out.println("Cliente encontrado: CPF/CNPJ: " + c.getCpfCnpj() + ", Nome: " + c.getNome() + ", Email: " + c.getEmail() + ", Endereço: " + c.getEndereco());
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    System.out.println("❌ Cliente não encontrado.");
                }
            }
            case 3 -> {
                System.out.print("Digite o endereço: ");
                String endereco = sc.nextLine().trim();

                boolean encontrado = false;
                for (Cliente c : listaClientes) {
                    if (c.getEndereco().equalsIgnoreCase(endereco)) {
                        System.out.println("Cliente encontrado: CPF/CNPJ: " + c.getCpfCnpj() + ", Nome: " + c.getNome() + ", Email: " + c.getEmail() + ", Endereço: " + c.getEndereco());
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    System.out.println("❌ Cliente não encontrado.");
                }
            }
            default -> System.out.println("Opção inválida.");
        }
    }

    public void removerCliente(Scanner sc) {
        System.out.print("Digite o CPF/CNPJ para remover: ");
        String cpfCnpj = sc.nextLine().trim();

        boolean removido = listaClientes.removeIf(c -> c.getCpfCnpj().equals(cpfCnpj));

        if (removido) {
            System.out.println("✅ Cliente removido com sucesso.");
        } else {
            System.out.println("❌ Cliente não encontrado.");
        }
    }

    public void menuCliente(Scanner sc) {
        int opcao;
        do {
            System.out.println("\n--- MÓDULO CLIENTE ---");
            System.out.println("1. Cadastro de Cliente");
            System.out.println("2. Relatório de Clientes");
            System.out.println("3. Busca de Clientes");
            System.out.println("4. Remoção de Clientes");
            System.out.println("9. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> cadastrarCliente(sc);
                case 2 -> relatorioClientes();
                case 3 -> buscarCliente(sc);
                case 4 -> removerCliente(sc);
                case 9 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 9);
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }
}
