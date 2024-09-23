namespace FilaEstatica;

class Program
{
    static void Main(string[] args)
    {
        IEnfileiravel<string> filaEstatica = new FilaEstatica<string>();
        
        filaEstatica.Enfileirar("A");
        filaEstatica.Enfileirar("B");
        filaEstatica.Enfileirar("C");
        Console.WriteLine(filaEstatica.Imprimir());
    }
}