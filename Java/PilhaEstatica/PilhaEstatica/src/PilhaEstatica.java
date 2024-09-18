public class PilhaEstatica <T> implements Empilhavel{
    private int ponteiroTopo;
    private T[] dados;

    public PilhaEstatica(int tamanho) {
        ponteiroTopo = -1;
        dados = (T[]) new Object[tamanho];
    }

    public PilhaEstatica() {
        this(10);
    }

    @Override
    public void empilhar(Object dado) {
        if (!estaCheia()) {
            ponteiroTopo++;
            dados[ponteiroTopo] = (T) dado;
        } else {
            System.out.println("Pilha Cheia!");
        }
    }

    @Override
    public Object desempilhar() {
        Object retorno = null;

        if (!estaVazia()) {
            retorno = dados[ponteiroTopo];
            ponteiroTopo--;
        } else {
            System.out.println("Pilha Vazia!");
        }

        return retorno;
    }

    @Override
    public Object topo() {
        Object retorno = null;

        if (!estaVazia()) {
            retorno = dados[ponteiroTopo];
        } else {
            System.out.println("Pilha Vazia!");
        }

        return retorno;
    }

    @Override
    public boolean estaCheia() {
        return ponteiroTopo == dados.length - 1;
    }

    @Override
    public boolean estaVazia() {
        return ponteiroTopo == -1;
    }

    @Override
    public String imprimir() {
        String retorno = "[";

        for (int i = ponteiroTopo; ponteiroTopo > -1; i--) {
            retorno += dados[i] + "\n";
        }

        return retorno;
    }
}
