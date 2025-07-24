package blackjack;

public class Low_cards extends Card {
	static char[] numbers = {	'2', '3', '4', '5', '6', '7', '8', '9'	};

	
	public Low_cards(int symbol, int number) {
		this.name = "" + SYMBOLS[symbol] + numbers[number];
		this.score = numbers[number] - '0';
	}
	
	
	
	
}
