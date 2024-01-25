package bronze1.num02033;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 메서드를 사용해 입력 받은 숫자를 변수 numStr에 할당
		String numStr = in.readLine();
		
		// 한 자리인 경우 해당 숫자를 그대로 출력
		if (numStr.length() < 2) {
			out.write(numStr);
			
		// 두 자리 이상인 경우
		} else {
			
			// parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
			int number = Integer.parseInt(numStr);
			
			// for 반복문을 사용해 각 자릿수만큼의 반올림을 순회
			for (int idx = 0; idx < numStr.length() - 1; idx++) {
				
				// 해당 숫자를 10으로 나눈 나머지를 변수 remains에 할당
				int remains = number % 10;
				
				// 나머지가 5 이상인 경우 올림한 것으로 처리
				if (remains >= 5) {
					number += 10 - remains;
					
				// 나머지가 5 미만인 경우 내림한 것으로 처리
				} else {
					number -= remains;
				}
				
				// 해당 숫자를 갱신
				number /= 10;
			}
			
			// valueOf() 및 write() 메서드를 사용해 가장 최상위 숫자를 출력
			out.write(String.valueOf(number));
			
			// for 반복문을 사용해 남은 자리만큼의 0을 출력
			for (int idx = 0; idx < numStr.length() - 1; idx++)
				out.write(String.valueOf(0));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}