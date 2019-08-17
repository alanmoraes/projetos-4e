import java.util.ArrayList;

/**
 * A classe database fornece um recurso para armazenar objetos CD e
 * objetos DVD. Uma lista de todos os CDs e DVDs pode ser impressa
 * no terminal de saída.
 * 
 * Essa versão não salva os dados no disco e
 * não fornece nenhuma função de pesquisa.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Database
{
    private ArrayList<CD> cds; // Lista de CDs
    private ArrayList<DVD> dvds; // Lista de DVDs

    /**
     * Constrói um banco de dados vazio.
     */
    public Database()
    {
        cds = new ArrayList<CD>();
        dvds = new ArrayList<DVD>();
    }

    /**
     * Adiciona um CD ao banco de dados.
     * @param theCD O CD a ser adicionado ao banco de dados.
     */
    public void addCD(CD theCD)
    {
        cds.add(theCD);
    }

    /**
     * Adiciona um DVD ao banco de dados.
     * @param theDVD O DVD a ser adicionado ao banco de dados.
     */
    public void addDVD(DVD theDVD)
    {
        dvds.add(theDVD);
    }

    /**
     * Imprime uma lista de todos os CDs e DVDs atualmente armazenados
     * no terminal de texto.
     */
    public void list()
    {
        // Imprime uma lista de CDs
        for(CD cd : cds) {
            cd.print();
            System.out.println();   // linha vazia entre itens
        }

        // Imprime uma lista de DVDs
        for(DVD dvd : dvds) {
            dvd.print();
            System.out.println();   // linha vazia entre itens
        }
    }
}
