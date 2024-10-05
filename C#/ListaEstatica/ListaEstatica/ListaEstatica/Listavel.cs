namespace ListaEstatica;

public interface IListavel<T>
{
    // métodos 1 //
    
    void Anexar(T dado);
    void Inserir(int posicao, T dado);
    T? Selecionar(int posicao);
    T[]? SelecionarTodos();
    void Atualizar(int posicao, T dado);
    T? Apagar(int posicao);
    void ApagarTodos();
    
    // métodos 2 //

    bool EstaCheia();
    bool EstaVazia();
    string Imprimir();
}