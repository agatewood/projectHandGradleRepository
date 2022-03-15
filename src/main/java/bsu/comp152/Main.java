package bsu.comp152;

/**
 *
 * Main - A class for testing the Hand class
 *
 * Starter code by Laura K. Gross, COMP 152, Bridgewater State University
 *
 * Completed by: [Avery Gatewood], [agatewood@student.bridgew.edu]
 *         date: [3/17/2022]
 *
 * You may modify this code for testing purposes.  I will not grade it.
 */
public class Main {

    public static void main(String[] args) {

        // Test the Card class.

        // Create a Card object with reference variable c1.
        Card c1 = new Card(2, Card.DIAMONDS);
        // Create a Card object with reference variable c2.
        Card c2 = new Card(Card.ACE, Card.DIAMONDS);
        Card c3 = new Card(Card.KING, Card.SPADES);
        Card c4 = new Card(10, Card.CLUBS);
        Card c5 = new Card(10, Card.HEARTS);
        Card c6 = new Card(10, Card.DIAMONDS);

        Hand h1 = new Hand(4);
        h1.addCard(c1);
        h1.addCard(c2);
        h1.addCard(c6);
        System.out.println(h1.getNumCards());
        h1.addCard(c4);
        System.out.println(h1.toString());
        //System.out.println(h1.getTotalValue());
        System.out.println(h1.playCard(2));
        //System.out.println(h1.toString());
        System.out.println(h1.highCard());
        System.out.println(h1.numCardsOfRank(6));
        System.out.println(h1.hasFlush());





//        System.out.println(h1.getTotalValue());
//        System.out.println(h1.getNumCards());
//        System.out.println(Card.ACE);
//        System.out.println(c1.getRank());
//        System.out.println(c1.getSuit());
//        System.out.println(c1.getValue());
//        System.out.println();
//        System.out.println(c1);
//        System.out.println(c1.getAbbrev());
//        System.out.println(c2);
//        System.out.println(c2.getAbbrev());
//        System.out.println(c3);
//        System.out.println(c3.getAbbrev());
    }
}
