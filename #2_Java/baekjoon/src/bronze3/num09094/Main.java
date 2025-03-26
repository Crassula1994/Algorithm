package bronze3.num09094;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// 해당 테스트 케이스에서 문제의 조건을 만족하는 정수 쌍의 개수를 저장할 변수 count 초기화
			int count = 0;
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 두 정수를 각 변수에 할당
			int numberN = Integer.parseInt(st.nextToken());
			int numberM = Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 두 정수쌍을 순회
			for (int numberB = 2; numberB < numberN; numberB++) {
				for (int numberA = 1; numberA < numberB; numberA++) {
					
					// 문제 조건식의 분모와 분자를 계산해 각 변수에 할당
					int denominator = numberA * numberB;
					int numerator = numberA * numberA + numberB * numberB + numberM;
					
					// 분자가 분모로 나누어 떨어지는 경우 문제의 조건을 만족하는 정수 쌍의 개수를 갱신
					if (numerator % denominator == 0)
						count++;
				}
			}
			
			// write() 메서드를 사용해 해당 테스트 케이스에서 문제의 조건을 만족하는 정수 쌍의 개수를 출력
			out.write(count + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}