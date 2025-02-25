import stdlib.StdOut;

public class GCD {
    // Entry point.
    public static void main(String[] args)
    {
        // Command line input into Integers p and q .
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);

        // Using while loop to find the greatest common divisor of p and q.
        while (p%q!=0)
        {
            // swapping the values of p and q.
            int temp = p;
            p = q;
            q = temp%q;
        }
        // Printing the greatest common divisor of p and q.
        StdOut.println(q);
    }
}
