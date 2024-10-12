package silver3.num04626;

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
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 1; tc <= testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 유리수의 분자와 분모, 구해야 하는 수의 범위를 각 변수에 할당
			int numerator = Integer.parseInt(st.nextToken());
			int denominator = Integer.parseInt(st.nextToken());
			int beginDigit = Integer.parseInt(st.nextToken());
			int endDigit = Integer.parseInt(st.nextToken());
			
			// write() 메서드를 사용해 테스트 케이스의 번호 및 주어진 값을 정해진 양식으로 출력
			out.write("Problem set " + tc + ": " + numerator + " / " + denominator + ", base 7 digits " + beginDigit
					+ " through " + endDigit + ": ");
			
			// 분자를 분모로 나눈 나머지 값으로 분자를 갱신
			numerator %= denominator;
			
			// for 반복문을 사용해 각 소수점 자릿수를 순회
			for (int digit = 0; digit <= endDigit; digit++) {
				
				// 7진법이므로 분자에 7을 곱해 자릿수를 이동
				numerator *= 7;
				
				// 해당 자릿수를 출력해야 하는 경우 해당 자릿수를 출력
				if (digit >= beginDigit)
					out.write(String.valueOf(numerator / denominator));
				
				// 분자를 분모로 나눈 나머지 값으로 분자를 갱신
	            numerator %= denominator;
	        }
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}