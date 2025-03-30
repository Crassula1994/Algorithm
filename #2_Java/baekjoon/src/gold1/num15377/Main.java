package gold1.num15377;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 레이저가 튕긴 횟수를 변수 bounceCount에 할당
			int bounceCount = Integer.parseInt(in.readLine());
			
			// wayCounter() 및 write() 메서드를 사용해 주어진 횟수만큼 튕긴 뒤 원래 위치로 돌아오도록 레이저를 쏘는 방법의 수를 출력
			out.write(wayCounter(bounceCount) + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// wayCounter() 메서드 정의
	public static int wayCounter(int bounceCount) {
		
		// 원래 위치로 돌아오도록 레이저를 쏘는 방법의 수를 저장할 변수 launchCount 초기화
		int launchCount = bounceCount;
		
		// for 반복문을 사용해 각 인수를 순회
		for (int factor = 2; factor * factor <= bounceCount; factor++) {
			
			// 해당 인수가 레이저를 쏘는 방법의 수의 소인수가 아닌 경우 다음 인수를 순회
			if (bounceCount % factor != 0)
				continue;
			
			// while 반복문을 사용해 레이저를 쏘는 방법의 수를 해당 소인수로 더 나누어지지 않을 때까지 갱신
			while (bounceCount % factor == 0)
				bounceCount /= factor;
			
			// 원래 위치로 돌아오도록 레이저를 쏘는 방법의 수를 갱신
			launchCount -= launchCount / factor;
		}
		
		return launchCount;
	}
}