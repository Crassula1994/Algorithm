package bronze2.num01871;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;  
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 알파벳 자릿수에 곱할 26진법 수를 저장할 배열 radixValue 초기화
	static int[] radixValue = {26 * 26, 26, 1};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 번호판의 수를 변수 plateNum에 할당
		int plateNum = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 번호판을 순회
		while (plateNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine(), "-");
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 번호판의 각 부분을 각 변수에 할당
			String letterPart = st.nextToken();
			int numberPart = Integer.parseInt(st.nextToken());
			
			// 첫 번째 부분의 가치를 저장할 변수 letterValue 초기화
			int letterValue = 0;
			
			// for 반복문을 사용해 첫 번째 부분의 각 알파벳을 순회
			for (int idx = 0; idx < letterPart.length(); idx++) {
				
				// charAt() 메서드를 사용해 해당 부분의 자릿수를 변수 digit에 할당
				int digit = letterPart.charAt(idx) - 'A';
				
				// 첫 번째 부분의 가치를 갱신
				letterValue += digit * radixValue[idx];
			}
			
			// abs() 및 write() 메서드를 사용해 해당 자동차 번호판이 좋은 번호판인지 여부를 출력
			out.write((Math.abs(letterValue - numberPart) > 100) ? "not nice" : "nice");
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
				
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}