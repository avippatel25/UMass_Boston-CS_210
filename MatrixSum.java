import stdlib.StdArrayIO;
import stdlib.StdOut;

public class MatrixSum {
    // Returns the sum of the elements in a.
    private static int sum(int[][] a) {
        int add=0;
        int row=a.length;
        int col=a[0].length;
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                add+=a[i][j];
            }
        }
        return add;
    }

    // Entry point.
    public static void main(String[] args) {
        StdOut.println(sum(StdArrayIO.readInt2D()));
    }
}
