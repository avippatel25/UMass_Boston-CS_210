import stdlib.StdOut;
import stdlib.StdRandom;
import stdlib.StdStats;

public class PercolationStats {
    //Instance Variables
    //Number of independent experiments
    private int m;
    //Percolation thresold for the m experiments
    private double[] x;

    // Performs m independent experiments on an n x n percolation system.
    public PercolationStats(int n, int m) {
        //Throwing an error if n<=0 or m<=0
        if (n<=0 || m<=0)
        {
            throw new IllegalArgumentException("Illegal n or m");
        }
        //Initialization of all those instance variables
        this.m=m;
        this.x=new double[m];

        // Using for loop for m experiments.
        for (int i = 0; i < m; i++) 
        {
            //Creating a percolation system of n*n
            Percolation percolation = new Percolation(n);
            int openSites = 0;
            //We run loop until system percolates by choosing a random site
            while (!percolation.percolates()) {
                int x = StdRandom.uniform(n);
                int y = StdRandom.uniform(n);
                if (!percolation.isOpen(x, y)) {
                    percolation.open(x, y);
                    openSites++;
                }
            }
            //Storing the thresold of the system in an array of this experiment
            x[i] = (double) openSites / (n * n);
        }
    }

    // Returns sample mean of percolation threshold.
    public double mean() {
        //Using StdStats library we find the mean thresold of the system
        return StdStats.mean(x);
    }

    // Returns sample standard deviation of percolation threshold.
    public double stddev() {
        //Using StdStats library we find the standard deviation thresold of the system
        return StdStats.stddev(x);
    }

    // Returns low endpoint of the 95% confidence interval.
    public double confidenceLow() {
        //Using formula we find the lowest confident thresold of the system
        double low = mean() - (1.96*stddev()/Math.sqrt(m));
        return low;
    }

    // Returns high endpoint of the 95% confidence interval.
    public double confidenceHigh() {
        //Using formula we find the highest confident thresold of the system
        double high = mean() + (1.96*stddev()/Math.sqrt(m));
        return high;
    }

    // Unit tests the data type. [DO NOT EDIT]
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        PercolationStats stats = new PercolationStats(n, m);
        StdOut.printf("Percolation threshold for a %d x %d system:\n", n, n);
        StdOut.printf("  Mean                = %.3f\n", stats.mean());
        StdOut.printf("  Standard deviation  = %.3f\n", stats.stddev());
        StdOut.printf("  Confidence interval = [%.3f, %.3f]\n", stats.confidenceLow(), stats.confidenceHigh());
    }
}
