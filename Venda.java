import java.util.List;

public class Venda {
    private List<ItemVenda> itens;
    private double total;

    public Venda(List<ItemVenda> itens, double total) {
        this.itens = itens;
        this.total = total;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public double getTotal() {
        return total;
    }
}
