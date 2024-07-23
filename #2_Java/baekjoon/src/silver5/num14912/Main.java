package silver5.num14912;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자의 범위와 빈도수를 구할 숫자를 각 변수에 할당
		int number = Integer.parseInt(st.nextToken());
		int targetDigit = Integer.parseInt(st.nextToken());
		
		// 특정 숫자의 빈도수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 각 숫자를 순회
		for (int n = 1; n <= number; n++) {
			
			// valueOf() 및 toCharArray() 메서드를 사용해 해당 숫자의 각 자릿수를 저장할 배열 digits 초기화
			char[] digits = String.valueOf(n).toCharArray();
			
			// for 반복문을 사용해 각 자릿수를 순회
			for (int idx = 0; idx < digits.length; idx++) {
				
				// 해당 자릿수가 빈도수를 구할 숫자인 경우 빈도수를 갱신
				if (digits[idx] - '0' == targetDigit)
					count++;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 특정 숫자의 빈도수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}