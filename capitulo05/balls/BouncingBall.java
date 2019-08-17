import java.awt.*;
import java.awt.geom.*;

/**
 * Classe BouncingBall - Uma bola gráfica que está sob efeito da gravidade. A bola
 * possui habilidade para mover-se. Detalhes do movimento são determinados pela própria bola.
 * Ela "cairá para baixo", acelerando com o "tempo" devido ao efeito da gravidade, e irá quicar
 * para cima ao atingir o chão.
 *
 * Este movimento pode ser iniciado por sucessivas chamadas ao método "move".
 * 
 * @author Bruce Quig
 * @author Michael Kolling (mik)
 * @author David J. Barnes
 *
 * @version 2008.03.30
 */

public class BouncingBall
{
    private static final int GRAVITY = 3;  // Efeito da gravidade

    private int ballDegradation = 2;
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int groundPosition;      // Posição Y do chão
    private Canvas canvas;
    private int ySpeed = 1;                // Velocidade inicial de queda

    /**
     * Construtor para objetos da classe BouncingBall
     *
     * @param xPos  A coordenada horizontal da bola
     * @param yPos  A coordenada vertical da bola
     * @param ballDiameter  O diâmtro (em pixels) da bola
     * @param ballColor  A cor da bola
     * @param groundPos  A posição do chão (onde a bola irá quicar)
     * @param drawingCanvas  O canvas/janela em que será desenhada a bola
     */
    public BouncingBall(int xPos, int yPos, int ballDiameter, Color ballColor,
                        int groundPos, Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        groundPosition = groundPos;
        canvas = drawingCanvas;
    }

    /**
     * Desenha a bola em sua atual posição dentro do canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Apaga a bola na posição onde ela se encontra.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Movimenta a bola de acordo com sua posição e velocidade, em seguida, redesenha-a.
     **/
    public void move()
    {
        // Remove-a do canvas em sua atual (antiga) posição
        erase();
            
        // Computa a nova posição
        ySpeed += GRAVITY;
        yPosition += ySpeed;
        xPosition +=2;

        // Verifica se ela atingiu o chão
        if(yPosition >= (groundPosition - diameter) && ySpeed > 0) {
            yPosition = (int)(groundPosition - diameter);
            ySpeed = -ySpeed + ballDegradation; 
        }

        // Desenha novamente, dessa vez na nova posição
        draw();
    }    

    /**
     * Retorna a posição horizontal desta bola
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * Retorna a posição vertical desta bola
     */
    public int getYPosition()
    {
        return yPosition;
    }
}
