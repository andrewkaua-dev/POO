public class Produto {
    private int codigo;
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(int codigo, String nome, double preco, int quantidade) {
        if (codigo <= 0)
            throw new IllegalArgumentException("Código deve ser maior que zero.");
        if (nome == null || nome.trim().length() < 3 || nome.trim().length() > 30)
            throw new IllegalArgumentException("Nome deve ter entre 3 e 30 caracteres.");
        if (preco < 1 || preco > 10000)
            throw new IllegalArgumentException("Preço deve estar entre 1 e 10000.");
        if (quantidade < 0)
            throw new IllegalArgumentException("Quantidade não pode ser negativa.");

        this.codigo = codigo;
        this.nome = nome.trim();
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade < 0)
            throw new IllegalArgumentException("Quantidade não pode ser negativa.");
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nome: " + nome + ", Preço: R$ " + preco + ", Estoque: " + quantidade;
    }
}
