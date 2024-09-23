namespace FilaEstatica;

public class FilaEstatica <T> (int tamanho = 10) : IEnfileiravel<T>
{
    private int ponteiroInicio = 0;
    private int ponteiroFim = -1;
    private int quantidade = 0;
    private T[]? dados = new T[tamanho];
    
    public void Enfileirar(T dado)
    {
        if (!EstaCheia())
        {
            ponteiroFim++;
            dados[(ponteiroFim+1)%dados.Length] = dado;
            quantidade++;
        }
        else
        {
            throw new SystemException("Fila Cheia!");
        }
    }

    public T? Desenfileirar()
    {
        T? retorno = default(T);

        if (!EstaVazia())
        {
            retorno = dados[(ponteiroInicio+1)%dados.Length];
            ponteiroInicio++;
            quantidade--;
        }
        else
        {
            throw new SystemException("Fila Vazia!");
        }
        
        return retorno;
    }

    public T? Frente()
    {
        T? retorno = default(T);

        if (!EstaVazia())
        {
            retorno = dados[(ponteiroInicio+1)%dados.Length];
        }
        else
        {
            throw new SystemException("Fila Vazia!");
        }
        
        return retorno;
    }

    public void Atualizar(T dado)
    {
        if (!EstaVazia())
        {
            dados[ponteiroInicio] = dado;
        }
        else
        {
            throw new SystemException("Fila Vazia!");  
        }
    }

    public bool EstaCheia()
    {
        return quantidade == dados!.Length;
    }

    public bool EstaVazia()
    {
        return quantidade == 0;
    }

    public string Imprimir()
    {
        String resultado = "[";
        int ponteiroAux = ponteiroInicio;

        for (int i = 0; i < quantidade; i++)
        {
            resultado += dados[(ponteiroAux+1)%dados.Length];

            if (i != quantidade -1)
            {
                resultado += ", ";
            }

            ponteiroAux++;
        }
        
        return $"{resultado}]";
    }
}