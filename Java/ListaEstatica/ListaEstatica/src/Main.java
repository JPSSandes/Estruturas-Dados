public class Main {
    public static void main(String[] args) {
        Listavel<String> listaEstatica = new ListaEstatica<>();
        listaEstatica.anexar("A");
        listaEstatica.anexar("B");
        listaEstatica.anexar("C");
        listaEstatica.anexar("D");
        listaEstatica.anexar("E");
        listaEstatica.anexar("F");
        listaEstatica.anexar("G");
        listaEstatica.anexar("H");
        listaEstatica.anexar("I");
        listaEstatica.anexar("J");
        System.out.println(listaEstatica.imprimir());
    }
}