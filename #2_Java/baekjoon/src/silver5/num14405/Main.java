package silver5.num14405;

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
		
		// readLine() 메서드를 사용해 입력 받은 문자열을 변수 word에 할당
		String word = in.readLine();
		
		// 해당 문자열을 피카츄가 발음할 수 있는지, 현재 문자열의 인덱스를 나타내는 각 변수 초기화
		boolean canSpeak = true;
		int index = 0;
		
		// while 반복문을 사용해 입력 받은 문자열의 각 글자를 차례로 순회
		while (index < word.length()) {

			// 세 글자 이상 남은 경우
			if (index < word.length() - 2) {
				
				// substring() 메서드를 사용해 두 글자 및 세 글자 문자열을 할당
				String twoLetters = word.substring(index, index + 2);
				String threeLetters = word.substring(index, index + 3);
				
				// 두 글자 문자열이 'pi', 'ka' 중 하나인 경우 인덱스 갱신
				if (twoLetters.equals("pi") || twoLetters.equals("ka")) {
					index += 2;
				
				// 세 글자 문자열이 'chu'인 경우 인덱스 갱신
				} else if (threeLetters.equals("chu")) {
					index += 3;
				
				// 피카츄가 발음할 수 없는 경우 변수 갱신 후 반복문 탈출
				} else {
					canSpeak = false;
					break;
				}
				
			// 두 글자만 남은 경우
			} else if (index == word.length() - 2) {
				
				// substring() 메서드를 사용해 두 글자 문자열을 할당
				String twoLetters = word.substring(index, index + 2);
				
				// 두 글자 문자열이 'pi', 'ka' 중 하나인 경우
				if (twoLetters.equals("pi") || twoLetters.equals("ka")) {
					index += 2;
					
				// 피카츄가 발음할 수 없는 경우 변수 갱신 후 반복문 탈출
				} else {
					canSpeak = false;
					break;
				}
				
			// 한글자만 남은 경우 피카츄가 발음할 수 없으므로 변수 갱신 후 반복문 탈출
			} else {
				canSpeak = false;
				break;
			}
		}
		
		// 해당 문자열을 피카츄가 발음할 수 있는 경우 'YES' 출력
		if (canSpeak) {
			out.write("YES");
			
		// 해당 문자열을 피카츄가 발음할 수 없는 경우 'NO' 출력
		} else {
			out.write("NO");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}