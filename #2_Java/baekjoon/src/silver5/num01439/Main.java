package silver5.num01439;

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

		// readLine() 메서드를 사용해 입력 받은 문자열을 변수 string에 할당
		String string = in.readLine();
		
		// 연속된 '0'과 '1'의 개수를 저장할 배열 counter 초기화
		int[] counter = new int[2];
		
		// 첫 번째 숫자가 0인 경우 연속된 '0'의 개수 갱신
		if (string.charAt(0) == '0') {
			counter[0]++;
			
		// 첫 번째 숫자가 1인 경우 연속된 '1'의 개수 갱신
		} else {
			counter[1]++;
		}
		
		// for 반복문을 사용해 각 숫자를 순회
		for (int idx = 1; idx < string.length(); idx++) {
			
			// charAt() 메서드를 사용해 해당 숫자를 변수 number에 할당
			char number = string.charAt(idx);
			
			// 이전 자리 숫자와 다른 경우 연속된 해당 숫자의 개수 갱신
			if (number != string.charAt(idx - 1))
				counter[number - '0']++;
		}

		// min(), valueOf(), write() 메서드를 사용해 다솜이가 해야 하는 행동의 최소 횟수를 출력
		out.write(String.valueOf(Math.min(counter[0], counter[1])));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}