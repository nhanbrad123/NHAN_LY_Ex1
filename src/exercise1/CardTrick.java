package exercise1;

/**
 * A class that fills a hand of 7 cards with random Card Objects and then asks the user to pick a card. It then searches
 * the array of cards for the match to the user's card. To be used as starting code in Exercise
 *
 * @author dancye
 * @author Paul Bonenfant Jan 25, 2022
 */
import java.util.Random;
import java.util.Scanner;

public class CardTrick {

    public static void main(String[] args) {

        Card[] hand = new Card[7];
        boolean cond = false;

        for (int i = 0; i < hand.length; i++) {
            Card card = new Card();
            //card.setValue(insert call to random number generator here)
            // 
            Random rand = new Random();
            int v = rand.nextInt(12);
            card.setValue(v);
            
            //card.setSuit(Card.SUITS[insert call to random number between 0-3 here])
            // Hint: You can use Random -> random.nextInt(n) to get a random number between 0 and n-1 (inclusive)
            //       Don't worry about duplicates at this point
            int s = rand.nextInt(4);
            card.setSuit(Card.SUITS[s]);
            hand[i] = card;
        }

        // insert code to ask the user for Card value and suit, create their card
        // and search the hand here. 
        // Hint: You can ask for values 1 to 10, and then
        //       11 for jack, 12 for queen, etc. (remember arrays are 0-based though)
        //       1 for Hearts, 2 for Diamonds, etc. (remember arrays are 0-based though)
        // 
        // Then loop through the cards in the array to see if there's a match.
        // If the guess is successful, invoke the printInfo() method below.
        Scanner input = new Scanner(System.in);
        int value, suit;
        System.out.print("Guess the card Value(10 to 12): ");
        value = input.nextInt();
        while (value<1||value>12)
        {
            System.out.print("Wrong input, Guess the card Value(10 to 12): ");
            value = input.nextInt();
        }
        System.out.print("Guess the card Suit(1 to 4: Heart, Diamond, Spades, Clubs): ");
        suit = input.nextInt();
        while (suit<1||suit>4)
        {
            System.out.print("Wrong input, Guess the card Suit(1 to 4: Heart, Diamond, Spades, Clubs): ");
            suit = input.nextInt();
        }
        for (int i=0; i<hand.length;i++)
        {
            if (value==hand[i].getValue()&&Card.SUITS[suit].equals(hand[i].getSuit()))
            {
                cond = true;
                printInfo();
            }
            else 
            {
                cond = false;
                System.out.printf("The card %d has the value of %d and the suit of %s\n",i,hand[i].getValue(),hand[i].getSuit());
            }
        }
        if (cond==false)
        {
            System.out.println("You got it wrong!");
        }
    }

    /**
     * A simple method to print out personal information. Follow the instructions to replace this information with your
     * own.
     *
     * @author Paul Bonenfant Jan 2022
     */
    private static void printInfo() {

        System.out.println("Congratulations, you guessed right!");
        System.out.println();

        System.out.println("My name is Nhan, but you can call me Lee");
        System.out.println();

        System.out.println("My career ambitions: Software Developer");
        System.out.println("-- Be more active on LinkedIn");
        System.out.println("-- Make more connection in college and LinkedIn");
        System.out.println("-- Have a semester with no violations of academic integrity!");
        System.out.println();

        System.out.println("My hobbies:");
        System.out.println("-- Coding");
        System.out.println("-- Gaming");
        System.out.println("-- Reading Novels");
        System.out.println("-- Listening to music");

        System.out.println();

    }

}
