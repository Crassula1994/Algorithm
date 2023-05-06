package silver5.num01312;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 피제수, 제수, 소수점의 자릿수를 각 변수에 할당
		int dividend = Integer.parseInt(st.nextToken());
		int divisor = Integer.parseInt(st.nextToken());
		int decimalPos = Integer.parseInt(st.nextToken());
		
		// 나눗셈 연산 후 나머지를 변수 remain에 할당
		int remain = dividend % divisor;
		
		// for 반복문을 사용해 각 소숫점 자릿수를 순회
		for (int pos = 1; pos <= decimalPos; pos++) {
			
			// 다음 자릿수 계산을 위해 나머지를 갱신
			remain *= 10;
			
			// 소수점의 자릿수를 계산
			remain = (pos == decimalPos) ? remain / divisor : remain % divisor;
			
			// 나머지가 0인 경우 반복문 탈출
			if (remain == 0)
				break;
		}

		// valueOf() 및 write() 메서드를 사용해 소숫점 아래 특정 자릿수를 출력
		out.write(String.valueOf(remain));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}