import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.*;

/**
 * Canvas é uma classe que permite desenhar gráficos simples na tela.
 * Esta é uma modificação da classe Canvas de propósito geral, especialmente
 * feita para o exemplo "shapes" do BlueJ.
 *
 * @author: Bruce Quig
 * @author: Michael Kolling (mik)
 *
 * @version 2008.03.30
 */
public class Canvas
{
    // Nota: A implementação desta classe (especialmente a manipulação das formas
    // e cores) é um pouco mais complexa que o necessário. Isto é feito
    // propositalmente para manter a interface e os campos dos objetos formas
    // deste projeto limpa e simples por propósitos didáticos.

    private static Canvas canvasSingleton;

    /**
     * Método Factory para pegar o objeto canvas singleton.
     */
    public static Canvas getCanvas()
    {
        if(canvasSingleton == null) {
            canvasSingleton = new Canvas("BlueJ Shapes Demo", 300, 300,
                                         Color.white);
        }
        canvasSingleton.setVisible(true);
        return canvasSingleton;
    }

    //  ----- parte da instância -----

    private JFrame frame;
    private CanvasPane canvas;
    private Graphics2D graphic;
    private Color backgroundColor;
    private Image canvasImage;
    private List<Object> objects;
    private HashMap<Object, ShapeDescription> shapes;

    /**
     * Cria um Canvas.
     * @param title    titulo para aparecer no Frame Canvas
     * @param width    a largura desejada para o Canvas
     * @param height   a altura desejada para o Canvas
     * @param bgColor  a cor desejada para a cor de fundo do canvas
     */
    private Canvas(String title, int width, int height, Color bgColor)
    {
        frame = new JFrame();
        canvas = new CanvasPane();
        frame.setContentPane(canvas);
        frame.setTitle(title);
        canvas.setPreferredSize(new Dimension(width, height));
        backgroundColor = bgColor;
        frame.pack();
        objects = new ArrayList<Object>();
        shapes = new HashMap<Object, ShapeDescription>();
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
            // primeira vez: instancia a imagem fora da tela e a preenche com
            // a cor de fundo.
            Dimension size = canvas.getSize();
            canvasImage = canvas.createImage(size.width, size.height);
            graphic = (Graphics2D)canvasImage.getGraphics();
            graphic.setColor(backgroundColor);
            graphic.fillRect(0, 0, size.width, size.height);
            graphic.setColor(Color.black);
        }
        frame.setVisible(visible);
    }

    /**
     * Desenha uma forma no canvas.
     * @param  referenceObject  um objeto que define a identidade desta forma
     * @param  color            a cor da forma
     * @param  shape            o objeto forma a ser desenhado no canvas
     */
     // Note: esta é uma forma levemente retrógrada para manter os objetos forma.
     // Foi projetado cuidadosamente para manter as interfaces visíveis das
     // formas neste projeto limpa e simples por motivos didáticos.
    public void draw(Object referenceObject, String color, Shape shape)
    {
        objects.remove(referenceObject);   // caso já estivesse lá
        objects.add(referenceObject);      // adiciona no fim
        shapes.put(referenceObject, new ShapeDescription(shape, color));
        redraw();
    }

    /**
     * Apaga uma forma da tela.
     * @param  referenceObject  o objeto forma a ser apagado
     */
    public void erase(Object referenceObject)
    {
        objects.remove(referenceObject);   // caso já estivesse lá
        shapes.remove(referenceObject);
        redraw();
    }

    /**
     * Define a cor do plano de frente do Canvas
     * @param  newColor  a nova cor para o plano de frente do Canvas
     */
    public void setForegroundColor(String colorString)
    {
        if(colorString.equals("red")) {
            graphic.setColor(Color.red);
        }
        else if(colorString.equals("black")) {
            graphic.setColor(Color.black);
        }
        else if(colorString.equals("blue")) {
            graphic.setColor(Color.blue);
        }
        else if(colorString.equals("yellow")) {
            graphic.setColor(Color.yellow);
        }
        else if(colorString.equals("green")) {
            graphic.setColor(Color.green);
        }
        else if(colorString.equals("magenta")) {
            graphic.setColor(Color.magenta);
        }
        else if(colorString.equals("white")) {
            graphic.setColor(Color.white);
        }
        else {
            graphic.setColor(Color.black);
        }
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
        catch (Exception e)
        {
            // ignorando a exceção
        }
    }

    /**
     * Redesenha todas as formas presentes no Canvas
     */
    private void redraw()
    {
        erase();
        for(Object shape : objects) {
            shapes.get(shape).draw(graphic);
        }
        canvas.repaint();
    }

    /**
     * Apaga todo o canvas. (não repinta.)
     */
    private void erase()
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        Dimension size = canvas.getSize();
        graphic.fill(new Rectangle(0, 0, size.width, size.height));
        graphic.setColor(original);
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

    /************************************************************************
    * Classe interna CanvasPane - o verdadeiro componente canvas contido no
    * frame Canvas. Isto é essencialmente um JPanel com capacidades adicionais
    * de atualizar a imagem desenhada nele.
     */
    private class ShapeDescription
    {
        private Shape shape;
        private String colorString;

        public ShapeDescription(Shape shape, String color)
        {
            this.shape = shape;
            colorString = color;
        }

        public void draw(Graphics2D graphic)
        {
            setForegroundColor(colorString);
            graphic.fill(shape);
        }
    }

}
