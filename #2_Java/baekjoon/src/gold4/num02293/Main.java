package gold4.num02293;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 동전의 종류 수, 목표 가치를 각 변수에 할당
		int typeNum = Integer.parseInt(st.nextToken());
		int targetValue = Integer.parseInt(st.nextToken());
		
		// 각 동전의 종류를 저장할 배열 coins 초기화
		int[] coins = new int[typeNum + 1];
		
		// for 반복문을 사용해 입력 받은 각 동전의 종류를 배열 coins에 저장
		for (int idx = 1; idx <= typeNum; idx++)
			coins[idx] = Integer.parseInt(in.readLine());
		
		// 각 목표 가치를 만들기 위해 필요한 동전의 경우의 수를 저장할 배열 counter 초기화
		int[] counter = new int[targetValue + 1];
		
		// 목표 가치가 0인 경우의 수를 갱신
		counter[0] = 1;
		
		// for 반복문을 사용해 각 동전을 순회
		for (int idx = 1; idx <= typeNum; idx++) {
			
			// for 반복문을 사용해 각 목표 금액의 경우의 수를 갱신
			for (int value = coins[idx]; value <= targetValue; value++)
				counter[value] += counter[value - coins[idx]];	
		}
		
		// valueOf() 및 write() 메서드를 사용해 주어진 목표 가치를 만들기 위해 필요한 동전의 경우의 수를 출력
		out.write(String.valueOf(counter[targetValue]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}