package bronze1.num16360;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 영어 단어의 개수를 변수 wordNum에 할당
		int wordNum = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 영어 단어를 순회
		while (wordNum-- > 0) {
			
			// readLine() 메서드를 사용해 입력 받은 영어 단어를 변수 word에 할당
			String word = in.readLine();
			
			// pseudoLatinMaker() 및 write() 메서드를 사용해 해당 영어 단어를 의사-라틴어로 바꾼 결과를 출력
			out.write(pseudoLatinMaker(word));
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// pseudoLatinMaker() 메서드 정의
	public static String pseudoLatinMaker(String word) {
		
		// lengh() 메서드를 사용해 해당 영어 단어의 길이를 변수 length에 할당
		int length = word.length();
		
		// 단어가 'ne'로 끝나는 경우 의사-라틴어로 바꾼 결과를 반환
		if (word.endsWith("ne"))
			return word.substring(0, length - 2) + "anes";
		
		// charAt() 메서드를 사용해 입력 받은 단어의 마지막 글자를 변수 lastLetter에 할당
		char lastLetter = word.charAt(length - 1);
		
		// switch 조건문을 사용해 각 영어 단어를 의사-라틴어로 바꾼 결과를 반환
		switch (lastLetter) {
			case 'a':
			case 'o':
			case 'u':
				return word + "s";
			case 'i':
			case 'y':
				return word.substring(0, length - 1) + "ios";
			case 'l':
			case 'r':
			case 'v':
				return word + "es";
			case 'n':
				return word.substring(0, length - 1) + "anes";
			case 't':
			case 'w':
				return word + "as";
			default:
				return word + "us";
		}
	}
}