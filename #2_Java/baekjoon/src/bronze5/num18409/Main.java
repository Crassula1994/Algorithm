package bronze5.num18409;

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
	
	// 모음을 저장할 Set 객체 vowels 초기화
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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 문자열의 길이 및 문자열을 각 변수에 할당
		int length = Integer.parseInt(in.readLine());
		String string = in.readLine();
		
		// 모음의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 각 문자열의 글자를 순회
		for (int idx = 0; idx < length; idx++) {
			
			// charAt() 메서드를 사용해 해당 글자를 변수 character에 할당
			char character = string.charAt(idx);
			
			// 해당 글자가 모음인 경우 모음의 개수를 갱신
			if (vowels.contains(character))
				count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 모음의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}