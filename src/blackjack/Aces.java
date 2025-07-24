package blackjack;

public class Aces extends Card {
	static char number = 'A';
	
	
	public Aces(int symbol) {
		this.name = "" + SYMBOLS[symbol] + number;
		this.score = 11;
	}
	
	
}
