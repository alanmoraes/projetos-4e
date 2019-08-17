
/**
 * A classe Student representa um aluno em um sistema de administração
 * de alunos.
 * Ela mantém os detalhes de cada aluno relevantes em nosso contexto.
 *
 * @author Michael Kolling and David Barnes
 * @version 2008.03.30
 */
public class Student
{
    // o nome completo do aluno
    private String name;
    // a ID (matricula) do aluno
    private String id;
    // a quantidade de créditos obtidos pelo aluno até agora
    private int credits;

    /**
     * Cria um novo aluno com o nome e número de ID fornecidos.
     */
    public Student(String fullName, String studentID)
    {
        name = fullName;
        id = studentID;
        credits = 0;
    }

    /**
     * Retorna o nome completo do aluno.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Estabelece um novo nome para o aluno.
     */
    public void changeName(String replacementName)
    {
        name = replacementName;
    }

    /**
     * Retorna a ID do aluno.
     */
    public String getStudentID()
    {
        return id;
    }

    /**
     * Adiciona créditos aos créditos já acumulados pelo aluno.
     */
    public void addCredits(int additionalPoints)
    {
        credits += additionalPoints;
    }

    /**
     * Retorna o número de créditos acumulados pelo aluno.
     */
    public int getCredits()
    {
        return credits;
    }

    /**
     * Retorna o login do aluno. O login é uma combinação dos primeiros
     * quatro caracteres do nome do aluno com os três primeiros caracteres
     * do número de ID do aluno.
     */
    public String getLoginName()
    {
        return name.substring(0,4) + id.substring(0,3);
    }

    /**
     * Imprime o nome e o número de ID do aluno para o terminal de saída.
     */
    public void print()
    {
        System.out.println(name + " (" + id + ")");
    }
}
