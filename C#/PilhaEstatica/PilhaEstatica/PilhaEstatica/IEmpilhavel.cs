namespace PilhaEstatica;

public interface IEmpilhavel <T>
{
    // métodos 1
    public void Empilhar(T dado);
    public T? Desempilhar();
    public T? Topo();
    
    // métodos 2
    public bool EstaCheia();
    public bool EstaVazia();
    public string Imprimir();
}