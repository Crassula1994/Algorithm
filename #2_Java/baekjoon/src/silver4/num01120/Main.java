package silver4.num01120;

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
		
		// nextToken() 메서드를 사용해 입력 받은 두 문자열을 각 변수에 할당
		String stringA = st.nextToken();
		String stringB = st.nextToken();
		
		// 문자열의 최소 차이를 저장할 변수 minDifference 초기화
		int minDifference = Integer.MAX_VALUE;
		
		// for 반복문을 사용해 B 문자열의 각 부분 문자열을 순회
		for (int i = 0; i < stringB.length() - stringA.length() + 1; i++) {
			
			// 문자열의 차이를 저장할 변수 difference 초기화
			int difference = 0;
			
			// for 반복문을 사용해 부분 문자열의 각 위치를 순회
			for (int j = i; j < i + stringA.length(); j++) {
				
				// charAt() 메서드를 사용해 두 문자열의 글자를 각 변수에 할당
				char charA = stringA.charAt(j - i);
				char charB = stringB.charAt(j);
				
				// 두 문자열의 글자가 다른 경우 문자열의 차이를 갱신
				if (charA != charB)
					difference++;
			}
			
			// min() 메서드를 사용해 문자열의 최소 차이를 갱신
			minDifference = Math.min(difference, minDifference);
		}
		
		// valueOf() 및 write() 메서드를 사용해 A와 B의 최소 차이를 출력
		out.write(String.valueOf(minDifference));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}