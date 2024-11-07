package bronze1.num09946;

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
		
		// 케이스 번호를 저장할 변수 testCase 초기화
		int testCase = 0;
		
		// while 반복문을 사용해 각 케이스를 순회
		while (true) {
			
			// readLine() 메서드를 사용해 입력 받은 준하가 처음 완성한 단어 및 회수한 알파벳을 각 변수에 할당
			String startWord = in.readLine();
			String endWord = in.readLine();
			
			// 준하가 알파벳을 제대로 회수했는지 여부를 저장할 변수 isSame 초기화
			boolean isSame = true;
			
			// 마지막 케이스인 경우 반복문 탈출
			if (startWord.equals("END") && endWord.equals("END"))
				break;
			
			// 처음 완성한 단어의 알파벳 및 준하가 회수한 알파벳의 수를 저장할 각 배열 초기화
			int[] startAlphabets = new int[26];
			int[] endAlphabets = new int[26];
			
			// for 반복문을 사용해 준하가 처음 완성한 단어의 각 알파벳의 개수를 갱신
			for (char alphabet : startWord.toCharArray())
				startAlphabets[alphabet - 'a']++;
			
			// for 반복문을 사용해 준하가 회수한 알파벳의 개수를 갱신
			for (char alphabet : endWord.toCharArray())
				endAlphabets[alphabet - 'a']++;
			
			// for 반복문을 사용해 각 알파벳을 순회
			for (int idx = 0; idx < 26; idx++) {
				
				// 알파벳의 개수가 다른 경우 준하가 알파벳을 제대로 회수했는지 여부를 갱신 후 반복문 탈출
				if (startAlphabets[idx] != endAlphabets[idx]) {
					isSame = false;
					break;
				}
			}
			
			// write() 메서드를 사용해 케이스 번호를 출력
			out.write("Case " + ++testCase + ": ");
			
			// write() 메서드를 사용해 준하가 알파벳을 제대로 회수했는지 여부를 출력
			out.write((isSame) ? "same" : "different");
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}