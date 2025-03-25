import stdlib.StdIn;
import stdlib.StdOut;


public class EditDistance
{
    public static void main(String[] args) 
    {
        //Input of two Strings from command line argument
        String x = StdIn.readString();
        String y = StdIn.readString();
        
        //m and n denotes the length of the String
        int m = GSA.length(x);
        int n = GSA.length(y);

        //Creating an empty array
        int[][] opt = new int[m+1][n+1];

        /* This is one method

        //Deciding Operation and cost
        int gap = 2;
        int mismatch = 1;
        int match = 0;

        //Finding the edit distance in pushing it into the array
        for (int i=m; i >= 0; i--)
        {
            for (int j=n; j >= 0; j--)
            {
                int Right = 100000;
                int Down = 100000;
                int Diagonal = 100000;
                if (i==m && j==n)
                {
                    opt[i][j] = 0;
                }
                else
                {
                    if ((j+1) <= n)
                    {
                        Right = opt[i][j+1] + gap;
                    }
                    if ((i+1) <= m)
                    {
                        Down = opt[i+1][j] + gap;
                    }
                    if ((i+1) <= m && (j+1) <= n)
                    {
                        if (GSA.charAt(x,i) == GSA.charAt(y,j))
                        {
                            Diagonal = opt[i+1][j+1] + match;
                        }
                        else
                        {
                            Diagonal = opt[i+1][j+1] + mismatch;
                        }
                    }
                    opt[i][j] = GSA.min(Right, Down, Diagonal);
                }
            }
        } */

        //This is another method
        //Giving all the penalty to x elements when aligned with -
        for (int i = 0; i <=m; i++)
        {
            opt[i][n]=2*(m-i);
        }
        //Giving all the penalty to y elements when aligned with -
        for (int j = 0; j <=n; j++)
        {
            opt[m][j]=2*(n-j);
        }

        // Filling the rest of the opt from backwards
        for (int i = m-1; i >= 0; i--)
        {
            for (int j = n-1; j >= 0; j--)
            {
                if (GSA.charAt(x,i) == GSA.charAt(y,j)) 
                {
                    opt[i][j] = GSA.min(opt[i+1][j+1], opt[i+1][j] + 2, opt[i][j+1] + 2);
                } 
                else 
                {
                    opt[i][j] = GSA.min(opt[i+1][j+1] + 1, opt[i+1][j] + 2, opt[i][j+1] + 2);
                }
            }
        }
        
        //Output of two strings, lenght of the 2D array and the edit distance array
        StdOut.println(x);
        StdOut.println(y);
        StdOut.println((m+1)+" "+(n+1));
        for (int i=0; i <= m; i++)
        {
            for (int j=0; j <= n; j++)
            {
                if (j < n)
                {
                    StdOut.printf("%3d ",opt[i][j]);
                }
                else
                {
                    StdOut.printf("%3d\n",opt[i][j]);
                }
            }
        }
    }
}