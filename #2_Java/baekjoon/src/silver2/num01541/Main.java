package silver2.num01541;

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
		
		// StringTokenizer 객체를 불러와 변수 minusTokenizer에 할당
		StringTokenizer minusTokenizer = new StringTokenizer(in.readLine(), "-");
		
		// 초항인지를 나타낼 변수 isFirstTerm 초기화
		boolean isFirstTerm = true;
		
		// 계산 결과를 저장할 변수 result 초기화
		int result = 0;
		
		// while 반복문을 사용해 뺄셈 기호를 기준으로 나눈 결과를 순회
		while (minusTokenizer.hasMoreTokens()) {
			
			//  StringTokenizer 객체를 불러와 변수 plusTokenizer에 할당
			StringTokenizer plusTokenizer = new StringTokenizer(minusTokenizer.nextToken(), "+");
			
			// 덧셈의 결과를 저장할 변수 term 초기화
			int term = 0;
			
			// while 반복문을 사용해 덧셈 기호를 기준으로 나눈 결과를 순회
			while (plusTokenizer.hasMoreTokens())
				
				// nextToken() 및 parseInt() 메서드를 사용해 각 숫자를 변수 term에 저장
				term += Integer.parseInt(plusTokenizer.nextToken());
			
			// 초항인 경우 덧셈 후 변수 갱신
			if (isFirstTerm) {
				result += term;
				isFirstTerm = false;
			
			// 초항이 아닌 경우 뺄셈 수행
			} else {
				result -= term;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 괄호를 쳤을 때 식의 최솟값을 출력
		out.write(String.valueOf(result));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}