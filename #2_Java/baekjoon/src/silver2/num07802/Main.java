package silver2.num07802;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 고고학자가 밝혀낸 각 알파벳 기호를 저장할 배열 alphabets 초기화
	static String[] alphabets = {".--", "-.", "---", "..", "--..", "--.-", ".-."};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력 받은 전신을 저장할 변수 telegraph 초기화
		String telegraph;
		
		// while 반복문을 사용해 각 전신을 순회
		while ((telegraph = in.readLine()) != null) {
			
			// 해당 전신을 해독할 수 있는지 여부를 나타낼 변수 isDecodable 초기화
			boolean isDecodable = true;
			
			// length() 메서드를 사용해 전신의 길이를 변수 totalLength에 할당
			int totalLength = telegraph.length();
			
			// 해독된 글자와 그 길이를 저장할 각 배열 초기화
			Character[] letters = new Character[totalLength];
			int[] lengths = new int[totalLength];
			
			// 해독된 메시지를 저장할 StringBuilder 객체 sb 초기화
			StringBuilder sb = new StringBuilder();
			
			// for 반복문을 사용해 각 글자를 순회
			for (int idx = 0; idx < totalLength; idx++) {
				
				// for 반복문을 사용해 각 알파벳을 순회
				for (int order = 0; order < alphabets.length; order++) {
					
					// 해당 위치에서 일치하는 알파벳이 있는 경우
					if (telegraph.startsWith(alphabets[order], idx)) {
						
						// length() 메서드를 사용해 해독된 글자와 그 길이를 각 배열에 저장
						letters[idx] = (char) ('A' + order);
						lengths[idx] = alphabets[order].length();
						
						// 반복문 탈출
						break;
					}
				}
			}
			
			// for 반복문을 사용해 각 글자를 순회
			for (int idx = 0; idx < totalLength;) {
				
				// 해당 글자를 해독할 수 없는 경우 해당 전신을 해독할 수 있는지 여부를 갱신 후 반복문 탈출
				if (letters[idx] == null) {
					isDecodable = false;
					break;
				}
				
				// append() 메서드를 사용해 해독한 글자를 sb에 추가
				sb.append(letters[idx]);
				
				// 다음 글자의 위치로 이동
				idx += lengths[idx];
			}
			
			// toString() 및 write() 메서드를 사용해 전신을 해독할 수 있는지 여부에 따라 해독된 메시지를 출력
			out.write((isDecodable) ? sb.toString() : "could not be translated");
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}