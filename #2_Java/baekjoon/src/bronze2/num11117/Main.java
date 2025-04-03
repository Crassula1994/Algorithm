package bronze2.num11117;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 쿠키 박스의 개수를 변수 cookieBoxNum에 할당
		int cookieBoxNum = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 쿠키 박스를 순회
		while (cookieBoxNum-- > 0) {
			
			// readLine() 메서드를 사용해 입력 받은 쿠키 박스에 존재하는 모든 글자를 변수 cookieBox에 할당
			String cookieBox = in.readLine();
			
			// 각 글자의 쿠키 개수를 저장할 배열 letterLimits 초기화
			int[] letterLimits = new int[26];
			
			// for 반복문을 사용해 각 글자의 쿠키 개수를 갱신
			for (int idx = 0; idx < cookieBox.length(); idx++)
				letterLimits[cookieBox.charAt(idx) - 'A']++;
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 만들고자 하는 단어의 수를 변수 wordNum에 할당
			int wordNum = Integer.parseInt(in.readLine());
			
			// while 반복문을 사용해 각 단어를 순회
			while (wordNum-- > 0) {
				
				// readLine(), clone(), spellChecker(), write() 메서드를 사용해 해당 단어를 만들 수 있는지 여부를 출력
				out.write(spellChecker(in.readLine(), letterLimits.clone()));
				
				// newLine() 메서드를 사용해 줄바꿈을 출력
				out.newLine();
			}
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// spellChecker() 메서드 정의
	public static String spellChecker(String word, int[] letterLimits) {
		
		// for 반복문을 사용해 해당 단어의 각 글자를 순회
		for (int idx = 0; idx < word.length(); idx++) {
			
			// charAt() 메서드를 사용해 해당 글자의 순서를 변수 order에 할당
			int order = word.charAt(idx) - 'A';
			
			// 해당 글자를 만들기 위한 쿠키가 부족한 경우 'NO'를 반환
			if (letterLimits[order] == 0)
				return "NO";
			
			// 해당 글자의 쿠키를 사용 처리
			letterLimits[order]--;
		}
		
		// 해당 단어를 만들 수 있는 경우 'YES' 반환
		return "YES";
	}
}