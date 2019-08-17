import java.awt.*;
import java.awt.geom.*;

/**
 * Um círculo que pode ser manipulado e desenha a si mesmo em um canvas.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class Circle
{
    private int diameter;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;

    /**
     * Cria um novo círculo com posição e cor pré definidas.
     */
    public Circle()
    {
        diameter = 30;
        xPosition = 20;
        yPosition = 60;
        color = "blue";
        isVisible = false;
    }

    /**
     * Torna este círculo visível. Se já estiver visível, não faz nada.
     */
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }

    /**
     * Torna este círculo invisível. Se já estiver invisível, não faz nada.
     */
    public void makeInvisible()
    {
        erase();
        isVisible = false;
    }

    /**
     * Move o círculo alguns pixels para a direita.
     */
    public void moveRight()
    {
        moveHorizontal(20);
    }

    /**
     * Move o círculo alguns pixels para a esquerda.
     */
    public void moveLeft()
    {
        moveHorizontal(-20);
    }

    /**
     * Move o círculo alguns pixels para cima.
     */
    public void moveUp()
    {
        moveVertical(-20);
    }

    /**
     * Move o círculo alguns pixels para baixo.
     */
    public void moveDown()
    {
        moveVertical(20);
    }

    /**
     * Move o círculo horizontalmente por 'distance' pixels.
     */
    public void moveHorizontal(int distance)
    {
        erase();
        xPosition += distance;
        draw();
    }

    /**
     * Move o círculo verticalmente por 'distance' pixels.
     */
    public void moveVertical(int distance)
    {
        erase();
        yPosition += distance;
        draw();
    }

    /**
     * Move lentamente o círculo horizontalmente por 'distance' pixels.
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
     * Move lentamente o círculo verticalmente por 'distance' pixels.
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
    public void changeSize(int newDiameter)
    {
        erase();
        diameter = newDiameter;
        draw();
    }

    /**
     * Altera a cor. As cores válidas são "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor)
    {
        color = newColor;
        draw();
    }

    /**
     * Desenha o círculo na tela com as especificações atuais.
     */
    private void draw()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color, new Ellipse2D.Double(xPosition, yPosition,
                                                          diameter, diameter));
            canvas.wait(10);
        }
    }

    /**
     * Apaga o círculo na tela.
     */
    private void erase()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}
