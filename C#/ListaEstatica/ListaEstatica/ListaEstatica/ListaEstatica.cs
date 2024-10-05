namespace ListaEstatica;

public class ListaEstatica <T> (int tamanho = 10) : IListavel<T>
{
    // variáveis //
    private int _ponteiroInicio = 0;
    private int _ponteiroFim = -1;
    private int _quantidade = 0;
    private T[] _dados = new T[tamanho];
    
    // métodos 1 //
    
    public void Anexar(T dado)
    {
        if (!EstaCheia())
        {
            _ponteiroFim++;

            if (_ponteiroFim >= _dados.Length)
            {
                _ponteiroFim = 0;
            }
            
            _dados[_ponteiroFim] = dado;
            _quantidade++;
        }
        else
        {
            throw new SystemException("Lista Cheia!");
        }
    }

    public void Inserir(int posicao, T dado)
    {
        if (!EstaCheia())
        {
            if (posicao >= 0 && posicao <= _dados.Length)
            {
                int posicaoFisica = (_ponteiroInicio + posicao) % _dados.Length;
                int ponteiroAux = _ponteiroFim + 1;

                for (int i = posicao; i < _quantidade; i++)
                {
                    int anterior = ponteiroAux - 1;

                    if (ponteiroAux == _dados.Length)
                    {
                        ponteiroAux = 0;
                    }
                
                    int atual = ponteiroAux;
                
                    _dados[atual] = _dados[anterior];
                    ponteiroAux--;
                }
            
                _dados[posicaoFisica] = dado;
                _ponteiroFim++;

                if (_ponteiroFim == _dados.Length)
                {
                    _ponteiroFim = 0;
                }

                _quantidade++;
            }
            else
            {
                throw new SystemException("Indice inválido!");
            }
        }
        else
        {
            throw new SystemException("Lista Cheia!");
        }
    }

    public T? Selecionar(int posicao)
    {
        T? retorno = default(T);
        
        if (!EstaVazia())
        {
            if (posicao >= 0 && posicao <= _dados.Length)
            {
                int posicaoFisca = (_ponteiroInicio + posicao) % _dados.Length;
                retorno = _dados[posicaoFisca];
            }
        }
        else
        {
            throw new SystemException("Lista Vazia!");
        }
        
        return retorno;
    }

    public T[]? SelecionarTodos()
    {
        T[]? retorno = null;
        int ponteiroAux = _ponteiroInicio;

        if (!EstaVazia())
        {
            for (int i = 0; i < _quantidade; i++)
            {
                retorno![i] = _dados[(ponteiroAux + 1) % _dados.Length]; 
            }
        }
        else
        {
            throw new SystemException("Lista Vazia!");
        }
        
        return retorno;
    }

    public void Atualizar(int posicao, T dado)
    {
        if (!EstaVazia())
        {
            if (posicao >= 0 && posicao <= _dados.Length)
            {
                int posicaoFisica = (_ponteiroInicio + posicao) % _dados.Length;
                _dados[posicaoFisica] = dado;
            }
            else
            {
                throw new SystemException("Indice inválido!");
            }
        }
        else
        {
            throw new SystemException("Lista Vazia!");
        }
    }

    public T? Apagar(int posicao)
    {
        T? retorno = default(T);

        if (!EstaVazia())
        {
            if (posicao >= 0 && posicao <= _dados.Length)
            {
                int posicaoFisica  = (_ponteiroInicio + posicao) % _dados.Length;
                int ponteiroAux = posicaoFisica;

                for (int i = 0; i < _quantidade - 1; i++)
                {
                    int atual = ponteiroAux;
                    int proximo = (ponteiroAux + 1) % _dados.Length;
                    
                    _dados[atual] = _dados[proximo];
                    ponteiroAux++;
                }

                _ponteiroFim--;

                if (_ponteiroFim == -1)
                {
                    _ponteiroFim = _dados.Length - 1;
                }

                _quantidade--;
            }
            else
            {
                throw new SystemException("Indice inválido");
            }
        }
        else
        {
            throw new SystemException("Lista Vazia!");
        }
        
        return retorno;
    }

    public void ApagarTodos()
    {
        for (int i = 0; i < _quantidade; i++)
        {
            Apagar(i);
        }
    }

    // métodos 2 //
    
    public bool EstaCheia()
    {
        return _quantidade == _dados.Length;
    }

    public bool EstaVazia()
    {
        return _quantidade == 0;
    }

    public string Imprimir()
    {
        string retorno = "[";

        for (int i = 0, ponteiroAux = _ponteiroInicio; i < _quantidade; i++, ponteiroAux++)
        {
            retorno += _dados[ponteiroAux % _dados.Length];

            if (i != _quantidade - 1)
            {
                retorno += ", ";
            }
        }

        return $"{retorno}]";
    }
}