namespace ListaEstatica;

class Program
{
    static void Main(string[] args)
    {
        IListavel<string> listaEstatica = new ListaEstatica<string>();
        listaEstatica.Anexar("A");
        listaEstatica.Anexar("B");
        listaEstatica.Anexar("C");
        listaEstatica.Anexar("D");
        listaEstatica.Anexar("E");
        listaEstatica.Anexar("F");
        listaEstatica.Anexar("G");
        listaEstatica.Anexar("H");
        listaEstatica.Anexar("I");
        listaEstatica.Anexar("J");
        Console.WriteLine(listaEstatica.Imprimir());
    }
}