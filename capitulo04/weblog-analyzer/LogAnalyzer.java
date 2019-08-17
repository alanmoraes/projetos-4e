/**
 * Le dados de um servidor da Web e analisa os padrões de acesso por hora.
 *
 * @author David J. Barnes and Michael Kolling.
 * @version 2008.03.30
 */
public class LogAnalyzer
{
    // Array para armazenar as contagens de acesso por hora.
    private int[] hourCounts;
    // Utiliza um LogfileReader para acessar os dados.
    private LogfileReader reader;

    /**
     * Cria um objeto para analisar acessos à Web por hora.
     */
    public LogAnalyzer()
    {
        // Cria o objeto array para armazenas as contagens de acesso por hora.
        hourCounts = new int[24];
        // Cria o leitor para obter os dados.
        reader = new LogfileReader();
    }

    /**
     * Analisa os dados de acesso por hora do arquivo de log.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasMoreEntries()) {
            LogEntry entry = reader.nextEntry();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Imprime as contagens por hora.
     * Isso deve ter sido configurado com uma chamada anterior
     * a analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }

    /**
     * Imprime as linhas de dados lidas pelo LogfileReader atualmente.
     */
    public void printData()
    {
        reader.printData();
    }
}
