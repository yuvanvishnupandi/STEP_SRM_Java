import java.util.Arrays;

public class deckofcards {

    public static String[] initDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] deck = new String[suits.length * ranks.length];
        int index = 0;
        for (String suit : suits) for (String rank : ranks) deck[index++] = rank + " of " + suit;
        return deck;
    }

    public static void shuffleDeck(String[] deck) {
        for (int i = 0; i < deck.length; i++) {
            int randomCard = i + (int)(Math.random() * (deck.length - i));
            String temp = deck[i];
            deck[i] = deck[randomCard];
            deck[randomCard] = temp;
        }
    }

    public static String[][] distributeCards(String[] deck, int players, int cardsPerPlayer) {
        if (players * cardsPerPlayer > deck.length) return null;
        String[][] result = new String[players][cardsPerPlayer];
        int index = 0;
        for (int i = 0; i < players; i++) for (int j = 0; j < cardsPerPlayer; j++) result[i][j] = deck[index++];
        return result;
    }

    public static void printPlayersCards(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + ": " + Arrays.toString(players[i]));
        }
    }

    public static void main(String[] args) {
        String[] deck = initDeck();
        shuffleDeck(deck);
        int players = 4; // Example: 4 players
        int cardsPerPlayer = 5; // Example: 5 cards per player
        String[][] playersCards = distributeCards(deck, players, cardsPerPlayer);
        if (playersCards != null) {
            printPlayersCards(playersCards);
        } else {
            System.out.println("Not enough cards to distribute.");
        }
    }
}