/**
 * Esta classe representa uma simples imagem. Você pode desenhar a imagem usando
 * o método draw. Mas espere, tem mais: por ser uma imagem eletrônica, ela pode
 * ser modificada. Você pode altera-la para preto e branco ou colorida (apenas
 * após ela já ter sido desenhada é claro)
 *
 * Esta classe foi escrita como um exemplo para o ensino de Java com BlueJ.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Picture
{
    private Square wall;
    private Square window;
    private Triangle roof;
    private Circle sun;

    /**
     * Construtor de objetos para a classe Picture
     */
    public Picture()
    {
        /* nada para fazer... variáveis de instancias são automaticamente
         * inicializadas com null.
         */
    }

    /**
     * Desenha esta imagem.
     */
    public void draw()
    {
        wall = new Square();
        wall.moveVertical(80);
        wall.changeSize(100);
        wall.makeVisible();

        window = new Square();
        window.changeColor("black");
        window.moveHorizontal(20);
        window.moveVertical(100);
        window.makeVisible();

        roof = new Triangle();
        roof.changeSize(50, 140);
        roof.moveHorizontal(60);
        roof.moveVertical(70);
        roof.makeVisible();

        sun = new Circle();
        sun.changeColor("yellow");
        sun.moveHorizontal(180);
        sun.moveVertical(-10);
        sun.changeSize(60);
        sun.makeVisible();
    }

    /**
     * Altera esta imagem para usar apenas preto e branco
     */
    public void setBlackAndWhite()
    {
        if(wall != null)   // apenas se já tiver sido desenhada...
        {
            wall.changeColor("black");
            window.changeColor("white");
            roof.changeColor("black");
            sun.changeColor("black");
        }
    }

    /**
     * Altera esta imagem para usar cores
     */
    public void setColor()
    {
        if(wall != null)   // apenas se já tiver sido desenhada...
        {
            wall.changeColor("red");
            window.changeColor("black");
            roof.changeColor("green");
            sun.changeColor("yellow");
        }
    }
}
