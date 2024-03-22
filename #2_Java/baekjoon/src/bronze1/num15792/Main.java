package bronze1.num15792;

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
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 제수와 피제수를 각 변수에 할당
		int dividend = Integer.parseInt(st.nextToken());
		int divisor = Integer.parseInt(st.nextToken());
		
		// append() 메서드를 사용해 나눗셈 결과의 정수부를 계산하고 이를 sb에 추가
		sb.append(dividend / divisor);
		
		// 나눗셈 결과의 소수부가 존재하는 경우
		if (dividend % divisor != 0) {
			
			// append() 메서드를 사용해 소숫점을 추가
			sb.append(".");
		
			// 나눗셈을 진행할 횟수를 저장할 변수 count 초기화
			int count = 0;
			
			// while 반복문을 사용해 나눗셈을 모두 진행할 때까지 순회
			while (count <= 1000) {
			
				// 제수를 갱신
				dividend = 10 * (dividend % divisor);
				
				// append() 메서드를 사용해 나눗셈의 결과를 갱신
				sb.append(dividend / divisor);
				
				// 나누어 떨어진 경우 반복문 탈출
				if (dividend % divisor == 0)
					break;
				
				// 나눗셈을 진행한 횟수 갱신
				count++;
			}
		}
		
		// toString() 및 write() 메서드를 사용해 나눗셈의 결과를 출력
		out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}