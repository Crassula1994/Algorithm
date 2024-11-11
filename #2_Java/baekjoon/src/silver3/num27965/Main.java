package silver3.num27965;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 N결수와 제수를 각 변수에 할당
		int linkCount = Integer.parseInt(st.nextToken());
		int divisor = Integer.parseInt(st.nextToken());
		
		// N결수를 제수로 나눈 결과를 저장할 변수 linkNumber 초기화
		long linkNumber = 0;
		
		// for 반복문을 사용해 N결수의 각 숫자를 순회
		for (int number = 1, multiplier = 10; number <= linkCount; number++) {
			
			// 자릿수가 증가한 경우 곱하는 10의 배수를 갱신
			if (number == multiplier)
				multiplier *= 10;
			
			// N결수를 제수로 나눈 결과를 갱신
			linkNumber *= multiplier;
			linkNumber += number;
			linkNumber %= divisor;
		}
		
		// valueOf() 및 write() 메서드를 사용해 N결수를 제수로 나눈 결과를 출력
		out.write(String.valueOf(linkNumber));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}