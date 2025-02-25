import stdlib.StdOut;
import stdlib.StdRandom;

public class Die {
    // Entry point.
    public static void main(String[] args)
    {
        // Generate a random number between 1 and 6.
        int n = StdRandom.uniform(1,7);
        // Print the die face based on the random number.
        if (n == 1)
        {
            StdOut.println("     \n  *  \n     ");
        } 
        else if (n == 2)
        {
            StdOut.println("*    \n     \n    *");
        }
        else if (n == 3)
        {
            StdOut.println("*    \n  *  \n    *");
        } 
        else if (n == 4) 
        {
            StdOut.println("*   *\n     \n*   *");
        } 
        else if (n == 5) 
        {
            StdOut.println("*   *\n  *  \n*   *");
        } 
        else 
        {
            StdOut.println("* * *\n     \n* * *");
        }
    }
}
