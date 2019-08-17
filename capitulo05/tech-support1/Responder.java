/**
 * A classe Responder representa um gerador de respostas
 * HttpSession do usuário. É utilizada para gerar uma resposta automática.
 * 
 * @author     Michael Kolling and David J. Barnes
 * @version    0.1
 */
public class Responder
{
    /**
     * Constrói um Responder - nada a fazer
     */
    public Responder()
    {
    }

    /**
     * Gera uma resposta.
     * @return   Uma string que deve ser exibida como a resposta.
     */
    public String generateResponse()
    {
        return "That sounds interesting. Tell me more...";
    }
}
