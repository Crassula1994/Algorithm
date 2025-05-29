package bronze2.num02954;

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
	
	// 모음인 알파벳을 저장할 Set 객체 vowels 초기화
	static Set<Character> vowels = new HashSet<>();
	
	// add() 메서드를 사용해 모음을 vowels에 추가
	static {
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 창영이가 일기장에 작성한 문장을 배열 setnence에 저장
		char[] sentence = in.readLine().toCharArray();
		
		// for 반복문을 사용해 문장의 각 글자를 순회
		for (int idx = 0; idx < sentence.length; idx++) {
			
			// write() 메서드를 사용해 해당 글자를 출력
			out.write(sentence[idx]);
			
			// 해당 글자가 모음인 경우 두 글자 뒤를 순회
			if (vowels.contains(sentence[idx]))
				idx += 2;
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}