import stdlib.StdOut;

public class PerfectNumbers {
    // Entry point.
    public static void main(String[] args)
    {
        // Command line input into the Integer n.
        int n = Integer.parseInt(args[0]);

        // Using a for loop to iterate through the numbers from 2 to n.
        for (int i = 2; i <= n; i++)
        {
            // Initializing the total variable to 0.
            int total = 0;
            // Using a for loop to iterate through the numbers from 1 to i/2.
            for (int j = 1; j <= (i/2); j++)
            {
                // If the remainder of i divided by j is 0, then add j to the total.
                if (i % j == 0)
                {
                    total += j;
                }
            }
            // If the total is equal to i, then print i.
            if (total == i)
            {
                StdOut.println(i);
            }
        }
    }
}
