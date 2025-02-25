import stdlib.StdOut;

public class Factorial {
    // Entry point.
    public static void main(String[] args)
    {
        // Command line input into the Integer n.
        int n = Integer.parseInt(args[0]);

        // Using for loop and long result to calculate the factorial of n.
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        // Print the result.
        StdOut.println(result);
    }
}
