package bronze2.num07600;

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
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();

		// while 반복문을 사용해 각 문장을 순회
		while (true) {
			
			// readLine() 메서드를 사용해 해당 문장을 변수 sentence에 할당
			String sentence = in.readLine();
			
			// 모든 문장을 확인한 경우 반복문 탈출
			if (sentence.equals("#"))
				break;
			
			// 해당 문장마다 나타난 알파벳의 개수를 저장할 변수 count 초기화
			int count = 0;
			
			// 각 알파벳이 출몰했는지 여부를 나타낼 배열 isAppeared 초기화
			boolean[] isAppeared = new boolean[26];
			
			// for 반복문을 사용해 해당 문장의 각 글자를 순회
			for (int idx = 0; idx < sentence.length(); idx++) {
				
				// charAt() 메서드를 사용해 해당 글자를 변수 character에 할당
				char character = sentence.charAt(idx);
				
				// 해당 글자가 알파벳이 아닌 경우 다음 글자를 순회
				if (!Character.isLetter(character))
					continue;
				
				// toLowerCase() 메서드를 사용해 해당 알파벳의 순서를 변수 order에 할당
				int order = Character.toLowerCase(character) - 'a';
				
				// 해당 글자가 처음 등장한 알파벳인 경우 해당 알파벳이 출몰했는지 여부 및 나타난 알파벳의 개수를 갱신
				if (!isAppeared[order]) {
					isAppeared[order] = true;
					count++;
				}
			}
			
			// append() 메서드를 사용해 해당 문장에서 나타난 알파벳의 개수를 sb에 저장
			sb.append(count).append("\n");
		}
		
		// toString() 및 write() 메서드를 사용해 각 문장마다 나타난 알파벳의 개수를 출력
		out.write(sb.toString());

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}