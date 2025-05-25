package bronze1.num04539;

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
			
			// readLine() 메서드를 사용해 입력 받은 숫자를 변수 numberString에 할당
			String numberString = in.readLine();
			
			// length() 메서드를 사용해 해당 숫자의 자릿수를 변수 length에 할당
			int length = numberString.length();
			
			// 해당 숫자의 각 자릿수를 배열 digits에 저장
			int[] digits = new int[length];
			
			// for 반복문을 사용해 각 자릿수를 배열 digits에 저장
			for (int idx = 0; idx < digits.length; idx++)
				digits[idx] = numberString.charAt(idx) - '0';
			
			// for 반복문을 사용해 각 자릿수를 순회
			for (int idx = length - 1; idx > 0; idx--) {
				
				// 해당 자릿수가 5 이상인 경우 올림 처리
				if (digits[idx] >= 5)
					digits[idx - 1] += 1;
				
				// 해당 자릿수를 0으로 갱신
				digits[idx] = 0;
			}
			
			// for 반복문을 사용해 각 자릿수를 출력
			for (int digit : digits)
				out.write(String.valueOf(digit));
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}