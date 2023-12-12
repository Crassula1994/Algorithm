package bronze1.num09933;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

// Main 클래스 정의
public class Main {

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 단어의 수를 변수 wordNum에 할당
		int wordNum = Integer.parseInt(in.readLine());
		
		// 각 단어를 저장할 Set 객체 words 초기화
		Set<String> words = new HashSet<>();
		
		// for 반복문을 사용해 각 단어를 순회
		for (int w = 0; w < wordNum; w++) {
			
			// readLine() 메서드를 사용해 입력 받은 단어를 변수 word에 할당
			String word = in.readLine();
			
			// reverse() 및 toString() 메서드를 사용해 뒤집은 단어를 변수 reversedWord에 할당
			String reversedWord = new StringBuilder(word).reverse().toString();
			
			// 뒤집은 단어가 words에 저장되어 있거나, 회문인 경우
			if (words.contains(reversedWord) || word.equals(reversedWord)) {
				
				// length(), charAt(), write() 메서드를 사용해 비밀번호의 길이와 가운데 글자를 출력
				out.write(word.length() + " " + word.charAt(word.length() / 2));
				
				// 반복문 탈출
				break;
				
			// 뒤집은 단어가 words에 저장되어 있지 않고, 회문도 아닌 경우 words에 해단 단어를 추가
			} else {
				words.add(word);
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}