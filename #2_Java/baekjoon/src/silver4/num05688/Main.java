package silver4.num05688;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 각 숫자에 대응하는 브라유 점자를 저장할 2차원 배열 brailles 초기화
		String[][] brailles = {
			{".*", "*.", "*.", "**", "**", "*.", "**", "**", "*.", ".*"},
			{"**", "..", "*.", "..", ".*", ".*", "*.", "**", "**", "*."},
			{"..", "..", "..", "..", "..", "..", "..", "..", "..", ".."}
		};
		
		// 각 브라유 점자에 대응하는 숫자를 저장할 Map 객체 numbers 초기화
		Map<String, Integer> numbers = new HashMap<>();
		
		// 변환 결과를 저장할 StringBuilder 객체 sb 초기화
		StringBuilder sb = new StringBuilder();
		
		// for 반복문을 사용해 각 브라유 점자와 그에 대응하는 숫자를 numbers에 저장
		for (int idx = 0; idx < 10; idx++)
			numbers.put(brailles[0][idx] + brailles[1][idx] + brailles[2][idx], idx);

		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// readLine() 및 parseInt() 메서드를 사용해 메시지에 포함된 숫자의 자릿수를 변수 digitNum에 할당
			int digitNum = Integer.parseInt(in.readLine());
			
			// 숫자의 자릿수가 0인 경우 반복문 탈출
			if (digitNum == 0)
				break;
			
			// readLine() 및 charAt() 메서드를 사용해 변환할 숫자의 종류를 변수 category에 할당
			char category = in.readLine().charAt(0);
			
			// 변환할 숫자가 일반 정수인 경우
			if (category == 'S') {
				
				// readLine() 메서드를 사용해 입력 받은 숫자 문자열을 변수 numString에 할당
				String numString = in.readLine();
				
				// for 반복문을 사용해 각 줄을 순회
				for (int line = 0; line < 3; line++) {
					
					// for 반복문을 사용해 각 숫자에 해당하는 브라유 점자를 sb에 추가
					for (int idx = 0; idx < digitNum; idx++)
						sb.append(brailles[line][numString.charAt(idx) - '0']).append(" ");
					
					// append() 메서드를 사용해 줄바꿈을 sb에 추가
					sb.append("\n");
				}
				
			// 변환할 숫자가 브라유 점자 정수인 경우
			} else {
				
				// StringTokenizer 객체를 불러와 각 변수에 할당
				StringTokenizer firstLine = new StringTokenizer(in.readLine());
				StringTokenizer secondLine = new StringTokenizer(in.readLine());
				StringTokenizer thirdLine = new StringTokenizer(in.readLine());
				
				// for 반복문을 사용해 각 브라유 점자를 순회
				for (int idx = 0; idx < digitNum; idx++) {
					
					// 해당 브라유 점자를 저장할 StringBuilder 객체 braille 초기화
					StringBuilder braille = new StringBuilder();
					
					// nextToken() 및 append() 메서드를 사용해 해당 브라유 점자를 braille에 저장
					braille.append(firstLine.nextToken());
					braille.append(secondLine.nextToken());
					braille.append(thirdLine.nextToken());
					
					// toString(), get(), append() 메서드를 사용해 해당 숫자를 sb에 추가
					sb.append(numbers.get(braille.toString()));
				}
				
				// append() 메서드를 사용해 줄바꿈을 sb에 추가
				sb.append("\n");
			}
		}
		
		// toString() 및 write() 메서드를 사용해 변환 결과를 출력
		out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}