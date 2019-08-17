import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 * Uma classe para ler informações de um arquivo de acessos a um servidor web.
 * No momento, presume-se que o arquivo de log contem apenas números inteiros
 * que representam informações de data e hora no formato:
 *
 *    ano mes dia hora minuto
 * Entradas de log estão ordenadas por data em ordem ascendente.
 *
 * @author David J. Barnes and Michael Kolling.
 * @version 2008.03.30
 */
public class LogfileReader
{
    // O formato dos dados no arquivo de log.
    private String format;
    // Onde o conteúdo dos arquivos estão armazenados no formado de objetos
    // do tipo LogEntry.
    private ArrayList<LogEntry> entries;
    // Um iterator para as entradas.
    private Iterator<LogEntry> dataIterator;

    /**
     * Cria um LogfileReader para abastecer de dados oriundos de um arquivo padrão.
     */
    public LogfileReader()
    {
        this("weblog.txt");
    }

    /**
     * Cria um LogfileReader para ser abastecido de dados oriundos de um arquivo
     * de log específico.
     * @param filename O arquivo de log.
     */
    public LogfileReader(String filename)
    {
        // O formato dos dados.
        format = "Year Month(1-12) Day Hour Minute";
        // Onde armazenar os dados.
        entries = new ArrayList<LogEntry>();

        // Tenta ler todo o conjunto de dados do arquivo.
        boolean dataRead;
        try{
            // Localiza o arquivo em relacao ao ambiente atual.
            URL fileURL = getClass().getClassLoader().getResource(filename);
            if(fileURL == null) {
                throw new FileNotFoundException(filename);
            }
            Scanner logfile = new Scanner(new File(fileURL.toURI()));
            // Le as linhas de dados ate o fim do arquivo.
            while(logfile.hasNextLine()) {
                String logline = logfile.nextLine();
                // Quebra a linha e adiciona a lista de entradas.
                LogEntry entry = new LogEntry(logline);
                entries.add(entry);
            }
            logfile.close();
            dataRead = true;
        }
        catch(FileNotFoundException e) {
            System.out.println("Problem encountered: " + e);
            dataRead = false;
        }
        catch(URISyntaxException e) {
            System.out.println("Problem encountered: " + e);
            dataRead = false;
        }
        // Se nao pudermos ler o arquivo de log, utilize dados fabricados.
        if(!dataRead) {
            System.out.println("Failed to read the data file: " +
                               filename);
            System.out.println("Using simulated data instead.");
            createSimulatedData(entries);
        }
        // Ordene as entradas em ordem ascendente.
        Collections.sort(entries);
        reset();
    }

    /**
     * Ainda tem mais dados para abastecer?
     * @return true se ainda houver mais dados disponiveis,
     *        falso do contrario.
     */
    public boolean hasMoreEntries()
    {
        return dataIterator.hasNext();
    }

    /**
     * Analiza a proxima linha do arquivo de log e a torna disponivel atraves
     * de um objeto do tipo LogEntry.
     *
     * @return Um LogEntry contendo os dados da proxima linha do log.
     */
    public LogEntry nextEntry()
    {
        return dataIterator.next();
    }

    /**
     * @return Uma string explicando o formado dos dados no arquivo de log.
     */
    public String getFormat()
    {
        return format;
    }

    /**
     * Cria um novo iterador que fornece acesso aos dados.
     * Isto permite que um unico arquivo de dados seja
     * processado mais de uma vez.
     */
    public void reset()
    {
        dataIterator = entries.iterator();
    }

    /**
     * Imprime os dados.
     */
    public void printData()
    {
        for(LogEntry entry : entries) {
            System.out.println(entry);
        }
    }

    /**
     * Fornece uma amostra de dados fabricados.
     * NB: Para simplificar a criacao destes dados, nao é gerado nenhum dia
     * apos o dia 28 de cada mes.
     * @param data Onde armazenar os dados fabricados de objetos LogEntry.
     */
    private void createSimulatedData(ArrayList<LogEntry> data)
    {
        // Para cada item (ano, mes, dia, hora, minuto) o menor valor valido
        // é listado.
        int[] lowest = { 2006, 1, 1, 0, 0, };
        // Para cada item (ano, mes, dia, hora, minuto) a variacao dos valores
        // validos é listada. (Note a simplificacao de ter apenas 28 dias
        // em um mes para evitar a geracao de datas invalidas.)
        int[] range = { 3, 12, 28, 24, 60 };
        // Usa um parametro fixo para gerar os dados aleatorios para que
        // os dados sejam reproduziveis.
        Random rand = new Random(12345);
        // Constroi cada linha em um string buffer.
        StringBuffer line = new StringBuffer();
        // Quantas linhas nós queremos.
        int numLines = 100;
        // O numero de valores para cada linha.
        int itemsPerLine = lowest.length;
        for(int i = 0; i < numLines; i++) {
            for(int j = 0; j < itemsPerLine; j++) {
                int value = lowest[j]+rand.nextInt(range[j]);
                line.append(value);
                line.append(' ');
            }            
            // Converte a linha em um LogEntry.
            LogEntry entry = new LogEntry(line.toString());
            data.add(entry);
            line.setLength(0);
        }
    }
}
