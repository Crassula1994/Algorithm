package bronze2.num02908;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 각 변수에 저장
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		
		// 뒤집은 숫자를 저장할 각 변수 초기화
		int reverseNum1 = 0;
		int reverseNum2 = 0;		

		// for 반복문을 사용해 각 숫자의 자릿수를 바꿔 저장
		for (int i = 0; i < 3; i++) {
			reverseNum1 = reverseNum1 * 10 + num1 % 10;
			reverseNum2 = reverseNum2 * 10 + num2 % 10;
			num1 = num1 / 10;
			num2 = num2 / 10;
		}
		
		// max(), valueOf(), write() 메서드를 사용해 뒤집은 수 중 더 큰 수를 출력
		out.write(String.valueOf(Math.max(reverseNum1, reverseNum2)));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}