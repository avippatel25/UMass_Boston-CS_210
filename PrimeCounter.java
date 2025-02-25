import stdlib.StdOut;

public class PrimeCounter {
    // Entry point.
    public static void main(String[] args)
    {
        // Command line input into integer n.
        int n = Integer.parseInt(args[0]);
        
        // Using for loop to iterate through numbers from 2 to n.
        // Using count to keep track of prime numbers.
        int count = 0;
        for (int i = 2; i <= n; i++)
        {
            int j = 2;
            // Using while loop to check if i is prime.
            while (j <= (i/j))
            {
                if (i % j == 0)
                {
                    break;
                }
                j++;
            }
            // If j is greater than i/j, then i is prime.
            if (j > (i/j))
            {
                count++;
            }
        }
        // Print the count of prime numbers.
        StdOut.println(count);
    }
}
