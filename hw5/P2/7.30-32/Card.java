public class Card
{
	private final String face;
	private final String suit;
	public Card(String cardFace, String cardSuit)
	{
		face = cardFace;
		suit = cardSuit;
	}
	public String toString()
	{
		return face + " of " + suit;
	}
	public String getFace()
	{
		return face;
	}
	public String getSuit()
	{
		return suit;
	}
	public int faceToInt()
	{
		String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		for (int i = 0; i < faces.length; i++)
			if (faces[i] == face)
				return i + 1;
		return 0;
	}
	public String intToFace(int a)
	{
		String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		return faces[a - 1];
	}
}