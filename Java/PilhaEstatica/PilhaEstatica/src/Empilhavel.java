public interface Empilhavel <T> {
    // metodos 1
    public void empilhar(T dado);
    public T desempilhar();
    public T topo();

    // metodos 2
    public boolean estaCheia();
    public boolean estaVazia();
    public String imprimir();
}
