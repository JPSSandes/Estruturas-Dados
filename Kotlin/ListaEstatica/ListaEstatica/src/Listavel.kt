interface Listavel {
    //  métodos 1 //
    fun anexar(dado: Any?)
    fun inserir(posicao: Int, dado: Any?)
    fun selecionar(posicao: Int) : Any?
    fun selecionarTodos(): Array<Any?>
    fun atualizar(posicao: Int, dado: Any?)
    fun apagar(posicao: Int): Any?
    fun apagarTodos()

    // métodos 2 //
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}