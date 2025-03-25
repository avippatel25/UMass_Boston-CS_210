import dsa.WeightedQuickUnionUF;
import stdlib.In;
import stdlib.StdOut;

public class Percolation {
    //Creation of instance variables.
    //Percolation system size
    private int n;
    //Percolation system
    private boolean[][] open;
    //Number of open sites
    private int openSites;
    //Union-Find representation of the percolation system
    private WeightedQuickUnionUF uf;
    //Source, Sink and Union-Find Backwash
    private int source;
    private int sink;
    private WeightedQuickUnionUF ufBackWash;

    // Constructs an n x n percolation system, with all sites blocked.
    public Percolation(int n) {
        // Throwing an error for n<=0
        if (n<=0) 
        {
            throw new IllegalArgumentException("Illegal n");
        }
        //Initialization of all those instance variables
        this.n=n;
        this.open=new boolean[n][n];
        this.openSites=0;
        this.uf=new WeightedQuickUnionUF((n*n)+2);
        this.source=0;
        this.sink=(n*n)+1;
        this.ufBackWash=new WeightedQuickUnionUF((n*n)+2);
    }

    // Opens site (i, j) if it is not already open.
    public void open(int i, int j) {
        //Throwing an error if i,j are outside of [0,n-1]
        if (i<0 || i>(n-1) || j<0 || j>(n-1))
        {
            throw new IndexOutOfBoundsException("Illegal i or j");
        }
        //Opens the site if its not.
        if (!isOpen(i, j))
        {
            open[i][j]=true;
            openSites+=1;
            //Connect the site with source
            if (i==0)
            {
                uf.union(encode(i, j),source);
                ufBackWash.union(encode(i, j),source);
            }
            //Connect the site with sink
            if (i==n-1)
            {
                uf.union(encode(i, j),sink);
            }
            //Checking If the neighbor sites are open 
            //North Site
            if (i>0 && isOpen(i - 1, j)) 
            {
                uf.union(encode(i, j), encode(i-1, j));
                ufBackWash.union(encode(i, j),encode(i-1, j));
            }
            //East site
            if (j<n-1 && isOpen(i, j+1)) 
            {
                uf.union(encode(i, j), encode(i, j+1));
                ufBackWash.union(encode(i, j),encode(i, j+1));
            }
            //West site
            if (j>0 && isOpen(i, j-1)) 
            {
                uf.union(encode(i, j), encode(i, j-1));
                ufBackWash.union(encode(i, j),encode(i, j-1));
            }
            //South site
            if (i<n-1 && isOpen(i+1, j)) 
            {
                uf.union(encode(i, j), encode(i+1, j));
                ufBackWash.union(encode(i, j),encode(i+1, j));
            }
        }
    }

    // Returns true if site (i, j) is open, and false otherwise.
    public boolean isOpen(int i, int j) {
        //Throwing an error if i,j are outside of [0,n-1]
        if (i<0 || i>(n-1) || j<0 || j>(n-1))
        {
            throw new IndexOutOfBoundsException("Illegal i or j");
        }
        //Returns if the site is open as true
        return open[i][j];
    }

    // Returns true if site (i, j) is full, and false otherwise.
    public boolean isFull(int i, int j) {
        //Throwing an error if i,j are outside of [0,n-1]
        if (i<0 || i>(n-1) || j<0 || j>(n-1))
        {
            throw new IndexOutOfBoundsException("Illegal i or j");
        }
        // return if site is full as true and use backwash for all unconnected open sites
        return isOpen(i, j) && ufBackWash.connected(encode(i,j),source);
    }

    // Returns the number of open sites.
    public int numberOfOpenSites() {
        //Returns no of open sites
        return openSites;
    }

    // Returns true if this system percolates, and false otherwise.
    public boolean percolates() {
        //If system percolates it returns true
        return uf.connected(source,sink);
    }

    // Returns an integer ID (1...n) for site (i, j).
    private int encode(int i, int j) {
        //encode the index of site as 1,2,3...9 and 0 for source and 10 for sink.
        int sites = (n*i)+1+j;
        return sites;
    }

    // Unit tests the data type. [DO NOT EDIT]
    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        int n = in.readInt();
        Percolation perc = new Percolation(n);
        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        StdOut.printf("%d x %d system:\n", n, n);
        StdOut.printf("  Open sites = %d\n", perc.numberOfOpenSites());
        StdOut.printf("  Percolates = %b\n", perc.percolates());
        if (args.length == 3) {
            int i = Integer.parseInt(args[1]);
            int j = Integer.parseInt(args[2]);
            StdOut.printf("  isFull(%d, %d) = %b\n", i, j, perc.isFull(i, j));
        }
    }
}