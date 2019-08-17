import java.util.*;

/**
 * A classe LabClass representa uma lista de inscrição para uma aula. Ela guarda
 * a hora, sala, os alunos, assim como o nome do professor.
 *
 * @author Michael Kolling and David Barnes
 * @version 2008.03.30
 */
public class LabClass
{
    private String instructor;
    private String room;
    private String timeAndDay;
    private List<Student> students;
    private int capacity;

    /**
     * Cria uma aula com um número máximo de inscritos. Todos os outros detalhes
     * são inicializados com valores padrão.
     */
    public LabClass(int maxNumberOfStudents)
    {
        instructor = "unknown";
        room = "unknown";
        timeAndDay = "unknown";
        students = new ArrayList<Student>();
        capacity = maxNumberOfStudents;
    }

    /**
     * Adiciona um aluno à aula.
     */
    public void enrollStudent(Student newStudent)
    {
        if(students.size() == capacity) {
            System.out.println("The class is full, you cannot enrol.");
        }
        else {
            students.add(newStudent);
        }
    }

    /**
     * Retorna o número de alunos atualmente matriculados na aula.
     */
    public int numberOfStudents()
    {
        return students.size();
    }

    /**
     * Define o número da sala para a aula.
     */
    public void setRoom(String roomNumber)
    {
        room = roomNumber;
    }

    /**
     * Define a hora para a aula. O parâmetro deve definir o dia e hora do dia,
     * por exemplo "Sexta-Feira, 10:00".
     */
    public void setTime(String timeAndDayString)
    {
        timeAndDay = timeAndDayString;
    }

    /**
     * Define o nome do professor para a aula.
     */
    public void setInstructor(String instructorName)
    {
        instructor = instructorName;
    }

    /**
     * Imprime na tela uma lista com os detalhes da aula.
     */
    public void printList()
    {
        System.out.println("Lab class " + timeAndDay);
        System.out.println("Instructor: " + instructor + "   room: " + room);
        System.out.println("Class list:");
        for(Student student : students) {
            student.print();
        }
        System.out.println("Number of students: " + numberOfStudents());
    }
}
