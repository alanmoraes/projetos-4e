import java.util.HashSet;

/**
 * Essa classe implementa um sistema de suporte técnico. Ela é
 * a classe de nível superior deste projeto. O sistema de suporte
 * comunica-se via entrada/saída de texto no terminal de texto.
 * 
 * Essa classe utiliza um objeto da classe InputReader para ler
 * a entrada fornecida pelo usuário e um objeto da classe Responder
 * para gerar respostas.
 * Ela contém um loop que lê repetidamente a entrada e
 * gera a saída até que o usuário queira sair.
 * 
 * @author     Michael Kolling and David J. Barnes
 * @version    1.0
 */
public class SupportSystem
{
    private InputReader reader;
    private Responder responder;
    
    /**
     * Cria um sistema de suporte técnico.
     */
    public SupportSystem()
    {
        reader = new InputReader();
        responder = new Responder();
    }

    /**
     * Inicia o sistema de suporte técnico. Isso imprimirá uma
     * mensagem de boas-vindas e entrará em um diálogo com o usuário,
     * até que o usuário encerre o diálogo.
     */
    public void start()
    {
        boolean finished = false;

        printWelcome();

        while(!finished) {
            HashSet<String> input = reader.getInput();

            if(input.contains("bye")) {
                finished = true;
            }
            else {
                String response = responder.generateResponse(input);
                System.out.println(response);
            }
        }
        printGoodbye();
    }

    /**
     * Imprima uma mensagem de boas-vindas na tela.
     */
    private void printWelcome()
    {
        System.out.println("Welcome to the DodgySoft Technical Support System.");
        System.out.println();
        System.out.println("Please tell us about your problem.");
        System.out.println("We will assist you with any problem you might have.");
        System.out.println("Please type 'bye' to exit our system.");
    }

    /**
     * Imprime uma mensagem de despedida na tela.
     */
    private void printGoodbye()
    {
        System.out.println("Nice talking to you. Bye...");
    }
}
