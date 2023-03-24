package bronze3.num02720;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// 각 동전의 액수를 저장할 배열 coinValue 초기화
		int[] coinValue = {25, 10, 5, 1};
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// 각 동전의 개수를 저장할 배열 coins 초기화
			int[] coins = new int[4];
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 거스름돈의 액수를 변수 change에 할당
			int change = Integer.parseInt(in.readLine());
			
			// 현재 계산 중인 동전의 종류를 저장할 변수 index 초기화
			int index = 0;
			
			// while 반복문을 사용해 거스름돈이 없어질 때까지 순회
			while (change > 0) {
				
				// 나눌 동전의 종류를 변수 divisor에 할당
				int divisor = coinValue[index];
				
				// 필요한 동전의 개수를 갱신 
				coins[index++] += change / divisor;
				
				// 남은 거스름돈을 갱신
				change = change % divisor;
			}
			
			// for 반복문을 사용해 필요한 쿼터, 다임, 니켈, 페니의 개수를 차례로 출력
			for (int idx = 0; idx < coins.length; idx++)
				out.write(coins[idx] + " ");
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}