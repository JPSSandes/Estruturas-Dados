@SuppressWarnings({"unchecked", "rawtypes"})
public class FilaEstatica <T> implements Enfileiravel{
    private int ponteiroInicio;
    private int ponteiroFim;
    private int quantidade;
    private final T[] dados;

    public FilaEstatica(int tamanho){
        ponteiroInicio = 0;
        ponteiroFim = -1;
        quantidade = 0;
        dados = (T[]) new Object[tamanho];
    }

    public FilaEstatica() {
        this(10);
    }

    @Override
    public void enfileirar(Object dado) {
        if(!estaCheia()) {
            ponteiroFim++;
            dados[(ponteiroFim+1)%dados.length] =(T) dado;
            quantidade++;
        } else {
            throw new RuntimeException("Fila Cheia!");
        }
    }

    @Override
    public Object desenfileirar() {
        Object retorno = null;

        if (!estaVazia()) {
            retorno = dados[(ponteiroInicio+1)%dados.length];
            ponteiroInicio++;
            quantidade--;
        } else {
            throw new RuntimeException("Fila Vazia!");
        }

        return retorno;
    }

    @Override
    public Object topo() {
        Object retorno = null;

        if (!estaVazia()) {
            retorno = dados[(ponteiroInicio+1)%dados.length];
        } else {
            throw new RuntimeException("Fila Vazia!");
        }

        return retorno;
    }

    @Override
    public void atualizar(Object dado) {
        if (!estaVazia()) {
            dados[ponteiroInicio] = (T) dado;
        } else {
            throw new RuntimeException("Fila Vazia!");
        }
    }

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
            retorno += dados[(ponteiroAux+1)%dados.length];

            if (i != quantidade-1) {
                retorno += ", ";
            }

            ponteiroAux++;
        }

        return retorno + "]";
    }
}
