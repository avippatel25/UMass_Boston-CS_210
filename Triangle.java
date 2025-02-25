import stdlib.StdOut;

public class Triangle
{
    // Entry Point.
    public static void main(String[] args)
    {
        // Command line input into integers x, y, z.
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int z = Integer.parseInt(args[2]);
        
        // Boolean expression to check if the sum of any two sides is greater than the third side.
        boolean expr = (x<=y+z) && (y<=x+z) && (z<=y+x);

        // Print the boolean expression.
        StdOut.println(expr);
    }
}
