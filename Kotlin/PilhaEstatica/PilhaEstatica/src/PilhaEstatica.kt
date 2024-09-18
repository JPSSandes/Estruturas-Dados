class PilhaEstatica(private val tamanho: Int = 10): Empilhavel {
    private var ponteiroTopo: Int = -1
    private var dados: Array<Any?> = arrayOfNulls(tamanho)

    // metodos 1

    override fun empilhar(dado: Any?) {
        if (!estaCheia()) {
            ponteiroTopo++
            dados[ponteiroTopo] = dado
        } else {
            println("Pilha Cheia!");
        }
    }

    override fun desempilhar(): Any? {
        var retorno: Any? = null

        if (!estaVazia()) {
            retorno = dados[ponteiroTopo]
            ponteiroTopo--
        }

        return retorno
    }

    override fun topo(): Any? {
        var retorno: Any? = null

        if (!estaVazia()) {
            retorno = dados[ponteiroTopo]
        }

        return retorno
    }

    // metodos 2

    override fun estaCheia(): Boolean {
        return (ponteiroTopo == dados.size - 1)
    }

    override fun estaVazia(): Boolean {
        return (ponteiroTopo == -1)
    }

    override fun imprimir(): String {
        var impressao = "["

        for (i in ponteiroTopo downTo 0) {
            if (i == 0) {
                impressao += "${dados[i]}"
            } else {
                impressao  += "${dados[i]}, "
            }
        }

        return "${impressao}]"
    }
}