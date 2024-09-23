public interface Enfileiravel <T> {
    // métodos 1
    void enfileirar(T dado);
    T desenfileirar();
    T topo();
    void atualizar(T dado);

    // métodos 2
    boolean estaCheia();
    boolean estaVazia();
    String imprimir();
}
