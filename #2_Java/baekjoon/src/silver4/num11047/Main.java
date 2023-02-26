package silver4.num11047;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 동전의 종류 및 구하고자 하는 가치의 합을 각 변수에 할당
		int coinNum = Integer.parseInt(st.nextToken());
		int targetPrice = Integer.parseInt(st.nextToken());
		
		// 각 동전의 종류를 저장할 배열 coins 초기화
		int[] coins = new int[coinNum];
		
		// 구하고자 하는 가치를 위해 필요한 최소 동전의 수를 저장할 변수 minCnt 초기화
		int minCnt = 0;

		// for 반복문을 사용해 각 동전의 종류를 배열 coins에 저장
		for (int idx = 0; idx < coins.length; idx++)
			coins[idx] = Integer.parseInt(in.readLine());
	
		// for 반복문을 사용해 각 동전의 종류를 순회
		for (int idx = coins.length - 1; idx >= 0; idx--) {
			
			// 해당 동전이 필요한 개수를 구해 동전의 수에 갱신
			minCnt += targetPrice / coins[idx];
			
			// 구해야 하는 가치의 합을 갱신
			targetPrice %= coins[idx];
			
			// 가치의 합이 0인 경우 반복문 탈출
			if (targetPrice == 0)
				break;
		}

		// valueOf() 및 write() 메서드를 사용해 최소 동전의 개수를 출력
		out.write(String.valueOf(minCnt));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}