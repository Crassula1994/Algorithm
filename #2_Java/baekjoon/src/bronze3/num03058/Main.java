package bronze3.num03058;

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
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// 짝수의 합과 가장 작은 짝수를 저장할 각 변수 초기화
			int evenSum = 0;
			int minEven = Integer.MAX_VALUE;
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 7개의 숫자를 순회
			for (int n = 0; n < 7; n++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
				int number = Integer.parseInt(st.nextToken());
				
				// 해당 숫자가 짝수인 경우 짝수의 합과 가장 작은 짝수를 갱신
				if (number % 2 == 0) {
					evenSum += number;
					minEven = Math.min(number, minEven);
				}
			}
			
			// write() 메서드를 사용해 짝수의 합과 가장 작은 짝수를 출력
			out.write(evenSum + " " + minEven + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}