package bronze4.num15372;

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
		
		// 입력 받은 정수 제곱의 배수가 되는 양의 정수의 최솟값을 저장할 StringBuilder 객체 초기화
		StringBuilder sb = new StringBuilder();
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// readLine() 및 parseLong() 메서드를 사용해 입력 받은 정수를 변수 number에 할당
			long number = Long.parseLong(in.readLine());
			
			// append() 메서드를 사용해 입력 받은 정수 제곱의 배수가 되는 양의 정수의 최솟값을 sb에 추가
			sb.append(number * number).append("\n");
		}
		
		// toString() 및 write() 메서드를 사용해 입력 받은 정수 제곱의 배수가 되는 양의 정수의 최솟값을 출력
		out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}