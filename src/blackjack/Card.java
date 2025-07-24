package blackjack;

import java.util.ArrayList;
import java.util.Collections;

class Card {
	final static char[] SYMBOLS = {	'◇', '♡', '♣', '♠'	};
	final static int NUM_OF_SYMBOLS = 4;
	final static int NUM_OF_DECK = 52;
	final static double WHEN_TO_SHUFFLE = 0.25;
	final static int BLACKJACK = 21;
	
	String name;
	int score;
	
	@Override
	public String toString() {
		return name;
	}
	
	static ArrayList<Card> setDeck() {
		ArrayList<Card> deck = new ArrayList<>();
		
		// ace 생성
		for (int i = 0; i < Card.NUM_OF_SYMBOLS; i++) {
			
			deck.add(new Aces(i));
		}
		// 하이카드 생성
		for (int i = 0; i < Card.NUM_OF_SYMBOLS; i++) {
			for (int j = 0; j < High_cards.numbers.length; j++) {
				deck.add(new High_cards(i, j));
			}
		}
		// 숫자카드 생성
		for (int i = 0; i < Card.NUM_OF_SYMBOLS; i++) {
			for (int j = 0; j < Low_cards.numbers.length; j++) {
				deck.add(new Low_cards(i, j));
			}
		}
		Collections.shuffle(deck);
		
		return deck;
	}
	
}
