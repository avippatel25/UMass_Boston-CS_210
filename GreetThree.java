import stdlib.StdOut;

public class GreetThree
{
    // Entry Point.
    public static void main(String[] args)
    {
        // Comman line input into String variables name1, name2, and name3.
        String name1 = args[0];
        String name2 = args[1];
        String name3 = args[2];

        // Storing the message in a String variable message.
        String message = "Hi "+name3+", "+name2+", and "+name1+".";

        // Printing the message.
        StdOut.println(message);
    }
}
