package bronze2.num02789;

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
		
		// readLine() 메서드를 사용해 입력 받은 단어를 변수 word에 할당
		String word = in.readLine();
		
		// 검열할 단어를 변수 university에 할당
		String university = "CAMBRIDGE";
		
		// 검열할 알파벳을 저장할 Set 객체 alphabets 초기화
		Set<Character> alphabets = new HashSet<>();
		
		// for 반복문을 사용해 검열할 단어의 알파벳을 alphabets에 추가
		for (int idx = 0; idx < university.length(); idx++)
			alphabets.add(university.charAt(idx));
		
		// for 반복문을 사용해 입력 받은 단어의 각 알파벳을 순회
		for (int idx = 0; idx < word.length(); idx++) {
			
			// charAt() 메서드를 사용해 해당 알파벳을 변수 alphabet에 할당
			char alphabet = word.charAt(idx);
			
			// 해당 알파벳이 검열할 알파벳인 경우 다음 알파벳을 순회
			if (alphabets.contains(alphabet))
				continue;
			
			// write() 메서드를 사용해 해당 알파벳을 출력
			out.write(alphabet);
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}