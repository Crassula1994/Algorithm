package bronze5.num02744;

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
		
		// readLine() 및 toCharArray() 메서드를 사용해 입력 단어를 배열 characterArray에 저장
		char[] characterArray = in.readLine().toCharArray();
		
		// for 반복문을 사용해 characterArray 배열의 각 원소를 순회
		for (char character : characterArray) {

			// 대문자인 경우 소문자로 변환
			if (character - 'a' < 0) {
				character += 32;

			// 소문자인 경우 대문자로 변환
			} else {
				character -= 32;
			}
			
			// write() 메서드를 사용해 문자를 출력
			out.write(character);
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}