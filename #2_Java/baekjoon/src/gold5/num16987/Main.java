package gold5.num16987;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Egg 클래스 정의
	static class Egg {
		
		// 계란의 내구도와 무게를 나타내는 각 변수 초기화
		int solidity;
		int weight;
		
		// 인자를 입력 받는 생성자 정의
		public Egg(int solidity, int weight) {
			this.solidity = solidity;
			this.weight = weight;
		}
	}
	
	// 계란의 수, 깰 수 있는 계란의 최대 개수를 저장할 각 변수 초기화
	static int eggNum;
	static int maxCount = 0;
	
	// 각 계란의 상태를 저장할 배열 eggs 초기화
	static Egg[] eggs;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 계란의 수를 변수 eggNum에 할당
		eggNum = Integer.parseInt(in.readLine());
		
		// 각 계란의 상태를 저장할 배열 eggs 초기화
		eggs = new Egg[eggNum];
		
		// for 반복문을 사용해 각 계란의 정보를 순회
		for (int idx = 0; idx < eggNum; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 계란의 내구도와 무게를 각 변수에 할당
			int solidity = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			// 계란의 상태를 배열 eggs에 저장
			eggs[idx] = new Egg(solidity, weight);
		}
		
		// eggBreaker() 메서드를 호출해 깰 수 있는 계란의 최대 개수를 갱신
		eggBreaker(0);
		
		// valueOf() 및 write() 메서드를 사용해 깰 수 있는 계란의 최대 개수를 출력
		out.write(String.valueOf(maxCount));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// eggBreaker() 메서드 정의
	public static void eggBreaker(int currentEgg) {
		
		// 모든 계란을 한 번씩 다 친 경우
		if (currentEgg == eggNum) {
			
			// 깨진 계란의 개수를 저장할 변수 count 초기화
			int count = 0;
			
			// for 반복문을 사용해 각 계란을 순회
			for (int idx = 0; idx < eggNum; idx++) {
				
				// 해당 계란이 깨진 경우 깨진 계란의 개수를 갱신
				if (eggs[idx].solidity <= 0)
					count++;
			}
			
			// max() 메서드를 사용해 깰 수 있는 계란의 최대 개수를 갱신
			maxCount = Math.max(count, maxCount);
			
			// 메서드 종료
			return;
		}
		
		// 현재 들고 있는 계란이 깨진 경우 다음 계란을 든 경우를 상정해 eggBreaker() 메서드 재귀 호출
		if (eggs[currentEgg].solidity <= 0) {
			eggBreaker(currentEgg + 1);
		
		// 현재 들고 있는 계란이 깨지지 않은 경우
		} else {
			
			// 깰 수 있는 계란이 있는지 여부를 저장할 변수 isBreakable 초기화
			boolean isBreakable = false;
			
			// for 반복문을 사용해 각 계란을 순회
			for (int idx = 0; idx < eggNum; idx++) {
				
				// 현재 손에 든 계란이거나 깨진 계란인 경우 다음 계란을 순회
				if (idx == currentEgg || eggs[idx].solidity <= 0)
					continue;
				
				// 깰 수 있는 계란이 있는지 여부를 갱신
				isBreakable = true;
				
				// 해당 계란을 친 것으로 처리
				eggs[currentEgg].solidity -= eggs[idx].weight;
				eggs[idx].solidity -= eggs[currentEgg].weight;
				
				// eggBreaker() 메서드 재귀 호출
				eggBreaker(currentEgg + 1);
				
				// 해당 계란을 치지 않은 것으로 원상복구
				eggs[currentEgg].solidity += eggs[idx].weight;
				eggs[idx].solidity += eggs[currentEgg].weight;
			}
			
			// 깰 수 있는 계란이 없는 경우 다음 계란을 호출
			if (!isBreakable)
				eggBreaker(currentEgg + 1);
		}
	}
}