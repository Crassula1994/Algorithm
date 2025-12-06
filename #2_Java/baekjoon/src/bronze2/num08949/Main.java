package bronze2.num08949;

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
		
		// nextToken() 메서드를 사용해 입력 받은 두 정수를 각 변수에 할당
		String numberA = st.nextToken();
		String numberB = st.nextToken();
		
		// length(), max(), abs() 메서드를 사용해 두 정수의 자릿수 중 더 많은 자릿수와 자릿수의 차이를 각 변수에 할당
		int maxLength = Math.max(numberA.length(), numberB.length());
		int difference = Math.abs(numberA.length() - numberB.length());
		
		// for 반복문을 사용해 각 자릿수를 순회
		for (int idx = 0; idx < maxLength; idx++) {
			
			// length() 및 charAt() 메서드를 사용해 해당 자릿수에서 두 정수의 숫자를 각 변수에 할당
			int digitA = (numberA.length() < maxLength) ? (idx < difference) ?
					0 : numberA.charAt(idx - difference) - '0' : numberA.charAt(idx) - '0';
			int digitB = (numberB.length() < maxLength) ? (idx < difference) ?
					0 : numberB.charAt(idx - difference) - '0' : numberB.charAt(idx) - '0';
			
			// valueOf() 및 write() 메서드를 사용해 해당 자릿수의 합을 출력
			out.write(String.valueOf(digitA + digitB));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}