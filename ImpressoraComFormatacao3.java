package aula;

public class ImpressoraComFormatacao extends Impressora {

    @Override
    public void imprimir(String texto) {
        System.out.println("******************************");
        System.out.println(texto.toUpperCase());
        System.out.println("******************************");
    }
}
