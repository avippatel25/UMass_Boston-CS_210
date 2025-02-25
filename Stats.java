import stdlib.StdOut;
import stdlib.StdRandom;

public class Stats
{
    // Entry Point.
    public static void main(String[] args)
    {
        // Command line input into integers a and b.
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        // Generate 3 double random numbers between a and b.
        double x1 = StdRandom.uniform((double)a,(double)b);
        double x2 = StdRandom.uniform((double)a,(double)b);
        double x3 = StdRandom.uniform((double)a,(double)b);

        // Calculate mean, variance and standard deviation.
        double mean = (x1+x2+x3)/3;
        double var = (Math.pow((x1-mean),2) + Math.pow((x2-mean),2) + Math.pow((x3-mean),2))/3;
        double std_dev = Math.sqrt(var);

        // Print the mean, variance and standard deviation.
        StdOut.println(mean + " " + var + " " + std_dev);
    }
}