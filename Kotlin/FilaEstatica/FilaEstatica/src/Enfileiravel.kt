interface Enfileiravel {
    // metodos 1
    fun enfileirar(dado: Any?)
    fun desenfilerar(): Any?
    fun frente(): Any?
    fun atualizar(dado: Any?)

    // metodos 2
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}