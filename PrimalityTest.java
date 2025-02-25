import stdlib.StdOut;

public class PrimalityTest {
    // Entry point.
    public static void main(String[] args)
    {
        // Command line input into the Integer n.
        int n = Integer.parseInt(args[0]);

        // Using while loop and integer i to check if n is prime.
        int i = 2;
        while (i<=(n/i))
        {
            if (n%i == 0)
            {
                break;
            }
            i++;
        }
        // If i is greater than the n/i then n is prime.
        if (i>(n/i))
        {
            // Print true if n is prime.
            StdOut.println("true");
        }
        else
        {
            // Print false if n is not prime.
            StdOut.println("false");
        }
    }
}
