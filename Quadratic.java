import stdlib.StdOut;

public class Quadratic
{
    public static void main(String[] args)
    {
        // Command line input into doubles a, b, and c.
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);

        // If variable of x^2 is 0, then the equation is not quadratic.
        if (a==0.0)
        {
            StdOut.println("Value of a must not be 0");
            return;
        }
        // Calculate the discriminant.
        double discriminant = b * b - 4.0 * a * c;

        // If the discriminant is negative, then the roots are imaginary.
        if (discriminant < 0.0)
        {
            StdOut.println("Value of discriminant must not be negative");
            return;
        }
        // Calculate the roots.
        double d = Math.sqrt(discriminant);
        double root1 = (-b + d) / (2.0 * a);
        double root2 = (-b - d) / (2.0 * a);

        // Print the roots.
        StdOut.println(root1 + " " + root2);
    }
}
