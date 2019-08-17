import java.awt.*;

/**
 * Um quadrado que pode ser manipulado e desenha a si mesmo em um canvas.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class Square
{
    private int size;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;

    /**
     * Cria um novo quadrado com posição e cor pré definidas.
     */
    public Square()
    {
        size = 30;
        xPosition = 60;
        yPosition = 50;
        color = "red";
        isVisible = false;
    }

    /**
     * Torna este quadrado visível. Se já estiver visível, não faz nada.
     */
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }

    /**
     * Torna este quadrado invisível. Se já estiver invisível, não faz nada.
     */
    public void makeInvisible()
    {
        erase();
        isVisible = false;
    }

    /**
     * Move o quadrado alguns pixels para a direita.
     */
    public void moveRight()
    {
        moveHorizontal(20);
    }

    /**
     * Move o quadrado alguns pixels para a esquerda.
     */
    public void moveLeft()
    {
        moveHorizontal(-20);
    }

    /**
     * Move o quadrado alguns pixels para cima.
     */
    public void moveUp()
    {
        moveVertical(-20);
    }

    /**
     * Move o quadrado alguns pixels para baixo.
     */
    public void moveDown()
    {
        moveVertical(20);
    }

    /**
     * Move o quadrado horizontalmente por 'distance' pixels.
     */
    public void moveHorizontal(int distance)
    {
        erase();
        xPosition += distance;
        draw();
    }

    /**
     * Move o quadrado verticalmente por 'distance' pixels.
     */
    public void moveVertical(int distance)
    {
        erase();
        yPosition += distance;
        draw();
    }

    /**
     * Move lentamente o quadrado horizontalmente por 'distance' pixels.
     */
    public void slowMoveHorizontal(int distance)
    {
        int delta;

        if(distance < 0)
        {
            delta = -1;
            distance = -distance;
        }
        else
        {
            delta = 1;
        }

        for(int i = 0; i < distance; i++)
        {
            xPosition += delta;
            draw();
        }
    }

    /**
     * Move lentamente o quadrado verticalmente por 'distance' pixels.
     */
    public void slowMoveVertical(int distance)
    {
        int delta;

        if(distance < 0)
        {
            delta = -1;
            distance = -distance;
        }
        else
        {
            delta = 1;
        }

        for(int i = 0; i < distance; i++)
        {
            yPosition += delta;
            draw();
        }
    }

    /**
     * Altera o tamanho para o novo tamanho (em pixels). Tamanho deve ser >= 0.
     */
    public void changeSize(int newSize)
    {
        erase();
        size = newSize;
        draw();
    }

    /**
     * Altera a cor. As cores válidas são "red", "yellow", "blue", "green",
     * "magenta" e "black".
     */
    public void changeColor(String newColor)
    {
        color = newColor;
        draw();
    }

    /**
     * Desenha o quadrado na tela com as especificações atuais.
     */
    private void draw()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color,
                        new Rectangle(xPosition, yPosition, size, size));
            canvas.wait(10);
        }
    }

    /**
     * Apaga o quadrado na tela.
     */
    private void erase()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}
