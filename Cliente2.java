public class Cliente {
    private String cpfCnpj;
    private String nome;
    private String email;
    private String endereco;

    public Cliente(String cpfCnpj, String nome, String email, String endereco) {
        this.cpfCnpj = cpfCnpj;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }
}
