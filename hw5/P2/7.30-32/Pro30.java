public class Pro30
{
	public static void main(String args[])
	{
		String[] v = {"A single", "A pair", "Two pairs", "Three of a kind", "A straight", "A flush", "A Full House", "Four of a kind"};
		DeckOfCards deck = new DeckOfCards();
		deck.shuffle();
		Card[] hand = new Card[5];
		for (int i = 0; i < 5; i++)
		{
			hand[i] = deck.dealCard();
			System.out.printf("%s\n", hand[i].toString());
		}
		System.out.println();
		System.out.println(v[DeckOfCards.determineHand(hand)]);
	}
}