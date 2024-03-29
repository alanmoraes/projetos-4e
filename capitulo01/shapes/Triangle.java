import java.awt.*;

/**
 * Um triângulo que pode ser manipulado e desenha a si mesmo em um canvas.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class Triangle
{
    private int height;
    private int width;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;

    /**
     * Cria um novo triângulo com posição e cor pré definidas.
     */
    public Triangle()
    {
        height = 30;
        width = 40;
        xPosition = 50;
        yPosition = 15;
        color = "green";
        isVisible = false;
    }

    /**
     * Torna este triângulo visível. Se já estiver visível, não faz nada.
     */
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }

    /**
     * Torna este triângulo invisível. Se já estiver invisível, não faz nada.
     */
    public void makeInvisible()
    {
        erase();
        isVisible = false;
    }

    /**
     * Move o triângulo alguns pixels para a direita.
     */
    public void moveRight()
    {
        moveHorizontal(20);
    }

    /**
     * Move o triângulo alguns pixels para a esquerda.
     */
    public void moveLeft()
    {
        moveHorizontal(-20);
    }

    /**
     * Move o triângulo alguns pixels para cima.
     */
    public void moveUp()
    {
        moveVertical(-20);
    }

    /**
     * Move o triângulo alguns pixels para baixo.
     */
    public void moveDown()
    {
        moveVertical(20);
    }

    /**
     * Move o triângulo horizontalmente por 'distance' pixels.
     */
    public void moveHorizontal(int distance)
    {
        erase();
        xPosition += distance;
        draw();
    }

    /**
     * Move o triângulo verticalmente por 'distance' pixels.
     */
    public void moveVertical(int distance)
    {
        erase();
        yPosition += distance;
        draw();
    }

    /**
     * Move lentamente o triângulo horizontalmente por 'distance' pixels.
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
     * Move lentamente o triângulo verticalmente por 'distance' pixels.
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
    public void changeSize(int newHeight, int newWidth)
    {
        erase();
        height = newHeight;
        width = newWidth;
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
     * Desenha o triângulo na tela com as especificações atuais.
     */
    private void draw()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            int[] xpoints = { xPosition, xPosition + (width/2), xPosition - (width/2) };
            int[] ypoints = { yPosition, yPosition + height, yPosition + height };
            canvas.draw(this, color, new Polygon(xpoints, ypoints, 3));
            canvas.wait(10);
        }
    }

    /**
     * Apaga o triângulo na tela.
     */
    private void erase()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}
