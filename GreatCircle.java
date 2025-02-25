import stdlib.StdOut;

public class GreatCircle
{
    // Entry Point.
    public static void main(String[] args)
    {
        // Command line input into double variable x1, y1, x2, y2.
        double x1 = Double.parseDouble(args[0]);
        double y1 = Double.parseDouble(args[1]);
        double x2 = Double.parseDouble(args[2]);
        double y2 = Double.parseDouble(args[3]);

        // Great Circle Distance formula.
        double d = 6359.83 * Math.acos(Math.sin(Math.toRadians(x1)) * Math.sin(Math.toRadians(x2)) + Math.cos(Math.toRadians(x1)) * Math.cos(Math.toRadians(x2)) * Math.cos(Math.toRadians(y1 - y2)));

        // Print the distance.
        StdOut.println(d);
    }
}