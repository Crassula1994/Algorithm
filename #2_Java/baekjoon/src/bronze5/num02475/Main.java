package bronze5.num02475;

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
		
		// 제곱합을 저장할 변수 sumOfSquares 초기화
		int sumOfSquares = 0;
		
		// for 반복문을 사용해 각 다섯 자리의 숫자를 순회
		for (int i = 0; i < 5; i++) {
			
			// nextToken() 및 parseInt 메서드를 사용해 입력된 숫자를 변수 number에 저장
			int number = Integer.parseInt(st.nextToken());
			
			// 제곱합의 결과를 갱신
			sumOfSquares += number * number;
		}
		
		// 검증수를 계산해 변수 verificationNum에 할당
		int verificationNum = sumOfSquares % 10;
		
		// valueOf() 및 write() 메서드를 사용해 검증수를 출력
		out.write(String.valueOf(verificationNum));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}