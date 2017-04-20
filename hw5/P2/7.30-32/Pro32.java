import java.security.SecureRandom;
public class Pro32
{
	private static final SecureRandom random = new SecureRandom();
	public static void main(String[] args)
	{
		int reevaluation;
		String[] v = {"A single", "A pair", "Two pairs", "Three of a kind", "A straight", "A flush", "A Full House", "Four of a kind"};
		String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
		DeckOfCards deck = new DeckOfCards();
		deck.shuffle();
		Card temp, old, old1, old2;
		int count = 0;
		Card[] s = new Card[47];
		Card[] dealer_hold = new Card[5];
		for (int i = 0; i < 5; i++)
		{
			dealer_hold[i] = deck.dealCard();
			System.out.printf("%s\n", dealer_hold[i].toString());
		}
		boolean flag = false;
		for (int i = 0; i < 52; i++)
		{
			flag = false;
			for (int j = 0; j < 5; j++)
				if ((faces[i % 13] == dealer_hold[j].getFace()) && (suits[i / 13] == dealer_hold[j].getSuit()))
				{
					flag = true;
					break;
				}
			if (!flag)
			{
				s[count] = new Card(faces[i % 13], suits[i / 13]);
				count++;
			}
		}
		System.out.println();
		int E1 = 0, E2 = 0, E3 = 0, check1, check2, c1 = -1, c2 = -1, c3 = -1;
		int base = DeckOfCards.determineHand(dealer_hold);
		if (base < 4)
		{	
			if (base == 3)
			{
				int[] k1;
				k1 = DeckOfCards.getThree(dealer_hold);
				check1 = k1[0];
				for (int c = 0; c < 5; c++)
				{
					if (dealer_hold[c].faceToInt() != check1)
					{
						dealer_hold[c] = s[random.nextInt(47)];
						break;
					}
				}
				System.out.println("After Drawing One Card:");
			}
			else if (base == 2)
			{
				int k;
				int[] k1;
				k1 = DeckOfCards.getTwoPairs(dealer_hold);
				check1 = k1[0];
				check2 = k1[1];	
				for (int c = 0; c < 5; c++)
				{
					k = dealer_hold[c].faceToInt();
					if ((k != check1) && (k != check2))
					{
						dealer_hold[c] = s[random.nextInt(47)];
						break;
					}
				}
				System.out.println("After Drawing One Card:");
			}
			else if (base == 1)
			{
				int[] kk1;
				kk1 = DeckOfCards.getPair(dealer_hold);
				check1 = kk1[0];
				for (int j = 0; j < 50; j++)
				{
					c1 = -1;
					c1 = random.nextInt(5);
					while (dealer_hold[c1].faceToInt() == check1)
						c1 = random.nextInt(5);
					old = dealer_hold[c1];
					dealer_hold[c1] = s[random.nextInt(47)];
					E1 += DeckOfCards.determineHand(dealer_hold) - base;
					dealer_hold[c1] = old;
				}
				c1 = -1;
				for (int i = 0; i < 50; i++)
				{
					int k1 = -1, k2 = -1;
					c2 = -1;
					c1 = random.nextInt(5);
					while (dealer_hold[c1].faceToInt() == check1)
						c1 = random.nextInt(5);
					while ((c1 == c2) || (c2 < 0) || (dealer_hold[c2].faceToInt() == check1))
						c2 = random.nextInt(5);
					k1 = random.nextInt(47);
					while ((k1 == k2) || (k2 < 0))
						k2 = random.nextInt(47);
					old = dealer_hold[c1];
					old1 = dealer_hold[c2];
					dealer_hold[c1] = s[k1];
					dealer_hold[c2] = s[k2];
					E2 += DeckOfCards.determineHand(dealer_hold) - base;
					dealer_hold[c1] = old1;
					dealer_hold[c2] = old;
				}
				for (int i = 0; i < 50; i++)
				{
					int k1 = -1, k2 = -1, k3 = -1;
					c2 = -1;
					c1 = random.nextInt(5);
					while (dealer_hold[c1].faceToInt() == check1)
						c1 = random.nextInt(5);
					while ((c1 == c2) || (c2 < 0) || (dealer_hold[c2].faceToInt() == check1))
						c2 = random.nextInt(5);
					c3 = -1;
					while ((c1 == c3) || (c2 == c3) || (c3 < 0) || (dealer_hold[c3].faceToInt() == check1))
						c3 = random.nextInt(5);
					k1 = random.nextInt(47);
					while ((k1 == k2) || (k2 < 0))
						k2 = random.nextInt(47);
					while ((k1 == k3) || (k2 == k3) || (k3 < 0))
						k3 = random.nextInt(47);
					old = dealer_hold[c1];
					old1 = dealer_hold[c2];
					old2 = dealer_hold[c3];
					dealer_hold[c1] = s[k1];
					dealer_hold[c2] = s[k2];
					dealer_hold[c3] = s[k3];
					E3 += DeckOfCards.determineHand(dealer_hold) - base;
					dealer_hold[c1] = old1;
					dealer_hold[c2] = old;
					dealer_hold[c3] = old2;
				}
				int maxnum = Math.max(Math.max(E1, E2), E3);
				if (maxnum == E1)
				{
					c1 = random.nextInt(5);
					while (dealer_hold[c1].faceToInt() == check1)
						c1 = random.nextInt(5);
					dealer_hold[c1] = s[random.nextInt(47)];
					System.out.println("After Drawing One Card:");
				}
				else if (maxnum == E2)
				{
					int k1 = -1, k2 = -1;
					c2 = -1;
					c1 = random.nextInt(5);
					while (dealer_hold[c1].faceToInt() == check1)
						c1 = random.nextInt(5);
					while ((c1 == c2) || (c2 < 0) || (dealer_hold[c2].faceToInt() == check1))
						c2 = random.nextInt(5);
					k1 = random.nextInt(47);
					while ((k1 == k2) || (k2 < 0))
						k2 = random.nextInt(47);
					dealer_hold[c1] = s[k1];
					dealer_hold[c2] = s[k2];
					System.out.println("After Drawing Two Cards:");
				}
				else if (maxnum == E3)
				{
					int k1 = -1, k2 = -1, k3 = -1;
					c2 = -1;
					c1 = random.nextInt(5);
					while (dealer_hold[c1].faceToInt() == check1)
						c1 = random.nextInt(5);
					while ((c1 == c2) || (c2 < 0) || (dealer_hold[c2].faceToInt() == check1))
						c2 = random.nextInt(5);
					c3 = -1;
					while ((c1 == c3) || (c2 == c3) || (c3 < 0) || (dealer_hold[c3].faceToInt() == check1))
						c3 = random.nextInt(5);
					k1 = random.nextInt(47);
					while ((k1 == k2) || (k2 < 0))
						k2 = random.nextInt(47);
					while ((k1 == k3) || (k2 == k3) || (k3 < 0))
						k3 = random.nextInt(47);
					dealer_hold[c1] = s[k1];
					dealer_hold[c2] = s[k2];
					dealer_hold[c3] = s[k3];
					System.out.println("After Drawing Three Cards:");
				}
			}
			else
			{
				for (int j = 0; j < 50; j++)
				{
					c1 = -1;
					c1 = random.nextInt(5);
					old = dealer_hold[c1];
					dealer_hold[c1] = s[random.nextInt(47)];
					E1 += DeckOfCards.determineHand(dealer_hold) - base;
					dealer_hold[c1] = old;
				}
				c1 = -1;
				for (int i = 0; i < 50; i++)
				{
					int k1 = -1, k2 = -1;
					c2 = -1;
					c1 = random.nextInt(5);
					while ((c1 == c2) || (c2 < 0))
						c2 = random.nextInt(5);
					k1 = random.nextInt(47);
					while ((k1 == k2) || (k2 < 0))
						k2 = random.nextInt(47);
					old = dealer_hold[c1];
					old1 = dealer_hold[c2];
					dealer_hold[c1] = s[k1];
					dealer_hold[c2] = s[k2];
					E2 += DeckOfCards.determineHand(dealer_hold) - base;
					dealer_hold[c1] = old1;
					dealer_hold[c2] = old;
				}
				for (int i = 0; i < 50; i++)
				{
					int k1 = -1, k2 = -1, k3 = -1;
					c2 = -1;
					c1 = random.nextInt(5);
					while ((c1 == c2) || (c2 < 0))
						c2 = random.nextInt(5);
					c3 = -1;
					while ((c1 == c3) || (c2 == c3) || (c3 < 0))
						c3 = random.nextInt(5);
					k1 = random.nextInt(47);
					while ((k1 == k2) || (k2 < 0))
						k2 = random.nextInt(47);
					while ((k1 == k3) || (k2 == k3) || (k3 < 0))
						k3 = random.nextInt(47);
					old = dealer_hold[c1];
					old1 = dealer_hold[c2];
					old2 = dealer_hold[c3];
					dealer_hold[c1] = s[k1];
					dealer_hold[c2] = s[k2];
					dealer_hold[c3] = s[k3];
					E3 += DeckOfCards.determineHand(dealer_hold) - base;
					dealer_hold[c1] = old1;
					dealer_hold[c2] = old;
					dealer_hold[c3] = old2;
				}
				int maxnum = Math.max(Math.max(E1, E2), E3);
				if (maxnum == E1)
				{
					c1 = random.nextInt(5);
					dealer_hold[c1] = s[random.nextInt(47)];
					System.out.println("After Drawing One Card:");
				}
				else if (maxnum == E2)
				{
					int k1 = -1, k2 = -1;
					c2 = -1;
					c1 = random.nextInt(5);
					while ((c1 == c2) || (c2 < 0))
						c2 = random.nextInt(5);
					k1 = random.nextInt(47);
					while ((k1 == k2) || (k2 < 0))
						k2 = random.nextInt(47);
					dealer_hold[c1] = s[k1];
					dealer_hold[c2] = s[k2];
					System.out.println("After Drawing Two Cards:");
				}
				else if (maxnum == E3)
				{
					int k1 = -1, k2 = -1, k3 = -1;
					c2 = -1;
					c1 = random.nextInt(5);
					while ((c1 == c2) || (c2 < 0))
						c2 = random.nextInt(5);
					c3 = -1;
					while ((c1 == c3) || (c2 == c3) || (c2 < 0) || (c3 < 0))
						c3 = random.nextInt(5);
					k1 = random.nextInt(47);
					while ((k1 == k2) || (k2 < 0))
						k2 = random.nextInt(47);
					while ((k1 == k3) || (k2 == k3) || (k3 < 0))
						k3 = random.nextInt(47);
					dealer_hold[c1] = s[k1];
					dealer_hold[c2] = s[k2];
					dealer_hold[c3] = s[k3];
					System.out.println("After Drawing Three Cards:");
				}
			}
			reevaluation = DeckOfCards.determineHand(dealer_hold);
			for (int i = 0; i < 5; i++)
				System.out.printf("%s\n", dealer_hold[i].toString());
			System.out.println();
			if (base > reevaluation)
				System.out.println("The previous hand is better.");
			else if (base < reevaluation)
				System.out.println("The current hand is better.");
			else 
				System.out.println("They are equal.");
			System.out.println();
			System.out.printf("Current: %s\n", v[reevaluation]);
		}
		else
			System.out.println("Dealer does nothing.");
	}
}