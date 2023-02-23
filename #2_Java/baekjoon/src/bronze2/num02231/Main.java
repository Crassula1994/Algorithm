package bronze2.num02231;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 targetNum에 할당
		int targetNum = Integer.parseInt(in.readLine()); 
		
		// for 반복문을 사용해 targetNum까지의 수를 순회
		for (int num = 1; num < targetNum + 1; num++) {
			
			// valueOf() 메서드를 사용해 해당 숫자를 문자열로 변환해 numString에 저장 
			String numString = String.valueOf(num);
			
			// 각 숫자의 자릿수를 담은 배열 numbers 초기화
			char[] numbers = numString.toCharArray();
			
			// 분해합의 결과를 저장할 변수 sum 초기화
			int sum = num;
			
			// for 반복문을 사용해 각 자릿수의 분해합을 도출
			for (int idx = 0; idx < numbers.length; idx++)
				sum += numbers[idx] - '0';
			
			// 해당 결과가 입력 받은 숫자의 생성자인 경우
			if (sum == targetNum) {
				
				// 	valueOf() 및 write() 메서드를 사용해 생성자 출력
				out.write(String.valueOf(num));
				
				// 반복문 탈출
				break;
			}
			
			// 생성자가 없는 경우 0 출력
			if (num == targetNum)
				out.write(String.valueOf(0));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}