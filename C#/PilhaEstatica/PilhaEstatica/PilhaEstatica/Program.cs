namespace PilhaEstatica;

class Program
{
    static void Main(string[] args)
    {
        IEmpilhavel<string> pilhaEstatica = new PilhaEstatica<string>(3);
        pilhaEstatica.Empilhar("Untouchables");
        pilhaEstatica.Empilhar("Hybrid Theory");
        pilhaEstatica.Empilhar("White Pony");
        Console.WriteLine(pilhaEstatica.Imprimir());
    }
}