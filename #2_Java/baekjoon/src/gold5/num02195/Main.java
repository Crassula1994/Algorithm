package gold5.num02195;

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
		
		// readLine() 메서드를 사용해 입력 받은 원본 문자열과 복사하여 만들 문자열을 각 변수에 할당
		String originString = in.readLine();
		String targetString = in.readLine();
		
		// 필요한 copy 함수의 최소 사용횟수를 저장할 변수 minCount 초기화
		int minCount = 0;
		
		// for 반복문을 사용해 복사하여 만들 문자열의 각 글자를 순회
		for (int targetIdx = 0; targetIdx < targetString.length();) {
			
			// 현재 복사하여 만들 문자열의 글자부터 시작해 최대로 일치하는 부분 문자열의 길이를 저장할 변수 maxLength 초기화
			int maxLength = 0;
			
			// for 반복문을 사용해 원본 문자열의 각 글자를 순회
			for (int originIdx = 0; originIdx < originString.length(); originIdx++) {
				
				// 만들 수 있는 부분 문자열의 길이가 최대로 일치하는 부분 문자열의 길이와 같거나 짧은 경우 반복문 탈출
				if (originIdx >= originString.length() - maxLength)
					break;
				
				// 현재 위치부터 시작해 일치하는 부분 문자열의 길이를 저장할 변수 length 초기화
				int length = 0;
				
				// while 반복문을 사용해 만들 수 있는 최대 길이의 부분 문자열까지 순회
				while (originIdx + length < originString.length() && targetIdx + length < targetString.length()) {
					
					// 원본 문자열과 복사하여 만들 문자열의 글자가 다른 경우 반복문 탈출
					if (originString.charAt(originIdx + length) != targetString.charAt(targetIdx + length))
						break;
					
					// 현재 위치부터 시작해 일치하는 부분 문자열의 길이를 갱신
					length++;
				}
				
				// max() 메서드를 사용해 최대로 일치하는 부분 문자열의 길이을 갱신
				maxLength = Math.max(length, maxLength);
			}
			
			// 복사하여 만들 문자열의 글자 및 필요한 copy 함수의 최소 사용횟수를 갱신
			targetIdx += maxLength;
			minCount++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 필요한 copy 함수의 최소 사용횟수를 출력
		out.write(String.valueOf(minCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}