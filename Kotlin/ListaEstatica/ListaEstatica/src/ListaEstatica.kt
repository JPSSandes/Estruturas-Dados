class ListaEstatica(val tamanho: Int = 10) : Listavel {
    private var ponteiroInicio :  Int = 0
    private var ponteiroFim :  Int = 0
    private var quantidade :  Int = 0
    private var dados : Array<Any?> = arrayOfNulls(tamanho)

    // métodos 1 //
    override fun anexar(dado: Any?) {
        if (!estaCheia()) {
            ponteiroFim++
            dados[(ponteiroFim + 1) % dados.size] = dado
            quantidade++
        } else {
            println("Lista Cheia!")
        }
    }

    override fun inserir(posicao: Int, dado: Any?) {
        if (!estaCheia()) {
            if (posicao >= 0 && posicao <= quantidade) {
                var posicaoFisica = (ponteiroInicio + posicao) % dados.size
                var ponteiroAux = ponteiroFim + 1

                for (i in posicao until quantidade) {
                    var anterior = ponteiroAux - 1

                    if (ponteiroAux == dados.size) {
                        ponteiroAux = 0
                    }

                    var atual =  ponteiroAux

                    dados[atual] = dados[anterior]
                    ponteiroAux--
                }

                dados[posicaoFisica] = dado
                ponteiroFim++

                if (ponteiroFim == dados.size) {
                    ponteiroFim = 0
                }
                quantidade++
            } else {
                println("Indice inválido!")
            }
        } else {
            println("Lista Cheia!")
        }
    }

    override fun selecionar(posicao: Int) : Any? {
        var retorno : Any? = null

        if (!estaVazia()) {
            if (posicao >= 0 && posicao < quantidade) {
                var posicaoFisica = (ponteiroInicio + posicao) % dados.size

                retorno = dados[posicaoFisica]
            }
        } else {
            println("Lista Vazia!")
        }

        return retorno
    }

    override fun selecionarTodos(): Array<Any?> {
        val retorno : Array<Any?> = arrayOfNulls(quantidade)
        val ponteiroAux = ponteiroInicio

        if (!estaVazia()) {
            for (i in 0 until quantidade) {
                retorno[i] = dados[(ponteiroAux+1) % dados.size]
            }
        }

        return retorno
    }

    override fun atualizar(posicao: Int, dado: Any?) {
        if (!estaVazia()) {
            if (posicao >= 0 && posicao < quantidade) {
                var posicaoFisica = (ponteiroInicio + posicao) % dados.size
                dados[posicaoFisica] = dado
            } else  {
                println("Indice inválido")
            }
        } else {
            println("Lista Vazia!")
        }
    }

    override fun apagar(posicao: Int): Any? {
        var retorno: Any? = null

        if (!estaVazia()) {
            if (posicao >= 0 && posicao < quantidade) {
                var posicaoFisica = (ponteiroInicio + posicao) % dados.size
                var ponteiroAux = posicaoFisica

                for (i in posicao until quantidade - 1) {
                    var atual = ponteiroAux
                    var proximo = (ponteiroAux + 1) % dados.size

                    dados[atual] = dados[proximo]
                    ponteiroAux++
                }

                ponteiroFim--
                if (ponteiroFim == -1) {
                    ponteiroFim = dados.size - 1
                }

                quantidade--
            }
        } else {
            println("Lista Vazia!")
        }

        return retorno
    }

    override fun apagarTodos() {
        for (i in 0 until quantidade) {
            apagar(i)
        }
    }

    // métodos 2 //
    override fun estaCheia(): Boolean {
        return quantidade == dados.size
    }

    override fun estaVazia(): Boolean {
        return quantidade == 0
    }

    override fun imprimir(): String {
        var retorno = "["
        var ponteiroAux = ponteiroInicio + 1

        for (i in -1 until quantidade - 1) {
            retorno += "${dados[(ponteiroAux+1) % dados.size]}"

            if (i != quantidade - 2) {
                retorno += ", "
            }

            ponteiroAux++
        }

        return "$retorno]"
    }
}