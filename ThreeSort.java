import stdlib.StdOut;

public class ThreeSort
{
    // Entry Point.
    public static void main(String[] args)
    {
        // Command line input into integers x, y, z.
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int z = Integer.parseInt(args[2]);

        // Find the minimum, maximum, and middle values.
        int alpha = Math.min(Math.min(x, y),z);
        int omega = Math.max(Math.max(x, y),z);
        int middle = (x + y + z) - alpha - omega;

        // Print the values in ascending order.
        StdOut.println(alpha+ " " +middle+" " +omega);
    }
}