/**
 * Guarda os dados de uma única linha de um arquivo de log de um servidor web.
 * Os campos são acessados individualmente através de métodos de acesso como
 * getHour() e getMinute().
 *
 * @author David J. Barnes and Michael Kolling.
 * @version 2008.03.30
 */
public class LogEntry implements Comparable<LogEntry>
{
    // Array onde os dados extraídos de uma linha são guardados.
    private int[] dataValues;
    // Em que indices em dataValues os diferentes campos de uma linha de log
    // estão guardados.
    private static final int YEAR = 0, MONTH = 1, DAY = 2,
                             HOUR = 3, MINUTE = 4;

    /**
     * Decompõe uma linha de log para tornar os campos acessíveis
     * individualmente.
     * @param logline Uma única linha do log.
     */
    public LogEntry(String logline)
    {
        // O array para guardar os dados da linha.
        dataValues = new int[5];
        // Fragmenta a linha do log.
        LoglineTokenizer tokenizer = new LoglineTokenizer();
        tokenizer.tokenize(logline,dataValues);
    }

    /**
     * @return O campo hora da linha do log.
     */
    public int getHour()
    {
        return dataValues[HOUR];
    }

    /**
     * @return O campo minuto da linha do log.
     */
    public int getMinute()
    {
        return dataValues[MINUTE];
    }

    /**
     * Cria uma representação string dos dados.
     * Não é necessariamente identica ao texto original da linha do log.
     * @return Uma string representando os dados desta entrada.
     */
    public String toString()
    {
        StringBuffer buffer = new StringBuffer();
        for(int value : dataValues) {
           // Insere 0 como prefixo em números de um digito.
            if(value < 10) {
                buffer.append('0');
            }
            buffer.append(value);
            buffer.append(' ');
        }
        // Remove qualquer espaco em branco a direita.
        return buffer.toString().trim();
    }

    /**
     * Compara a combinação data/hora desta entrada de log com outra.
     * @param otherEntry A outra entrada para realizar a comparação.
     * @return Um valor negativo se esta entrada vier antes da outra.
     *         Um valor positivo se esta entrada vier depois da outra.
     *         Zero se as entradas forem iguais.
     */
    public int compareTo(LogEntry otherEntry)
    {
        if(otherEntry == this) {
            // São o mesmo objeto.
            return 0;
        }
        else {
            // Compara os campos.
            for(int i = 0; i < dataValues.length; i++) {
                int difference = dataValues[i] - otherEntry.dataValues[i];
                if(difference != 0) {
                    return difference;
                }
            }
            // Nenhum valor é diferente, logo as duas entradas representam
            // data/hora identicos.
            return 0;
        }
    }
}
