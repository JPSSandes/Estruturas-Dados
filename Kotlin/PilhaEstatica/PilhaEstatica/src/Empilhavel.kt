interface Empilhavel {
    // metodos 1
    fun empilhar(dado: Any?)
    fun desempilhar(): Any?
    fun topo(): Any?

    // metodos 2
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}