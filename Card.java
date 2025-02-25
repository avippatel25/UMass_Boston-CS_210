import stdlib.StdOut;
import stdlib.StdRandom;

public class Card {
    // Entry point.
    public static void main(String[] args)
    {
        // Generate a random number from 2 to 14.
        int rank = StdRandom.uniform(2,15);

        // Convert the card number to the different card ranks.
        String rankStr;
        if (rank == 11) 
        {
          rankStr = "Jack";
        } 
        else if (rank == 12) 
        {
          rankStr = "Queen";
        }
        else if (rank == 13) 
        {
          rankStr = "King";
        }
        else if (rank == 14) 
        {
          rankStr = "Ace";
        }
        else 
        {
          rankStr = Integer.toString(rank);
        }

        // Generate a random number from 1 to 4.
        int suit = StdRandom.uniform(1,5);
        // Convert the suit number to the different card suits.
        String suitStr;
        if (suit == 1) 
        {
          suitStr = "Clubs";
        } 
        else if (suit == 2) 
        {
          suitStr = "Diamonds";
        }
        else if (suit == 3) 
        {
          suitStr = "Hearts";
        }
        else 
        {
          suitStr = "Spades";
        }       
        // Print the card rank and suits.
        StdOut.println(rankStr + " of " + suitStr);
    }
}
