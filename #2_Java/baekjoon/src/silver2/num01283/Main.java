package silver2.num01283;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 각 알파벳의 단축키 지정 여부를 저장할 배열 shortcuts 초기화
		boolean[] shortcuts = new boolean[26]; //65 97
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 옵션의 개수를 변수 optionNum에 할당
		int optionNum = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 옵션을 순회
		for (int o = 0; o < optionNum; o++) {
			
			// readLine() 메서드를 사용해 입력 받은 옵션을 변수 option에 할당
			String option = in.readLine();
			
			// 해당 옵션의 단축키의 위치, 각 단어의 시작 위치를 저장할 각 변수 초기화
			int shortcut = -1;
			int wordStart = 0;
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(option.toLowerCase());
			
			// while 반복문을 사용해 각 옵션의 단어를 순회
			while (st.hasMoreTokens()) {
				
				// nextToken() 메서드를 사용해 옵션의 단어를 변수 word에 할당
				String word = st.nextToken();
				
				// 해당 단어의 첫 알파벳을 단축키로 지정하지 않은 경우
				if (!shortcuts[word.charAt(0) - 'a']) {
					
					// 해당 알파벳을 단축키 지정 후 반복문 탈출
					shortcut = wordStart;
					shortcuts[word.charAt(0) - 'a'] = true;
					break;
				}
				
				// 다음 단어의 시작 위치를 갱신
				wordStart += word.length() + 1;
			}
			
			// for 반복문을 사용해 각 자리의 알파벳을 순회
			for (int idx = 0; idx < option.length(); idx++) {
				
				// 이미 단축키가 지정된 경우 반복문 탈출
				if (shortcut != -1)
					break;
				
				// 해당 위치의 알파벳을 변수 alphabet에 할당
				char alphabet = option.toLowerCase().charAt(idx);
				
				// 빈칸인 경우 다음 알파벳을 순회
				if (alphabet == ' ')
					continue;
				
				// 해당 알파벳을 단축키로 지정하지 않은 경우
				if (!shortcuts[alphabet - 'a']) {
					
					// 해당 알파벳을 단축키 지정 후 반복문 탈출
					shortcut = idx;
					shortcuts[alphabet - 'a'] = true;
					break;
				}
			}
			
			// 단축키를 지정하지 못한 경우 단어를 그대로 출력
			if (shortcut == -1) {
				out.write(option + "\n");
			
			// 단축키를 지정한 경우 해당 단축키에 대괄호를 더해 출력
			} else {
				out.write(option.substring(0, shortcut) + "[" + option.charAt(shortcut) + "]" + option.substring(shortcut + 1) + "\n");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}