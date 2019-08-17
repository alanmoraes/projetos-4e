import java.util.ArrayList;

/**
 * Uma classe que mantem uma lista de notas arbritariamente longa.
 * As notas são numeradas para referência externa por um usuário humano.
 * Nessa versão, os números de nota inciam em 0.
 *
 * @author David J. Barnes and Michael Kolling.
 * @version 2008.03.30
 */
public class Notebook
{
    // Campo para um número arbitrário de notas.
    private ArrayList<String> notes;

    /**
     * Realiza qualquer inicialização necessária para o bloco de notas.
     */
    public Notebook()
    {
        notes = new ArrayList<String>();
    }

    /**
     * Armazena uma nova nota no bloco de notas.
     * @param note A nota a ser armazenada.
     */
    public void storeNote(String note)
    {
        notes.add(note);
    }

    /**
     * @return O número de notas atualmente no bloco de notas.
     */
    public int numberOfNotes()
    {
        return notes.size();
    }

    /**
     * Mostra uma nota.
     * @param noteNumber O número da nota a ser mostrada.
     */
    public void showNote(int noteNumber)
    {
        if(noteNumber < 0) {
            // Este não é um número válido de nota, então nao faz nada.
        }
        else if(noteNumber < numberOfNotes()) {
            // Este é um número válido de nota, podemos imprimi-lo.
            System.out.println(notes.get(noteNumber));
        }
        else {
            // Este não é um número válido de nota, então não faz nada.
        }
    }
}
