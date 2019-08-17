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
     * Remove uma nota do bloco de notas se ela existir.
     * @param noteNumber O número da nota a ser removido.
     */
    public void removeNote(int noteNumber)
    {
        if(noteNumber < 0) {
            // Este não é um número válido de nota, então não faz nada.
        }
        else if(noteNumber < numberOfNotes()) {
            // Este é um número de nota válido, portanto, podemos removê-lo.
            notes.remove(noteNumber);
        }
        else {
            // Este não é um número válido de nota, então não faz nada.
        }
    }

    /**
     * Lista todas as notas no bloco de notas.
     */
    public void listNotes()
    {
        for(String note : notes) {
            System.out.println(note);
        }
    }
}
