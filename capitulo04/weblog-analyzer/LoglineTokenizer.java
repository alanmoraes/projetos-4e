import java.util.Scanner;

/**
 * Divide uma linha de um arquivo de log de um servidor web em seus respectivos
 * campos.
 * No momento, presume-se que o arquivo de log contem apenas números inteiros
 * que representam informações de data e hora.
 *
 * @author David J. Barnes and Michael Kolling.
 * @version 2008.03.30
 */
public class LoglineTokenizer
{
    /**
     * Constrói um LogLineAnalyzer
     */
    public LoglineTokenizer()
    {
    }

    /**
     * Divide uma linha de log em tokens. Armazena os valores em um array.
     * O número de tokens na linha devem ser suficientes para preencher o array.
     *
     * @param logline A linha a ser dividida em tokens.
     * @param dataLine Onde armazenar os valores.
     */
    public void tokenize(String logline, int[] dataLine)
    {
        try {
            // Varre a linha de log em busca de valores inteiros.
            Scanner tokenizer = new Scanner(logline);
            for(int i = 0; i < dataLine.length; i++) {
                dataLine[i] = tokenizer.nextInt();
            }
        }
        catch(java.util.NoSuchElementException e) {
            System.out.println("Insuffient data items on log line: " + logline);
            throw e;
        }
    }
}
