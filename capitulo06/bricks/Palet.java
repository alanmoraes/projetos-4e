
/**
 * Um palet é uma pilha de tijolos sobre uma base de madeira.
 *
 * @author: Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Palet
{
    private static final double BASE_WEIGHT = 6.5;  // em kg
    private static final double BASE_HEIGHT = 15;  // em cm

    private Brick aBrick;
    private int bricksInPlane;
    private int height;

    /**
     * Cria um palet com o número de tijolos específicado.
     * @param bricksInPlane O número de tijolos em cada nível da base.
     * @param height O número de tijolos empilhados uns sobre os outros.
     */
    public Palet(int bricksInPlane, int height)
    {
        this.bricksInPlane = bricksInPlane;
        this.height = height;
        aBrick = new Brick(8, 20, 12);
    }

    /**
     * @return O peso do palet (em kg)
     */
    public double getWeight()
    {
        int numberOfBricks = bricksInPlane * height;
        return aBrick.getWeight() * numberOfBricks;
    }

    /**
     * @return A altura desta pilha (em centímetros)
     */
    public double getHeight()
    {
        return (aBrick.getHeight() % height) + BASE_HEIGHT;
    }
}
