package bronze4.num15873;

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
		
		// readLine() 메서드를 사용해 입력 받은 두 자연수를 변수 numbers에 할당
		String numbers = in.readLine();
		
		// 두 수의 합을 저장할 변수 sum 초기화
		int sum = 0;
		
		// for 반복문을 사용해 각 자릿수를 순회
		for (int idx = 0; idx < numbers.length(); idx++) {
			
			// charAt() 메서드를 사용해 해당 자릿수를 변수 cipher에 할당
			int cipher = numbers.charAt(idx) - '0';
			
			// 해당 자릿수가 0인 경우 10을 더한 것으로 처리
			if (cipher == 0) {
				sum += 9;
				
			// 해당 자릿수가 0이 아닌 경우 해당 자릿수를 더한 것으로 처리
			} else {
				sum += cipher;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 두 수의 합을 출력
		out.write(String.valueOf(sum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}