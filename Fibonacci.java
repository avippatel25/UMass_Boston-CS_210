import stdlib.StdOut;

public class Fibonacci {
    // Entry point.
    public static void main(String[] args)
    {
        // Command line input into the Integer n.
        int n = Integer.parseInt(args[0]);
        
        // Using the while loop, long a and b and Integer i to calculate the Fibonacci number. 
        long a = -1;
        long b = 1;
        int i = 0;
        while (i<=n)
        {
            // Swaping a with b and b with a+b.
            long temp = a+b;
            a = b;
            b = temp;
            i++;
        }
        // Printing the Fibonacci number.
        StdOut.println(b);
    }
}
