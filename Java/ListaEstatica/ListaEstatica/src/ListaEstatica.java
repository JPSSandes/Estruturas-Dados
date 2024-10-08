public class ListaEstatica <T> implements Listavel<T> {
    // variáveis //

    private int ponteiroInicio;
    private int ponteiroFim;
    private int quantidade;
    private T[] dados;

    // construtores //

    @SuppressWarnings("unchecked")
    public ListaEstatica(int tamanho) {
        ponteiroInicio = 0;
        ponteiroFim = -1;
        quantidade = 0;
        dados = (T[]) new Object[tamanho];
    }

    public ListaEstatica() {
        this(10);
    }

    // métodos 1 //

    @Override
    public void anexar(T dado) {
        if (!estaCheia()) {
            ponteiroFim++;

            if (ponteiroFim >= dados.length) {
                ponteiroFim = 0;
            }

            dados[ponteiroFim] = dado;
            quantidade++;
        } else {
            throw new RuntimeException("Lista Cheia!");
        }
    }

    @Override
    public void inserir(int posicao, T dado) {
        if (!estaCheia()) {
            if (posicao >= 0 && posicao < dados.length) {
                int posicaoFisica = (ponteiroInicio + posicao) % dados.length;
                int ponteiroAux = ponteiroFim + 1;

                for (int i = posicao; i < quantidade; i++) {
                    int anterior = ponteiroAux - 1;

                    if (ponteiroAux == dados.length) {
                        ponteiroAux = 0;
                    }

                    int atual = ponteiroAux;

                    dados[atual] = dados[anterior];
                    ponteiroAux--;
                }

                dados[posicaoFisica] = dado;
                ponteiroFim++;

                if (ponteiroFim == dados.length) {
                    ponteiroFim = 0;
                }
                quantidade++;
            } else {
                throw new RuntimeException("Indice Inválido!");
            }
        } else {
            throw new RuntimeException("Lista Cheia!");
        }
    }

    @Override
    public T selecionar(int posicao) {
        T retorno = null;

        if (!estaVazia()) {
            if (posicao >= 0 && posicao < dados.length) {
                int posicaoFisica = (ponteiroInicio + posicao) % dados.length;

                retorno = dados[posicaoFisica];
            }
        } else {
            throw new RuntimeException("Lista Vazia!");
        }

        return retorno;
    }

    @Override
    public T[] selecionarTodos() {
        T[] retorno = null;
        int ponteiroAux = ponteiroInicio;

        if (!estaVazia()) {
            for (int i = 0; i < quantidade; i++) {
                retorno[i] = dados[(ponteiroAux + 1) % dados.length];
            }
        }

        return retorno;
    }

    @Override
    public void atualizar(int posicao, T dado) {
        if (!estaVazia()) {
            if (posicao >= 0 && posicao < dados.length) {
                int posicaoFisica = (ponteiroInicio + posicao) % dados.length;
                dados[posicaoFisica] = dado;
            } else {
                throw new RuntimeException("Indice inválido!");
            }
        } else {
            throw new RuntimeException("Lista Vazia!");
        }
    }

    @Override
    public T apagar(int posicao) {
        T retorno = null;

        if (!estaVazia()) {
            if (posicao >= 0 && posicao < dados.length) {
                int posicaoFisica = (ponteiroInicio + posicao) % dados.length;
                int ponteiroAux = posicaoFisica;

                for (int i = 0; i < quantidade - 1; i++) {
                    int atual = ponteiroAux;
                    int proximo = (ponteiroAux + 1) % dados.length;

                    dados[atual] = dados[proximo];
                    ponteiroAux++;
                }

                ponteiroFim--;

                if (ponteiroFim == -1) {
                    ponteiroFim = dados.length - 1;
                }

                quantidade--;
            }
        } else {
            throw new RuntimeException("Lista Vazia!");
        }

        return retorno;
    }

    @Override
    public void apagarTodos() {
        for (int i = 0; i < quantidade; i++) {
            apagar(i);
        }
    }

    // métodos 2 //

    @Override
    public boolean estaCheia() {
        return quantidade == dados.length;
    }

    @Override
    public boolean estaVazia() {
        return quantidade == 0;
    }

    @Override
    public String imprimir() {
        String retorno = "[";
        int ponteiroAux = ponteiroInicio;

        for (int i = 0; i < quantidade; i++) {
            retorno += dados[ponteiroAux % dados.length];

            if (i != quantidade - 1) {
                retorno += ", ";
            }

            ponteiroAux++;
        }

        return retorno + "]";
    }
}
