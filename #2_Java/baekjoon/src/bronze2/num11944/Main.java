package bronze2.num11944;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 출력 횟수 및 출력할 최대 자릿수를 저장할 각 변수 초기화
		int outputCount = Integer.parseInt(st.nextToken());
		int maxDigit = Integer.parseInt(st.nextToken());
		
		// valueOf() 메서드를 사용해 출력할 문자열을 변수 number에 할당
		String number = String.valueOf(outputCount);
		
		// while 반복문을 사용해 출력할 문자열을 출력 횟수 또는 최대 자릿수만큼 출력할 때까지 순회
		while (outputCount-- > 0 && maxDigit > 0) {
			
			// 최대 자릿수 이하에서 출력할 문자열을 모두 출력할 수 있는 경우 해당 문자열을 출력
			if (maxDigit - number.length() >= 0) {
				out.write(number);
			
			// 최대 자릿수를 넘어서서 출력할 문자열을 모두 출력할 수 없는 경우 출력할 수 있는 부분 문자열만 출력
			} else {
				out.write(number.substring(0, maxDigit));
			}
			
			// length() 메서드를 사용해 출력할 최대 자릿수를 갱신
			maxDigit -= number.length();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}