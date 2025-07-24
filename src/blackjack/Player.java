package blackjack;

import java.util.ArrayList;

public class Player {
	Card card;
	ArrayList<Card> hand = new ArrayList<>();
	int score;
	String name;
	
	public Player(String name) {
		this.name = name;
	}
	
	int getScore() {
		int score = 0;
		int aceCount = 0;
		for (int i = 0; i < hand.size(); i++) {
			score += hand.get(i).score;
			if (hand.get(i) instanceof Aces) aceCount++;
		}
		
		while (score > 21 && aceCount > 0) {
			score -= 10;
			aceCount--;
		}
		
		
		return score;
	}
	
	void print() {
		System.out.printf("%s의 핸드: ", name);
		System.out.print(hand);
		System.out.printf(" (%d)\n", getScore());
		
	}
	
	@Override
	public String toString() {
		return name;
	}
}
