namespace FilaEstatica;

public interface IEnfileiravel <T>
{
    // metodos 1
    public void Enfileirar(T dado);
    public T? Desenfileirar();
    public T? Frente();
    public void Atualizar(T dado);
    
    // metodos 2
    public bool EstaCheia();
    public bool EstaVazia();
    public string Imprimir();
}