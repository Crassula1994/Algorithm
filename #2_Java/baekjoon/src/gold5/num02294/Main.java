package gold5.num02294;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 동전의 최소 개수의 초기값을 나타낼 상수 INF 초기화
	static final int INF = 100001;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 동전의 종류 수, 목표 가치를 각 변수에 할당
		int typeNum = Integer.parseInt(st.nextToken());
		int targetValue = Integer.parseInt(st.nextToken());
		
		// 각 동전의 종류를 저장할 배열 coins 초기화
		int[] coins = new int[typeNum];
		
		// for 반복문을 사용해 입력 받은 각 동전의 종류를 배열 coins에 저장
		for (int idx = 0; idx < coins.length; idx++)
			coins[idx] = Integer.parseInt(in.readLine());
		
		// sort() 메서드를 사용해 각 동전의 종류를 가치에 따라 오름차순으로 정렬
		Arrays.sort(coins);
		
		// 각 목표 가치를 만들기 위해 필요한 동전의 최소 개수를 저장할 배열 minCounts 초기화
		int[] minCounts = new int[targetValue + 1];
		
		// fill() 메서드를 사용해 각 목표 가치를 만들기 위해 필요한 동전의 최소 개수를 초기화
		Arrays.fill(minCounts, INF);
		
		// 목표 가치가 0인 경우 동전의 최소 개수를 갱신
		minCounts[0] = 0;
		
		// for 반복문을 사용해 각 동전의 종류를 순회
		for (int idx = 0; idx < coins.length; idx++) {
			
			// for 반복문을 사용해 각 목표 금액을 순회
			for (int value = coins[idx]; value <= targetValue; value++) {
				
				// 해당 동전의 금액을 뺀만큼의 금액을 만들 수 없는 경우 다음 금액을 순회
				if (minCounts[value - coins[idx]] == INF)
					continue;
				
				// min() 메서드를 사용해 해당 목표 금액를 만들기 위해 필요한 동전의 최소 개수를 갱신
				minCounts[value] = Math.min(minCounts[value - coins[idx]] + 1, minCounts[value]);
			}
		}
		
		// 해당 목표 금액을 만들 수 없는 경우 -1을 출력
		if (minCounts[targetValue] == INF) {
			out.write(String.valueOf(-1));
			
		// 해당 목표 금액을 만들 수 있는 경우 사용한 동전의 최소 개수를 출력
		} else {
			out.write(String.valueOf(minCounts[targetValue]));
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}