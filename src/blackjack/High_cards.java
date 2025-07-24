package blackjack;

public class High_cards extends Card {
	static char[] numbers = {	'J', 'Q', 'K'	};

	public High_cards(int symbol, int number) {
		this.name = "" + SYMBOLS[symbol] + numbers[number];
		this.score = 10;
	}
	
}
