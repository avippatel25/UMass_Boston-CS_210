import stdlib.StdArrayIO;
import stdlib.StdIn;
import stdlib.StdOut;

public class Alignment
{
    public static void main(String[] args)
    {
        //Input of two Strings from command line argument
        String x = StdIn.readString();
        String y = StdIn.readString();
        
        //m and n denotes the length of the String
        int m = GSA.length(x);
        int n = GSA.length(y);

        //Creating an array with the standard input
        int[][] opt = StdArrayIO.readInt2D();

        //Output of the edit distance
        StdOut.println(opt[0][0]);

        // Set value of two integeres as zero
        int i = 0;
        int j = 0;

        // Using while loop we recover and output the alingment
        while (i <= (m-1) && j <= (n-1))
        {
            // Giving a penalty of gap if alinged with - 
            if (opt[i][j]==opt[i+1][j]+2)
            {
                char x_char=GSA.charAt(x,i);
                StdOut.printf("%s - 2\n",x_char);
                i++;
            }
            // Giving a penalty of gap if aligned with -
            else if (opt[i][j]==opt[i][j+1]+2)
            {
                char y_char=GSA.charAt(y,j);
                StdOut.printf("- %s 2\n",y_char);
                j++;
            }
            // Giving either 1 or 0 as penalty if both character matches or not
            else 
            {
                StdOut.print(GSA.charAt(x, i)+" ");
                StdOut.print(GSA.charAt(y, j)+" ");
                if (GSA.charAt(y, j)==GSA.charAt(x, i))
                {
                    StdOut.println("0");
                }
                else
                {
                    StdOut.println("1");
                }
                i++;
                j++;
            }
        }

        //If y is finished and there are still elements of x then we give gap and penalty
        if (j == n && i < m)
        {
            while (i <= (m-1))
            {
                char x_char=GSA.charAt(x,i);
                StdOut.printf("%s - 2\n",x_char);
                i++;
            }
        }
        //If x is finished and there are still elements of y then we give gap and penalty
        else if (i == m && j < n)
        {
            while (j <= (n-1))
            {
                char y_char=GSA.charAt(y,j);
                StdOut.printf("- %s 2\n",y_char);
                j++;
            }
        }
    }
}
