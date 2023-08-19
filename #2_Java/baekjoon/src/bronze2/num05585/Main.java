package bronze2.num05585;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 지불해야 할 돈의 액수를 변수 price에 할당
		int price = Integer.parseInt(in.readLine());
		
		// 각 동전의 종류를 저장할 배열 coins 초기화
		int[] coins = {500, 100, 50, 10, 5, 1};
		
		// 받을 잔돈의 개수, 거슬러 줘야 할 돈을 저장할 각 변수 초기화
		int count = 0;
		int remains = 1000 - price;
		
		// for 반복문을 사용해 각 동전을 순회
		for (int idx = 0; idx < coins.length; idx++) {
			
			// 잔돈의 개수를 갱신
			count += remains / coins[idx];
			
			// 남은 잔돈을 갱신
			remains %= coins[idx];
		}
		
		// valueOf() 및 write() 메서드를 사용해 받을 잔돈의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}