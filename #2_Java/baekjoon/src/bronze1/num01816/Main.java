package bronze1.num01816;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수의 개수를 변수 numberCnt에 할당
		int numberCnt = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 숫자를 순회
		while (numberCnt-- > 0) {
			
			// readLine() 및 parseLong() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
			long number = Long.parseLong(in.readLine());
			
			// 해당 숫자가 적절한 암호 키인지 여부를 나타낼 변수 isSecure 초기화
			boolean isSecure = true;
			
			// for 반복문을 사용해 각 인수를 순회
			for (int factor = 2; factor <= 1000000; factor++) {
				
				// 입력 받은 숫자가 해당 인수로 나누어 떨어지는 경우 적절한 암호 키인지 여부를 갱신 후 반복문 탈출
				if (number % factor == 0) {
					isSecure = false;
					break;
				}
			}
			
			// write() 메서드를 사용해 해당 숫자가 적절한 암호 키인지 여부를 출력
			out.write((isSecure) ? "YES" : "NO");
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}