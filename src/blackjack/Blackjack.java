package blackjack;

import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack {
	static Scanner sc = new Scanner(System.in);

	
	
	
	static void start() {
		
		Player_p p1 = new Player_p("플레이어");
		Player_dealer d1 = new Player_dealer("딜러");
		
		System.out.println("### 블랙잭 게임을 시작합니다~!!!! ###");
		System.out.println("덱을 생성합니다. \n카드를 섞는 중....");
		ArrayList<Card> deck = Card.setDeck();

		while (true) {
			
			if (deck.size() < Card.NUM_OF_DECK * Card.WHEN_TO_SHUFFLE) {
				System.out.println("카드수가 적어 새로운 덱을 사용합니다. \n 카드를 섞는 중...");
				deck = Card.setDeck();
			}
			
			// 베팅하기
			int bet = 0;
			while (true) {
				boolean pass = true;
				System.out.println("얼마를 베팅하시겠습니까? 소지금: " + p1.money);
				bet = sc.nextInt();
				if (bet > p1.money) {
					System.out.println("너무 큰 금액입니다. 다시 입력하세요.");
					pass = false;
				}
				if (bet <= 0) {
					System.out.println("최소베팅은 1입니다.");
					pass = false;
				}
				// TODO 숫자가 아닐 때 검증하기
				if (pass) break;
			}
			
			// 카드 받기
			System.out.println("플레이어에게 카드 한 장을 드리겠습니다...");
			p1.hand.add(deck.removeFirst());
//			p1.hand.add(new Aces(1));
//			p1.hand.add(new High_cards(0, 1));
			System.out.println("딜러가 카드 한 장을 뽑습니다.");
			d1.hand.add(deck.removeFirst());
			System.out.println("플레이어에게 두 번째 카드를 드리겠습니다... 두구두구\n");
			p1.hand.add(deck.removeFirst());
			p1.print();
			
			boolean blackjack = false;
			if (p1.getScore() == 21) {
				System.out.println("!!블랙잭!!");
				blackjack = true;
			}
			
			
			System.out.print("딜러의 카드: ");
			System.out.println(d1.hand);
			d1.hand.add(deck.removeFirst());
			
			if (blackjack) {
				if (d1.getScore() == 21) {
					System.out.println("Push..");
				} else {
					System.out.println("플레이어 승리!!");
					p1.money += bet * 1.5;
				}
				d1.print();
				// TODO 손패비우기 메서드화 하기
				p1.hand.clear();
				d1.hand.clear();
				System.out.println("손패를 모두 제거했습니다.");
				continue;
			}
			
			
			// stand와 hit 받기
			boolean playerBurst = false;
			while (true) {
				System.out.println("카드를 받으시려면 (1)을 그만 받으시려면 (2)를 입력하세요.");
				int input = sc.nextInt();
				// TODO 유효성검증
				if (input == 1) {
					p1.hand.add(deck.removeFirst());
					p1.print();
					if (p1.getScore() > Card.BLACKJACK) {
						System.out.println("플레이어의 Burst! 베팅한 칩을 잃습니다.");
						playerBurst = true;
						p1.money -= bet;
						break;
					}
				}
				if (input == 2) break;
			}
			// 점수계산해서 딜러와 승부겨루기
			boolean dealerBurst = false;
			if (!playerBurst) {
				while (d1.getScore() < Player_dealer.DEALER_CAP) {
					d1.hand.add(deck.removeFirst());
					
					if (d1.getScore() > Card.BLACKJACK) {
						System.out.println("딜러의 Burst!");
						dealerBurst = true;
					}
				}
				d1.print();
				
				if (!dealerBurst) {
					if (p1.getScore() > d1.getScore()) {
						System.out.println("플레이어 승리!!");
						p1.money += bet;
					} else if (p1.getScore() == d1.getScore()) {
						System.out.println("Push!!");
					} else {
						System.out.println("딜러의 승리...");
						p1.money -= bet;
					}
				} else {
					System.out.println("플레이어 승리!!");
					p1.money += bet;
				}
			}
			
			
			
			// 카드 비우기
			p1.hand.clear();
			d1.hand.clear();
			System.out.println("손패를 모두 제거했습니다.");
			
			
			if (p1.money <= 0) {
				System.out.println("소지금을 모두 잃었습니다. 게임을 종료합니다.");
				break;
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		
		start();
		
		
	}
}

// 초기덱을 만들어야 한다. ace4장, 숫자카드 2~9 문양별로, 하이카드 jqk 4장씩   [완]
// 덱 생성 후 collections.shuffle로 한 번 셔플해준다						[완]
// 사용자에게 두장, 딜러에게 한장오픈 한장 뒷면으로 딜한다						
// 사용자는 stand와 hit을 선택할 수 있다. 21점이면 blackjack이다. 21을 넘으면 burst로 진다
// 딜러는 16점이 넘을 때까지 카드를 뽑아야 한다
// 최종점수를 비교해서 높은 쪽이 승리한다.
// 한 턴이 끝나면 핸드를 다 비우고, 쓴카드는 없애고
// 카드가 25% 이하로 남으면 덱을 새로 생성한다.
// 베팅은 나중에 추가할 것

// TODO 처음에 21이면 블랙잭 출력해주기!!
// TODO 올인버튼만들기
// TODO 다인용으로 바꾸기