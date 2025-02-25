import stdlib.StdOut;

public class RamanujanNumbers {
    // Entry point.
    public static void main(String[] args)
    {
        // Command line input into integer n. 
        int n = Integer.parseInt(args[0]);

        int a = 1;
        // Loop through all possible combinations of a and b.
        while (a*a*a <= n)
        {
            int b = a+1;
            while (a*a*a + b*b*b <= n)
            {
                int c = a+1;
                // Loop through all possible combinations of c and d.
                while (c*c*c <= n)
                {
                    int d = c+1;
                    while(c*c*c + d*d*d <= n)
                    {
                        // Check if the sum of the cubes of a and b is equal to the sum of the cubes of c and d.
                        int x = a*a*a + b*b*b;
                        int y = c*c*c + d*d*d;
                        // If the sums are equal, print the result.
                        if (x == y)
                        {
                            StdOut.println(x + " = " + a + "^3 + " + b + "^3 = " + c + "^3 + " + d + "^3");
                        }
                        d++;
                    }
                    c++;
                }
                b++;
            }
            a++;
        }
    }
}
