package bronze2.num01225;

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
		
		// nextToken() 메서드를 사용해 입력 받은 두 숫자를 각 변수에 할당
		String numberA = st.nextToken();
		String numberB = st.nextToken();
		
		// 형택이의 곱셈 결과를 저장할 변수 result 초기화
		long result = 0;
		
		// for 반복문을 사용해 한 숫자의 각 자리를 순회
		for (int idxA = 0; idxA < numberA.length(); idxA++) {
			
			// for 반복문을 사용해 다른 숫자의 각 자리를 순회
			for (int idxB = 0; idxB < numberB.length(); idxB++) {
				
				// charAt() 메서드를 사용해 각 자리 숫자를 각 변수에 할당
				int digitA = numberA.charAt(idxA) - '0';
				int digitB = numberB.charAt(idxB) - '0';
				
				// 형택이의 곱셈 결과를 갱신
				result += digitA * digitB;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 형택이의 곱셈 결과를 출력
		out.write(String.valueOf(result));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}