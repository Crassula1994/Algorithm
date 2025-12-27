package bronze3.num05692;

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
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// readLine() 메서드를 사용해 입력 받은 팩토리얼 진법 숫자를 변수 numberString에 할당
			String numberString = in.readLine();
			
			// 모든 테스트 케이스를 확인한 경우 반복문 탈출
			if (numberString.equals("0"))
				break;
			
			// 팩토리얼 진법 숫자를 10진법 숫자로 읽은 값을 저장할 변수 result 초기화
			int result = 0;
			
			// length() 메서드를 사용해 해당 팩토리얼 진법의 자릿수를 변수 length에 할당
			int length = numberString.length();
			
			// for 반복문을 사용해 각 자릿수를 순회
			for (int idx = length - 1, multiplier = 1; idx >= 0; idx--) {
				
				// 해당 자릿수의 팩토리얼 값을 갱신
				multiplier *= length - idx;
				
				// charAt() 메서드를 사용해 팩토리얼 진법 숫자를 10진법 숫자로 읽은 값을 갱신
				result += (numberString.charAt(idx) - '0') * multiplier;
			}
			
			// append() 메서드를 사용해 팩토리얼 진법 숫자를 10진법 숫자로 읽은 값을 sb에 추가
			sb.append(result).append("\n");
		}
		
		// toString() 및 write() 메서드를 사용해 각 테스트 케이스의 팩토리얼 진법 숫자를 10진법으로 읽은 값을 출력
		out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}