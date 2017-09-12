import java.util.Random;
import java.util.Arrays;

public class Roullette {
	private long hitCount[] = new long[38];
	private long totalGain = 0;
	private static final int rollCount = 200;

	private void incrementHitCount(int idx){
		this.hitCount[idx]++;
	}

	private void printHitCounts() {
		System.out.println(Arrays.toString(this.hitCount));
	}

	private void printPercentage() {
		//column winnings precentage
		//number hits

	}

	private int roll() {
		Random rand = new Random();
		return rand.nextInt(38); // returns 0-37. 0 = '0' and 37 = '00'
	}

	public Roullette() {}

	public static void main(String[] args) {
		Roullette r = new Roullette();
		//Roullette games[] = new Roullette[5000];
		long winCount = 0;
		long betAmount = 1;
		long maxBetAmount = 1;
		int betCap = 128;
		boolean capExists = true;

		for(long i = 0; i < 100; i++) {
			int rolledNum = r.roll();
			r.incrementHitCount(rolledNum);
			if(rolledNum % 3 == 1 && rolledNum != 37) {	//staying in first column
				//won! 
				winCount += betAmount*2;	// winnings are 2 to 1
				if(betAmount > maxBetAmount)
					maxBetAmount = betAmount;
				betAmount = 1;
			} else {
				winCount -= betAmount;
				if(betAmount < betCap && capExists)
					betAmount = betAmount * 2;
			}
		}
		System.out.println("Total winnings: " + winCount);
		System.out.println("Max bet increment: " + maxBetAmount);
		r.printHitCounts();
	}
}