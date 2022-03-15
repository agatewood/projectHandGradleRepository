package bsu.comp152;

/** Hand - A class to create Hand objects and get to know them

  Starter code from Computer Science 111, Boston University

  Modified by Laura K. Gross, COMP 152, Bridgewater State University

  Completed by: [Avery Gatewood], [agatewood@student.bridgew.edu]
          date: [3/17/2022]
 */
public class Hand {
    /* Constants for types of hands
     * The numbers used for the hand types increase
     * with the value of the hand type.
     * For example, four-of-a-kind is the highest-valued
     * hand type that we support, and it has the highest
     * numeric value.
     */
    private static final int HIGH_CARD = 0;
    private static final int PAIR = 1;
    private static final int TWO_PAIRS = 2;
    private static final int THREE_OF_A_KIND = 3;
    private static final int FLUSH = 4;
    private static final int FOUR_OF_A_KIND = 5;

    // The instance fields for a Hand object
    // The Card objects in the Hand object are stored in array called cards.
    // Declare the array of Card objects.
    private Card[] cards;
    // The number of cards in the hand is called numCards.
    // Declare it as an integer.
    private int numCards;

    // Constructor Hand that takes int maxCards as a param for the amount of potential cards to place in Hand.
    public Hand(int maxCards){
        // Initialization of numCards private field to zero.
        this.numCards = 0;
        // Creating the Card array with the specified amount of Card objects it can hold (maxCards).
        this.cards = new Card[maxCards];
    }

    // Method that returns the current number of cards in the hand.
    public int getNumCards() {
        return numCards;
    }

    // Adding card to array method.
    // This addCard method takes Card objects "c" as a param.
    public void addCard(Card c){
        // If statement that if the card is null then throw exception.
        if (c == null) {
            throw new IllegalArgumentException();
        }
        // If statement that if the number of cards in the hand is equal to length of cards
        // array then place illegal state exception.
        if (numCards == cards.length) {
            throw new IllegalStateException();
        }
        // Then for each index of cards array we replace it with a card object.
        // Enumerate numCards so that we have a counting list of the number of cards.
        cards[numCards] = c;
        numCards++;

    }

    // toString method that will visualize the abbrev form of cards in a neat manner.
    public String toString() {
        // Created an initialized string s set the open bracket.
        String s = "[";

        // If statement that returns empty array if the Cards array is empty.
        if (numCards == 0) {
            s += "]";
        }

        // If the number of cards is greater than zero than the for-loop is entered.
        if (numCards > 0) {

            // Indexing through each element in the array except for the last.
            for (int i = 0; i < numCards - 1; i++) {
                // If the element is not equal to null (spot where not Card object has been entered)
                // then the string "s" gets concatenated with the card abbreviated plus a comma.
                if (cards[i] != null) {
                    s += cards[i].getAbbrev() + ", ";
                }
            }
            // One more addition because the last card needs to be printed with different
            // syntax so the final card is concatenated to string "s".
            s += cards[numCards - 1].getAbbrev() + "]";
        }
        return s;
    }

    // Getter that takes the specific index of the array containing Card objects and returns the specific card
    // at that position.
    public Card getCard(int i) {

        // If the user inputs a number that has an empty index in the array or if the user inputs a number greater than
        // the number of cards and or less than the minimum number of cards zero, throw new IllegalArgumentException.
        if (i > numCards || i < 0 )
            throw new IllegalArgumentException();
        if (cards[i] == null)
            throw new IllegalArgumentException();

        // Returns the card at the specified position in the array.
        return cards[i];
    }

    // playCard method that will "play" a card object and returns the card object.
    public Card playCard(int i) throws IllegalArgumentException {

        // If the user inputs a number that has an empty index in the array or if the user inputs a number greater than
        // the number of cards and or less than the minimum number of cards zero, throw new IllegalArgumentException.
        if (i > numCards || i < 0 )
            throw new IllegalArgumentException();
        if (cards[i] == null)
            throw new IllegalArgumentException();

        // Intermediate var that stores the Card object in playedCard at index indicated by the user.
        Card playedCard = cards[i];

        // For each element in the cards array after the position indicated by the user
        // Set the index equal to null to remove the Card object from Hand array.
        // This also prevents multiple copies of the end Card and shortens the array.
            for (int x = i; x < cards.length; x++) {
                if (x < cards.length - 1){
                    cards[x] = cards[x + 1];
                }
                else {
                    cards[x] = null;
                }
            }
            // Reduce the number of cards by one for each card object played if card is valid.
            numCards--;
        // Returns the Card that the user "played".
        return playedCard;
    }

    // Still need to implement a way to choose the nearest to the left card if multiple cards have same value!!!!!?
    // highCard method that returns a card object with the greatest value from the array cards.
    public Card highCard() {

        // Initialize two variable temp and tempHighCard to int.
        // Set tempHighCard to -1 as this is less than the lowest possible value for card objects.
        int temp;
        int tempHighCard = -1;

        // If the number of cards is less than or equal to zero there cannot be a highCard, throws exception.
        if (numCards <= 0) {
            throw new IllegalStateException();
        }

        // Setting the returned overall highCard from the array to currently be equal to null.
        Card highCard = null;

        // For loop that sets the first card object value equal to temp.
        // Then, if the card object value is greater than the tempHighCard value, the tempHighCard gets reassigned to
        // the temp card value.
        for (int i = 0; i < numCards; i++) {
            temp = cards[i].getValue();
            if (temp > tempHighCard) {
                tempHighCard = temp;
            }

            // For each element again check the card value and if it equals the remaining tempHighCard value
            // the highCard that is returned it equal to the card object at the specific index of tempHighCard.
            // This is so that a Card object is returned and not an int which is used for checking values.
            for (int x = 0; x < numCards; x++) {
                if (cards[x].getValue() == tempHighCard) {
                    highCard = cards[x];
                }
            }
        }
        return highCard;
    }

    // Boolean hasFlush method that returns false if the Card objects suit values in the array are not all the same
    // or true if the Card objects are all the same suit.
    public boolean hasFlush() {

      // If the number of cards is less than or equal the hasFlush cannot be computed as no cards are available.
      if (numCards <= 0)
          throw new IllegalArgumentException();

      // temp variable set to the first Card object suit value in the cards array.
      int temp = cards[0].getSuit();

      // For loop that for each element in the array it is checked if the suit value is the same as temp.
      // If the suit value is not the same return false, otherwise return true.
      for (int i = 0; i < numCards; i++){
          if (temp != cards[i].getSuit()){
                return false;
          }
      }
        return true;
    }

    // numCardsOfRank method which takes int param rk to check how many cards in the array have that rank value.
    public int numCardsOfRank(int rk) {

        // numberCards is initialized to int type and value zero.
        int numberCards = 0;

        // For loop that if the rank specified is equal to the rank of each card object then add one to numberCards.
        for (int i = 0; i < numCards; i++){
            if (cards[i].getRank() == rk) {
                numberCards++;
            }
        }

        // Returns the number of cards that have the rank the user entered.
        return numberCards;
    }

    /*
    getTotalValue computes and returns the sum of the values of the cards
    in the cards array
    If Hand is currently empty method returns 0.
     */

    public int getTotalValue(){
        int value = 0;

        // Calculating the running value by adding each card value in the hand.
        for (int i = 0; i < numCards; i++)
            // for each element in cards array we apply the getValue method.
            // The corresponding value is then added to value.
            // The value var is reassigned to value + that index value.
            value += cards[i].getValue();
        return value;
    }
}

