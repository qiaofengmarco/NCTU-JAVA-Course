import java.util.*;
public class Pro31
{
	public static void main(String args[])
	{
		DeckOfCards deck = new DeckOfCards();
		deck.shuffle();
		Card[] hand = new Card[5];
		Card[] hand2 = new Card[5];
		System.out.println("The First Player holds:");
		for (int i = 0; i < 5; i++)
		{
			hand[i] = deck.dealCard();
			System.out.printf("%s\n", hand[i].toString());
		}
		System.out.println();
		System.out.println("The Second Player holds:");
		for (int i = 0; i < 5; i++)
		{
			hand2[i] = deck.dealCard();
			System.out.printf("%s\n", hand2[i].toString());
		}
		System.out.println();
		int ans = DeckOfCards.compareHands(hand, hand2);
		if (ans > 0)
			System.out.println("The first hand is better.");
		else if (ans < 0)
			System.out.println("The second hand is better.");
		else 
			System.out.println("They are equal.");			
	}
}