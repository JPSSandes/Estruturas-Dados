class FilaEstatica(private val tamanho : Int = 10) : Enfileiravel {
    private var ponteiroInicio : Int = 0
    private var ponteiroFim : Int = -1
    private var quantidade : Int = 0
    private var dados : Array<Any?> = arrayOfNulls(tamanho)

    override fun enfileirar(dado: Any?) {
        if (!estaCheia()) {
            ponteiroFim++
            dados[(ponteiroFim+1)% dados.size] = dado
            quantidade++
        } else {
            println("Fila Cheia!")
        }
    }

    override fun desenfilerar(): Any? {
        var retorno: Any? = null

        if (!estaVazia()) {
            retorno = dados[(ponteiroInicio+1)%dados.size]
            ponteiroInicio++
            quantidade--
        } else {
            println("Fila Vazia!")
        }

        return retorno
    }

    override fun frente(): Any? {
        var retorno: Any? = null

        if (!estaVazia()) {
            retorno = dados[(ponteiroInicio+1)%dados.size]
        } else {
            println("Fila Vazia!")
        }

        return retorno
    }

    override fun atualizar(dado: Any?) {
        if (!estaVazia()) {
            dados[ponteiroInicio] = dado
        } else {
            println("Fila Vazia!")
        }
    }

    override fun estaCheia(): Boolean {
        return quantidade == dados.size
    }

    override fun estaVazia(): Boolean {
        return quantidade == 0
    }

    override fun imprimir(): String {
        var retorno = "["
        var ponteiroAux = ponteiroInicio

        for (i in 0 .. quantidade -1) {
            retorno += "${dados[(ponteiroAux+1)%dados.size]}"

            if (i != quantidade -1) {
                retorno += ", "
            }

            ponteiroAux++
        }

        return "$retorno]"
    }
}