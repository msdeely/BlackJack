import java.util.Random;
import java.util.Scanner;

public class BlackJack {

	public int playerHand = 0;
	public int dealerHand = 0;
	public int blackJack = 21;
	public String moveChoice;
	
	
	Random random = new Random();
	
	
	public void move() {
		while(playerHand < blackJack && dealerHand < blackJack) {
			
			Scanner scan = new Scanner(System.in);
			
			int moveChoice = scan.nextInt();
			if(moveChoice == 1) {
				System.out.println(hit());
			
			}else if(moveChoice == 2) {
				System.out.println(stay());
				
			}
			
			if(playerHand > blackJack) {
				System.out.println("Game Over! You Lost.mThe Dealer's hand was: " + dealerHand);
			}else if(dealerHand > blackJack) {
				System.out.println("The dealer busted with a hand of " + dealerHand + ". You Win!");
			}
		}

	}
	
	public String hit() {
	int card = random.nextInt(11) + 1;
	int card2 = random.nextInt(11) + 1;
		playerHand += card;
		dealerHand += card2;
		return "You drew a: " + card + "\nYour hand: " + playerHand;		
	}

	public String stay() {
		return "Your hand is still a: " + playerHand;
		
	}
	

	public static void main(String[] args) {
		BlackJack m = new BlackJack();
		System.out.println("Hit 1 to draw and 2 to stay");
		
		m.move();

	
	}
}