public class Main {
    public static void main(String[] args) {
        Empilhavel<String> pilhaEstatica = new PilhaEstatica<>(3);
        pilhaEstatica.empilhar("Untouchables");
        pilhaEstatica.empilhar("Hybrid Theory");
        pilhaEstatica.empilhar("White Pony");
    }
}