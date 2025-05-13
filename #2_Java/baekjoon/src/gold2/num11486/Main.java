package gold2.num11486;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Drink 클래스 정의
	static class Drink {
		
		
		String name;
		int cost;
		int targetAmount;
		
		public Drink(String name, int cost, int targetAmount) {
			this.name = name;
			this.cost = cost;
			this.targetAmount = targetAmount;
		}
	}
	
	static int moneyLimit;
	static int drinkLimit;
	static int drinkNum;
	static int curCost = 0;
	static int curAmount = 0;
	
	static Drink[] drinks;
	static int[] bestCounts = null;
	static int[] curCounts;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken(), replace(), parseInt()  메서드를 사용해 입력 받은 돈의 양, 마실 술의 양, 서로 다른 술의 개수를 각 변수에 할당
		moneyLimit = Integer.parseInt(st.nextToken().replace(".", ""));
		drinkLimit = Integer.parseInt(st.nextToken().replace(".", ""));
		drinkNum = Integer.parseInt(st.nextToken());
		
		drinks = new Drink[drinkNum];
		curCounts = new int[drinkNum];
		
		for (int idx = 0; idx < drinks.length; idx++) {
			
			st = new StringTokenizer(in.readLine());
			
			String name = st.nextToken();
			int percent = Integer.parseInt(st.nextToken());
			String size = st.nextToken();
			int cost = Integer.parseInt(st.nextToken().replace(".", ""));
			
			int targetAmount = percent;
			
			switch (size) {
				case "1/1":
					targetAmount *= 60;
					break;
				case "1/2":
					targetAmount *= 30;
					break;
				default:
					targetAmount *= 20;
			}
			
			drinks[idx] = new Drink(name, cost, targetAmount);
		}
		
		drinkFinder(0);
		
		if (bestCounts == null) {
			out.write("IMPOSSIBLE");
		} else {
			for (int idx = 0; idx < bestCounts.length; idx++) {
				
				if (bestCounts[idx] == 0)
					continue;
				
				out.write(String.format("%s %d\n", drinks[idx].name, bestCounts[idx]));
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	public static void drinkFinder(int curDrink) {
		
		if (curDrink == drinkNum) {
			
			if (curCost == moneyLimit && curAmount == drinkLimit)
				bestCounts = curCounts.clone();
			
			return;
		}
		
		Drink drink = drinks[curDrink];
		
		for (int count = 0; ; count++) {
			int addedCost = count * drink.cost;
			int addedAmount = count * drink.targetAmount;
			
			curCost += addedCost;
			curAmount += addedAmount;
			curCounts[curDrink] = count;
			
			if (curCost > moneyLimit || curAmount > drinkLimit) {
				curCost -= addedCost;
				curAmount -= addedAmount;
				curCounts[curDrink] = 0;
				break;
			}
			
			drinkFinder(curDrink + 1);
			
			curCost -= addedCost;
			curAmount -= addedAmount;
			curCounts[curDrink] = 0;
		}
	}
}