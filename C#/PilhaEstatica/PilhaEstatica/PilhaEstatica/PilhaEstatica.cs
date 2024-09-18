namespace PilhaEstatica;

public class PilhaEstatica <T> (int tamanho = 10) : IEmpilhavel<T>
{
    private int ponteiroTopo = -1;
    private T[] dados = new T[10];
    
    public void Empilhar(T dado)
    {
        if (!EstaCheia())
        {
            ponteiroTopo++;
            dados[ponteiroTopo] = dado;
        }
        else
        {
            Console.WriteLine("Pilha Cheia!");
        }
    }

    public T? Desempilhar()
    {
        T retorno = default(T);

        if (!EstaVazia())
        {
            retorno = dados[ponteiroTopo];
            ponteiroTopo--;
        }
        else
        {
            Console.WriteLine("Pilha Vazia!");
        }

        return retorno;
    }

    public T? Topo()
    {
        T retorno = default(T);

        if (!EstaVazia())
        {
            retorno = dados[ponteiroTopo];
        }
        else
        {
            Console.WriteLine("Pilha Vazia!");
        }

        return retorno;
    }

    public bool EstaCheia()
    {
        return ponteiroTopo == dados.Length - 1;
    }

    public bool EstaVazia()
    {
        return ponteiroTopo == -1;
    }

    public string Imprimir()
    {
        var retorno = "";

        for (int i = ponteiroTopo; i >= 0; i--)
        {
            retorno += dados[i] + "\n";
        }
        
        return retorno;
    }
}