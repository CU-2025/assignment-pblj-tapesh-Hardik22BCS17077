import java.util.*;

class Card {
    private String suit;
    private String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

class CardCollectionSystem {
    private HashMap<String, HashSet<Card>> cardCollection = new HashMap<>();

    public void addCard(String suit, String rank) {
        cardCollection.putIfAbsent(suit, new HashSet<>());

        Card newCard = new Card(suit, rank);
        if (cardCollection.get(suit).contains(newCard)) {
            System.out.println("Error: Card \"" + newCard + "\" already exists.");
        } else {
            cardCollection.get(suit).add(newCard);
            System.out.println("Card added: " + newCard);
        }
    }

    public void findCardsBySuit(String suit) {
        if (cardCollection.containsKey(suit) && !cardCollection.get(suit).isEmpty()) {
            System.out.println("Cards of Suit \"" + suit + "\": " + cardCollection.get(suit));
        } else {
            System.out.println("No cards found for " + suit + ".");
        }
    }

    public void displayAllCards() {
        if (cardCollection.isEmpty()) {
            System.out.println("No cards found.");
        } else {
            System.out.println("All Cards:");
            for (String suit : cardCollection.keySet()) {
                for (Card card : cardCollection.get(suit)) {
                    System.out.println(card);
                }
            }
        }
    }

    public void removeCard(String suit, String rank) {
        if (cardCollection.containsKey(suit)) {
            Card cardToRemove = new Card(suit, rank);
            if (cardCollection.get(suit).remove(cardToRemove)) {
                System.out.println("Card removed: " + cardToRemove);
            } else {
                System.out.println("Error: Card \"" + cardToRemove + "\" not found.");
            }
        } else {
            System.out.println("Error: Suit \"" + suit + "\" not found.");
        }
    }
}

public class CardCollectionApp {
    public static void main(String[] args) {
        CardCollectionSystem system = new CardCollectionSystem();
        
        system.addCard("Spades", "Ace");
        system.addCard("Hearts", "King");
        system.addCard("Diamonds", "10");
        system.addCard("Clubs", "5");
        
        system.displayAllCards();
        system.findCardsBySuit("Hearts");
        system.findCardsBySuit("Diamonds");
        
        system.removeCard("Diamonds", "10");
        system.displayAllCards();
        
        system.addCard("Hearts", "King");  // Duplicate Test
    }
}
