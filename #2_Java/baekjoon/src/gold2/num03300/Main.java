package gold2.num03300;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Pattern;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// readLine() 메서드를 사용해 입력 받은 직병렬 무어 기계와 그 출력을 각 변수에 할당
			String machine = in.readLine();
			String output = in.readLine();
			
			// 각 테스트 케이스에서 지워진 심볼이 될 수 있는 값의 개수와 지워진 심볼을 저장할 각 변수 초기화
			int symbolCount = 0;
			char symbol = '_';
			
			// for 반복문을 사용해 각 알파벳을 순회
			for (int order = 0; order < 26; order++) {
				
				// 해당 알파벳을 변수 alphabet에 할당
				char alphabet = (char) ('A' + order);
				
				// replace() 메서드를 사용해 지워진 심볼을 해당 알파벳으로 대체한 무어 기계를 변수 candidate에 할당
				String candidate = machine.replace('_', alphabet);
				
				// 해당 알파벳으로 대체한 무어 기계와 그 출력이 일치하는 경우 심볼이 될 수 있는 값의 개수와 지워진 심볼을 갱신
				if (Pattern.matches(candidate, output)) {
					symbolCount++;
					symbol = alphabet;
				}
			}
			
			// 주어진 기계에서 출력을 만들 수 없는 경우 '!'를 출력
			if (symbolCount == 0) {
				out.write("!");
				
			// 주어진 기계에서 지워진 심볼을 유일하게 결정할 수 없는 경우 '_'를 출력
			} else if (symbolCount > 1) {
				out.write("_");
				
			// 주어진 기계에서 지워진 심볼을 유일하게 결정할 수 있는 경우 지워진 심볼을 출력
			} else {
				out.write(symbol);
			}
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}