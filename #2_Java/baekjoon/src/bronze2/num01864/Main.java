package bronze2.num01864;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

// Main 클래스 정의
public class Main {

	// 문어가 사용하는 기호를 저장할 Map 객체 symbols 초기화
	static Map<Character, Integer> symbols = new HashMap<>();
	
	// put() 메서드를 사용해 문어가 사용하는 기호를 symbols에 저장
	static {
		symbols.put('-', 0);
     	symbols.put('\\', 1);
     	symbols.put('(', 2);
     	symbols.put('@', 3);
     	symbols.put('?', 4);
     	symbols.put('>', 5);
     	symbols.put('&', 6);
     	symbols.put('%', 7);
     	symbols.put('/', -1);
     }
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// while 반복문을 사용해 각 기호를 순회
		while (true) {

			// readLine() 메서드를 사용해 입력 받은 문어 숫자 기호를 변수 symbolString에 할당
			String symbolString = in.readLine();

			// 모든 기호를 순회한 경우 반복문 탈출
			if (symbolString.equals("#"))
				break;

			// 문어 숫자 기호에 대응하는 십진수를 저장할 변수 number 초기화
			int number = 0;

			// for 반복문을 사용해 각 자릿수를 거꾸로 순회
			for (int idx = symbolString.length() - 1, multiplier = 1; idx >= 0; idx--) {

				// charAt() 및 get() 메서드를 사용해 해당 자릿수의 값을 변수 digit에 할당
				int digit = symbols.get(symbolString.charAt(idx));

				// 문어 숫자 기호에 대응하는 십진수와 다음 자릿수가 나타내는 값을 갱신
				number += digit * multiplier;
				multiplier *= 8;
			}

			// write() 메서드를 사용해 문어 숫자 기호에 대응하는 십진수를 출력
			out.write(number + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}