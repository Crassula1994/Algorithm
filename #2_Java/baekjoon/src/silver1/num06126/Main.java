package silver1.num06126;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 동전의 종류 및 만들어야 하는 금액를 저장할 각 변수 초기화
		int coinNum = Integer.parseInt(st.nextToken());
		int targetValue = Integer.parseInt(st.nextToken());
		
		// 각 동전별 가치 및 각 금액을 만들 수 있는 동전 조합의 가짓수를 저장할 각 배열 초기화
		int[] coins = new int[coinNum];
		long[] counts = new long[targetValue + 1];
		
		// for 반복문을 사용해 입력 받은 동전의 가치를 배열 coins에 저장
		for (int idx = 0; idx < coins.length; idx++)
			coins[idx] = Integer.parseInt(in.readLine());
		
		// 금액이 0일 때 필요한 동전 조합의 가짓수를 초기화
		counts[0] = 1;
		
		// for 반복문을 사용해 각 동전의 가치를 순회
		for (int idx = 0; idx < coins.length; idx++) {
			
			// 해당 동전의 가치를 변수 coin에 할당
			int coin = coins[idx];
			
			// for 반복문을 사용해 만들 가치를 순회
			for (int value = coin; value <= targetValue; value++)
                counts[value] += counts[value - coin];
        }
		
		// valueOf() 및 write() 메서드를 사용해 만들어야 하는 금액을 만들 수 있는 동전 조합의 가짓수를 출력
		out.write(String.valueOf(counts[targetValue]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}