package bronze2.num05704;

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
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// readLine() 메서드를 사용해 입력 받은 문장을 변수 sentence에 할당
			String sentence = in.readLine();
			
			// 모든 테스트 케이스를 확인한 경우 반복문 탈출
			if (sentence.equals("*"))
				break;
				
			// 해당 문장이 팬그램인지 여부를 나타낼 변수 isPangram 초기화
			boolean isPangram = true;
			
			// 해당 문장에 포함된 알파벳의 등장 여부를 저장할 배열 alphabets 초기화
			boolean[] alphabets = new boolean[26];
			
			// for 반복문을 사용해 문장의 각 글자를 순회
			for (int idx = 0; idx < sentence.length(); idx++) {
				
				// charAt() 메서드를 사용해 해당 글자를 변수 character에 할당
				char character = sentence.charAt(idx);
				
				// 해당 글자가 공백인 경우 다음 글자를 순회
				if (character == ' ')
					continue;
				
				// 해당 알파벳의 등장 여부를 갱신
				alphabets[character - 'a'] = true;
			}
			
			// for 반복문을 사용해 각 알파벳을 순회
			for (int idx = 0; idx < alphabets.length; idx++) {
				
				// 해당 알파벳이 등장하지 않은 경우 해당 문장이 팬그램인지 여부를 갱신 후 반복문 탈출
				if (!alphabets[idx]) {
					isPangram = false;
					break;
				}
			}
			
			// write() 메서드를 사용해 해당 문장이 팬그램인지 여부를 출력
			out.write((isPangram) ? "Y" : "N");
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}