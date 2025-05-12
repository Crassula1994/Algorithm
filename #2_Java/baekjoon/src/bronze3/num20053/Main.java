package bronze3.num20053;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// 주어진 정수의 최솟값과 최댓값을 저장할 각 변수 초기화
			int minNumber = Integer.MAX_VALUE;
			int maxNumber = Integer.MIN_VALUE;
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 정수의 개수를 변수 numberCnt에 할당
			int numberCnt = Integer.parseInt(in.readLine());
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// while 반복문을 사용해 각 정수를 순회
			while (numberCnt-- > 0) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 정수를 변수 number에 할당
				int number = Integer.parseInt(st.nextToken());
				
				// min() 및 max() 메서드를 사용해 주어진 정수의 최솟값과 최댓값을 갱신
				minNumber = Math.min(number, minNumber);
				maxNumber = Math.max(number, maxNumber);
			}
			
			// write() 메서드를 사용해 주어진 정수의 최솟값과 최댓값을 출력
			out.write(minNumber + " " + maxNumber + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}