package aula;

import java.util.ArrayList;
import java.util.List;

public class Mainn {
    public static void main(String[] args) {

        // Instanciando as impressoras
        Impressora impressora1 = new ImpressoraComFormatacao();
        Impressora impressora2 = new ImpressoraSemFormatacao();

        // Criando lista e adicionando ambas
        List<Impressora> impressoras = new ArrayList<>();
        impressoras.add(impressora1);
        impressoras.add(impressora2);

        // Texto de exemplo
        String texto = "O Brasil é lindo";

        // Chamando o método imprimir para cada impressora
        for (Impressora imp : impressoras) {
            imp.imprimir(texto);
            System.out.println(); // Linha em branco entre as saídas
        }
    }
}
