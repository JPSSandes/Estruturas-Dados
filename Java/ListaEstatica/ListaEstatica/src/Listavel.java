public interface Listavel <T> {
    // métodos 1 //
    void anexar(T dado);
    void inserir (int posicao, T dado);
    T selecionar(int posicao);
    T[] selecionarTodos();
    void atualizar(int posicao, T dado);
    T apagar(int posicao);
    void apagarTodos();

    // métodos 2 //
    boolean estaCheia();
    boolean estaVazia();
    String imprimir();
}
