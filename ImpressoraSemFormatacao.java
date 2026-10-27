package aula;

public class ImpressoraSemFormatacao extends Impressora {

    @Override
    public void imprimir(String texto) {
        System.out.println("------------------------------");
        System.out.println(texto);
        System.out.println("------------------------------");
    }
}

