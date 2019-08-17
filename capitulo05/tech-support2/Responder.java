import java.util.ArrayList;
import java.util.Random;

/**
 * A classe Responder representa um objeto gerador de resposta.
 * É utilizada para gerar uma resposta automática aleatoriamente
 * selecionando uma frase a partir de uma lista predefinida de respostas.
 * 
 * @author     Michael Kolling and David J. Barnes
 * @version    0.2
 */
public class Responder
{
    private Random randomGenerator;
    private ArrayList<String> responses;

    /**
     * Cria um respondente.
     */
    public Responder()
    {
        randomGenerator = new Random();
        responses = new ArrayList<String>();
        fillResponses();
    }

    /**
     * Gera uma resposta.
     * 
     * @return  Uma string que deve ser exibida como a resposta.
     */
    public String generateResponse()
    {
        // Seleciona um número aleatório para o indice na
        // lista de respostas padrão.
        // O número aleatório estará entre 0 (inclusivo) e o tamanho
        // da lista (exclusivo).
        int index = randomGenerator.nextInt(responses.size());
        return responses.get(index);
    }

    /**
     * Constrói uma lista de respostas padrão da qual podemos
     * selecionar uma se não soubermos mais o que dizer.
     */
    private void fillResponses()
    {
        responses.add("That sounds odd. Could you describe that problem in more detail?");
        responses.add("No other customer has ever complained about this before. \n" +
                      "What is your system configuration?");
        responses.add("That sounds interesting. Tell me more...");
        responses.add("I need a bit more information on that.");
        responses.add("Have you checked that you do not have a dll conflict?");
        responses.add("That is explained in the manual. Have you read the manual?");
        responses.add("Your description is a bit wishy-washy. Have you got an expert\n" +
                      "there with you who could describe this more precisely?");
        responses.add("That's not a bug, it's a feature!");
        responses.add("Could you elaborate on that?");
    }
}
