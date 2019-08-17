import java.awt.*;
import java.awt.geom.*;

/**
 * Classe BallDemo - provê duas pequenas demonstrações mostrando como usar 
 * a classe Canvas.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Cria um objeto BallDemo. Cria um Canvas limpo e torna-o visível.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        myCanvas.setVisible(true);
    }
 
    /**
     * Demonstra algumas das operações de desenhos
     * disponíveis em um objeto do tipo Canvas.
     */
    public void drawDemo()
    {
        myCanvas.setFont(new Font("helvetica", Font.BOLD, 14));
        myCanvas.setForegroundColor(Color.red);

        myCanvas.drawString("We can draw text, ...", 20, 30);
        myCanvas.wait(1000);

        myCanvas.setForegroundColor(Color.black);
        myCanvas.drawString("...draw lines...", 60, 60);
        myCanvas.wait(500);
        myCanvas.setForegroundColor(Color.gray);
        myCanvas.drawLine(200, 20, 300, 50);
        myCanvas.wait(500);
        myCanvas.setForegroundColor(Color.blue);
        myCanvas.drawLine(220, 100, 370, 40);
        myCanvas.wait(500);
        myCanvas.setForegroundColor(Color.green);
        myCanvas.drawLine(290, 10, 320, 120);
        myCanvas.wait(1000);

        myCanvas.setForegroundColor(Color.gray);
        myCanvas.drawString("...and shapes!", 110, 90);

        myCanvas.setForegroundColor(Color.red);

        // A geometria para desenhar e mover
        int xPos = 10;
        Rectangle rect = new Rectangle(xPos, 150, 30, 20);

        // Move o retangulo pela tela
        for(int i = 0; i < 200; i ++) {
            myCanvas.fill(rect);
            myCanvas.wait(10);
            myCanvas.erase(rect);
            xPos++;
            rect.setLocation(xPos, 150);
        }
        // Ao fim do movimento, desenha mais uma vez para mantê-lo visível.
        myCanvas.fill(rect);
    }

    /**
     * Simula duas bolas saltando
     */
    public void bounce()
    {
        int ground = 400;   // Posição da linha inferior (chão)

        myCanvas.setVisible(true);

        // Desenha o chão
        myCanvas.drawLine(50, ground, 550, ground);

        // Cria e mostra as bolas
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.blue, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.red, ground, myCanvas);
        ball2.draw();

        // Faz com que fiquem saltitando.
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // Pequeno delay
            ball.move();
            ball2.move();
            // Para assim que a bola houver percorrido uma certa distância no eixo-x
            if(ball.getXPosition() >= 550 && ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
        ball.erase();
        ball2.erase();
    }
}
