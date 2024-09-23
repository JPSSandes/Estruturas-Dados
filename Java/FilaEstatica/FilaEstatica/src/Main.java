public class Main {
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void main(String[] args) {
        Enfileiravel<String> filaEstatica = new FilaEstatica<>();
        filaEstatica.enfileirar("A");
        filaEstatica.enfileirar("B");
        filaEstatica.enfileirar("C");
        System.out.println(filaEstatica.imprimir());
    }
}