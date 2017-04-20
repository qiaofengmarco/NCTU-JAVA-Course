import java.security.SecureRandom;
import java.util.*;
public class DeckOfCards
{
	private Card[] deck;
	private int currentCard;
	private static final int NUMBER_OF_CARDS = 52;
	private static final SecureRandom randomNumbers = new SecureRandom();
	//private static int[] ans = new int[2];
	public DeckOfCards()
	{
		String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
		deck = new Card[NUMBER_OF_CARDS];
		currentCard = 0;
		for (int count = 0; count < deck.length; count++)
			deck[count] = new Card(faces[count % 13], suits[count / 13]);
	}
	public void shuffle()
	{
		currentCard = 0;
		for (int first = 0; first < deck.length; first++)
		{
			int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
			Card temp = deck[first];
			deck[first] = deck[second];
			deck[second] = temp;
		}
	}
	public Card dealCard()
	{
		if (currentCard < deck.length)
			return deck[currentCard++];
		else
			return null;
	}
	public static boolean determinePair(Card[] hand)
	{
		if (hand.length > 13) return true;
		String temp;
		Set<String> check = new HashSet<String>();
		for (int i = 0; i < hand.length; i++)
		{
			temp = hand[i].getFace();
			if (!check.contains(temp))
				check.add(temp);
			else
				return true;
		}
		return false;
	}
	public static int[] getPair(Card[] hand)
	{
		int[] ans = new int[1];
		ans[0] = -1;
		if (!DeckOfCards.determinePair(hand)) return ans;
		String temp;
		Set<String> check = new HashSet<String>();
		for (int i = 0; i < hand.length; i++)
		{
			temp = hand[i].getFace();
			if (!check.contains(temp))
				check.add(temp);
			else
			{
				ans[0] = hand[i].faceToInt();
				return ans;
			}
		}
		return ans;	
	}
	public static boolean determineTwoPairs(Card[] hand)
	{
		String temp;
		int count = 0;
		Set<String> check = new HashSet<String>();
		Set<String> check2 = new HashSet<String>();
		for (int i = 0; i < hand.length; i++)
		{
			temp = hand[i].getFace();
			if (!check.contains(temp))
				check.add(temp);
			else
			{
				if (!check2.contains(temp))
				{
					count++;
					if (count == 2) return true;
					check2.add(temp);
				}
			}
		}
		return false;
	}
	public static int[] getTwoPairs(Card[] hand)
	{
		int[] ans = new int[2];
		ans[0] = -1;
		ans[1] = -1;
		if (!DeckOfCards.determineTwoPairs(hand)) return ans;
		String temp;
		int count = 0;
		Set<String> check = new HashSet<String>();
		Set<String> check2 = new HashSet<String>();
		for (int i = 0; i < hand.length; i++)
		{
			temp = hand[i].getFace();
			if (!check.contains(temp))
				check.add(temp);
			else
			{
				if (!check2.contains(temp))
				{
					ans[count] = hand[i].faceToInt();
					count++;
					if (count == 2) return ans;
					check2.add(temp);
				}
			}
		}
		return ans;
	}
	public static boolean determineThree(Card[] hand)
	{
		String temp;
		int count = 0;
		Set<String> check = new HashSet<String>();
		for (int i = 0; i < hand.length; i++)
		{
			temp = hand[i].getFace();
			if (!check.contains(temp))
				check.add(temp);
			else
			{
				count++;
				if (count == 2) return true;
			}
		}
		return false;
	}
	public static int[] getThree(Card[] hand)
	{
		int[] ans = new int[1];
		ans[0] = -1;
		int count = 0;
		if (!DeckOfCards.determinePair(hand)) return ans;
		String temp;
		Set<String> check = new HashSet<String>();
		for (int i = 0; i < hand.length; i++)
		{
			temp = hand[i].getFace();
			if (!check.contains(temp))
				check.add(temp);
			else
			{
				count++;
				if (count == 2)
				{
					ans[0] = hand[i].faceToInt();
					return ans;
				}
			}
		}
		return ans;	
	}
	public static boolean determineFour(Card[] hand)
	{
		String temp;
		int count = 0;
		Set<String> check = new HashSet<String>();
		for (int i = 0; i < hand.length; i++)
		{
			temp = hand[i].getFace();
			if (!check.contains(temp))
				check.add(temp);
			else
			{
				count++;
				if (count == 3) return true;
			}
		}
		return false;		
	}
	public static boolean determineFlush(Card[] hand)
	{
		String temp;
		int count = 0;
		Set<String> check = new HashSet<String>();
		for (int i = 0; i < hand.length; i++)
		{
			temp = hand[i].getSuit();
			if (!check.contains(temp))
			{
				if (count > 0)
					return false;
				check.add(temp);
				count++;
			}
		}
		return true;	
	}
	public static boolean determineStraight(Card[] hand)
	{
		if (DeckOfCards.determinePair(hand)) return false;
		SortedSet<Integer> check = new TreeSet<Integer>();
		for (int i = 0; i < hand.length; i++)
			check.add(new Integer(hand[i].faceToInt()));
		Integer[] a = new Integer[5];
		check.toArray(a);
		if (a.length == 5)
		{
			for (int i = 1; i < 5; i++)
				if (a[i].intValue() - a[0].intValue() != i)
					return false;
			return true;
		}
		return false;
	}
	public static boolean determineFullHouse(Card[] hand)
	{
		if (!DeckOfCards.determineTwoPairs(hand)) return false;
		String temp;
		int count = 0;
		Set<String> check = new HashSet<String>();
		for (int i = 0; i < hand.length; i++)
		{
			temp = hand[i].getSuit();
			if (!check.contains(temp))
			{
				count++;
				if (count == 2)
					return false;
				check.add(temp);
			}
		}
		return true;		
	}
	public static int determineHand(Card[] hand)
	{
		if (DeckOfCards.determineFlush(hand))
			return 5;
		else if (DeckOfCards.determineFour(hand))
			return 7;
		else if (DeckOfCards.determineFullHouse(hand))
			return 6;
		else if (DeckOfCards.determineTwoPairs(hand))
			return 2;
		else if (DeckOfCards.determineThree(hand))
			return 3;
		else if (DeckOfCards.determinePair(hand))
			return 1;
		else if (DeckOfCards.determineStraight(hand))
			return 4;
		else
			return 0;
	}
	public static int compareHands(Card[] h1, Card[] h2)
	{
		if (h1.length != h2.length) return -2; //error

		int c1 = -1, c2 = -1;
		int s1 = DeckOfCards.determineHand(h1), s2 = DeckOfCards.determineHand(h2);
		if (s1 > s2)
			return 1;
		else if (s1 < s2)
			return -1;
		//more detailed comparasion would be finished if only I have time...
		/*int[] a1 = new int[h1.length], int a2 = new int[h1.length];
		for (int i = 0; i < h1.length; i++)
		{
			a1[i] = h1[i].faceToInt();
			a2[i] = h2[i].faceToInt();			
		}
		Array.sort(a1);
		Array.sort(a2);
		if (c1 == 0)
		{
			if (a1[h1.length - 1] > a2[h1.length - 1])
				return 1;
			else if (a1[h1.length - 1] < a2[h1.length - 1])
				return -1;
			else 
				return 0;
		}
		else if (c1 == 1)
		{
			int[] check1 = new int[14];
			int[] check2 = new int[14];
			for (int i = 0; i < h1.length; i++)
			{
				if (check1[a1[i]] > check2[a2[i]])
					return -1;
				else if (check1[a1[i]] < check2[a2[i]])
					return 1;
				if (check1[a1[i]] == 0)
					check1[a1[i]] = 1;
				if (check2[a2[i]] == 0)
					check2[a2[i]] = 1;
			}
		}	*/
		return 0;
	}
}
