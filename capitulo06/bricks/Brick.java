/**
 * Brick modela um simples tijolo.
 * 
 * @author: Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Brick
{
    // Constante.
    private static final int WEIGHT_PER_CM3 = 2;  // Peso medido em gramas por centimetro cúbico

    private int height;
    private int width;
    private int depth;

    /**
     * Cria um Brick dado as dimensões laterais em centímetros.
     * @param height A altura do tijolo
     * @param width A largura do tijolo
     * @param depth A profundidade do tijolo
     */
    public Brick(int height, int width, int depth)
    {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    /**
     * @return A área da superfície deste tijolo em centimetros quadrados.
     */
    public double getSurfaceArea()
    {
        double side1 = width * height;
        double side2 = width * depth;
        double side3 = depth * height;
        //double total = (side1 + side1 + side3) * 2;
        double total = (side1 + side2 + side3) * 2;

        return total;
    }

    /**
     * @return O peso deste tijolo em kg.
     */
    public double getWeight()
    {
        return (getVolume() * WEIGHT_PER_CM3) / 1000;
    }

    /**
     * @return O volume deste tijolo em centímetros cúbicos.
     */
    public int getVolume()
    {
        return width * height * depth;
    }

    /**
     * @return A altura deste tijolo em centímetros.
     */
    public double getHeight()
    {
        return height;
    }
}
