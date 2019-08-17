import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * Classe Canvas - Uma classe que permite operações de
 * desenho simples em um canvas/janela.
 * 
 * @author Michael Kolling (mik)
 * @author Bruce Quig
 *
 * @version 2008.03.30
 */

public class Canvas
{
    private JFrame frame;
    private CanvasPane canvas;
    private Graphics2D graphic;
    private Color backgroundColor;
    private Image canvasImage;

    /**
     * Cria um Canvas com altura, largura e cor de fundo padrões
     * (300, 300, white).
     * @param title    titulo para aparecer no Frame Canvas
     */
    public Canvas(String title)
    {
        this(title, 300, 300, Color.white);        
    }

    /**
     * Cria um Canvas com plano de fundo padrão (branco).
     * @param title    titulo para aparecer no Frame Canvas
     * @param width    a largura desejada para o Canvas
     * @param height   a altura desejada para o Canvas
     */
    public Canvas(String title, int width, int height)
    {
        this(title, width, height, Color.white);
    }

    /**
     * Cria um Canvas.
     * @param title    titulo para aparecer no Frame Canvas
     * @param width    a largura desejada para o Canvas
     * @param height   a altura desejada para o Canvas
     * @param bgColor  a cor desejada para a cor de fundo do canvas
     */
    public Canvas(String title, int width, int height, Color bgColor)
    {
        frame = new JFrame();
        canvas = new CanvasPane();
        frame.setContentPane(canvas);
        frame.setTitle(title);
        canvas.setPreferredSize(new Dimension(width, height));
        backgroundColor = bgColor;
        frame.pack();
    }

    /**
     * Define a visibilidade do canvas e traz para a frente da tela quando
     * tornado visível. Este método também pode ser usado para trazer um canvas
     * já visivel para a frente de outra tela.
     * @param visible  valor booleano representando a visibilidade desejada
     * para o canvas (verdadeiro ou falso)
     */
    public void setVisible(boolean visible)
    {
        if(graphic == null) {
            // first time: instantiate the offscreen image and fill it with
            // the background color
            Dimension size = canvas.getSize();
            canvasImage = canvas.createImage(size.width, size.height);
            graphic = (Graphics2D)canvasImage.getGraphics();
            graphic.setColor(backgroundColor);
            graphic.fillRect(0, 0, size.width, size.height);
            graphic.setColor(Color.black);
        }
        frame.setVisible(true);
    }

    /**
     * Provê a informação da visibilidade do Canvas.
     * @return  true se o canvas está visível, false caso contrário.
     */
    public boolean isVisible()
    {
        return frame.isVisible();
    }

    /**
     * Desenha o contorno de uma determinada geometria.
     * @param  shape  O objeto a ser desenhado no canvas
     */
    public void draw(Shape shape)
    {
        graphic.draw(shape);
        canvas.repaint();
    }
 
    /**
     * Preenche as dimensões internas de uma dada geometria com as atuais
     * cores de fundo do canvas.
     * @param  shape  A instância de forma/geometria a ser preenchida.
     */
    public void fill(Shape shape)
    {
        graphic.fill(shape);
        canvas.repaint();
    }

    /**
     * Preenche as dimensões internas de um dado círculo com as atuais
     * cores de fundo do canvas.
     */
    public void fillCircle(int xPos, int yPos, int diameter)
    {
        Ellipse2D.Double circle = new Ellipse2D.Double(xPos, yPos, diameter, diameter);
        fill(circle);
    }

    /**
     * Preenche as dimensões internas de um dado círculo com as atuais
     * cores de fundo do canvas. Este é um método conveniente/redundante.
     * Um efeito similar pode ser obtido através do método "fill".
     */
    public void fillRectangle(int xPos, int yPos, int width, int height)
    {
        fill(new Rectangle(xPos, yPos, width, height));
    }

    /**
     * Apaga todo o canvas. (não repinta.)
     */
    public void erase()
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        Dimension size = canvas.getSize();
        graphic.fill(new Rectangle(0, 0, size.width, size.height));
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * Apaga as dimensões internas de um determinado círculo.
     * Este é um método conveniente/redundante.
     * Um efeito similar pode ser obtido através do método "erase".
     */
    public void eraseCircle(int xPos, int yPos, int diameter)
    {
        Ellipse2D.Double circle = new Ellipse2D.Double(xPos, yPos, diameter, diameter);
        erase(circle);
    }

    /**
     * Apaga as dimensões internas de um determinado retângulo.
     * Este é um método conveniente/redundante.
     * Um efeito similar pode ser obtido através do método "erase".
     */
    public void eraseRectangle(int xPos, int yPos, int width, int height)
    {
        erase(new Rectangle(xPos, yPos, width, height));
    }

    /**
     * Apaga as dimensões internas de uma determinada geometria.
     * @param  shape  A instância de forma/geometria a ser apagada.
     */
    public void erase(Shape shape)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.fill(shape);              // erase by filling background color
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * Apaga as dimensões externas de uma determinada geometria.
     * @param  shape  A instância de forma/geometria a ser apagada.
     */
    public void eraseOutline(Shape shape)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.draw(shape);  // erase by drawing background color
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * Desenha uma imagem dentro do canvas.
     * @param  image   O objeto da imagem a ser exibida.
     * @param  x       Coordenada X para inserir a imagem.
     * @param  y       Coordenada Y para inserir a imagem.
     * @return  returna um booleano indicando se a imagem foi
     *          corretamente carregada
     */
    public boolean drawImage(Image image, int x, int y)
    {
        boolean result = graphic.drawImage(image, x, y, null);
        canvas.repaint();
        return result;
    }

    /**
     * Desenha uma String dentro do canvas.
     * @param  text   String a ser exibida. 
     * @param  x       Coordenada X para inserir o text.
     * @param  y       Coordenada Y para inserir o text.
     */
    public void drawString(String text, int x, int y)
    {
        graphic.drawString(text, x, y);   
        canvas.repaint();
    }

    /**
     * Apaga uma String desenhada no canvas (?!).
     * @param  text     the String to be displayed 
     * @param  x        x co-ordinate for text placement 
     * @param  y        y co-ordinate for text placement
     */
    public void eraseString(String text, int x, int y)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.drawString(text, x, y);   
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * Desenha uma linha no Canvas.
     * @param  x1   Coordenada X do inicio da linha.
     * @param  y1   Coordenada Y do inicio da linha.
     * @param  x2   Coordenada X do fim da linha.
     * @param  y2   Coordenada Y do fim da linha.
     */
    public void drawLine(int x1, int y1, int x2, int y2)
    {
        graphic.drawLine(x1, y1, x2, y2);   
        canvas.repaint();
    }

    /**
     * Define a cor do plano de frente do Canvas
     * @param  newColor  a nova cor para o plano de frente do Canvas
     */
    public void setForegroundColor(Color newColor)
    {
        graphic.setColor(newColor);
    }

    /**
     * Retorna a atual cor de frente do canvas.
     * @return   a cor de frente do canvas.
     */
    public Color getForegroundColor()
    {
        return graphic.getColor();
    }

    /**
     * Define a cor do plano de fundo do Canvas
     * @param  newColor  a nova cor para o plano de fundo do Canvas
     */
    public void setBackgroundColor(Color newColor)
    {
        backgroundColor = newColor;   
        graphic.setBackground(newColor);
    }

    /**
     * Retorna a atual cor de fundo do canvas.
     * @return   a cor de fundo do canvas.
     */
    public Color getBackgroundColor()
    {
        return backgroundColor;
    }

    /**
     * Altera a fonte usada no Canvas.
     * @param  newFont   Nova fonte a ser usada na saída de Strings
     */
    public void setFont(Font newFont)
    {
        graphic.setFont(newFont);
    }

    /**
     * Retorna a fonte usada no canvas.
     * @return     a fonte usada no canvas
     **/
    public Font getFont()
    {
        return graphic.getFont();
    }

    /**
     * Defina o tamanho do canvas
     * @param  width    nova largura
     * @param  height   nova altura
     */
    public void setSize(int width, int height)
    {
        canvas.setPreferredSize(new Dimension(width, height));
        Image oldImage = canvasImage;
        canvasImage = canvas.createImage(width, height);
        graphic = (Graphics2D)canvasImage.getGraphics();
        graphic.drawImage(oldImage, 0, 0, null);
        frame.pack();
    }

    /**
     * Retorna o tamanho do canvas.
     * @return     A dimensão atual do canvas.
     */
    public Dimension getSize()
    {
        return canvas.getSize();
    }

    /**
     * Espera por um número especifico de milisegundos antes de terminar.
     * Isto fornece uma maneira fácil para especificar um pequeno delay que pode
     * ser usado na produção de animações.
     * @param  milliseconds  o número
     */
    public void wait(int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        } 
        catch (InterruptedException e)
        {
            // ignoring exception at the moment
        }
    }

    /************************************************************************
     * Classe interna CanvasPane - o verdadeiro componente canvas contido no
     * frame Canvas. Isto é essencialmente um JPanel com capacidades adicionais
     * de atualizar a imagem desenhada nele.
     */
    private class CanvasPane extends JPanel
    {
        public void paint(Graphics g)
        {
            g.drawImage(canvasImage, 0, 0, null);
        }
    }
}
