package bronze2.num01371;

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
		
		// 각 알파벳의 개수를 저장할 배열 counter 초기화
		int[] counter = new int[26];
		
		// while 반복문을 사용해 각 줄을 모두 순회
		while (true) {
			
			// readLine() 메서드를 사용해 입력 받은 문장을 변수 sentence에 할당
			String sentence = in.readLine();
			
			// 글이 끝난 경우 반복문 탈출
			if (sentence == null)
				break;
			
			// for 반복문을 사용해 각 문자를 순회
			for (int idx = 0; idx < sentence.length(); idx++) {
				
				// charAt() 메서드를 사용해 해당 문자를 변수 character에 할당
				char character = sentence.charAt(idx);
				
				// 빈 칸인 경우 다음 문자를 순회
				if (character == ' ')
					continue;
				
				// 해당 알파벳의 개수를 갱신
				counter[character - 'a']++;
			}
		}
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// 가장 많은 알파벳의 개수를 저장할 변수 maxCount 초기화
		int maxCount = 0;
		
		// for 반복문을 사용해 각 알파벳을 순회
		for (int idx = 0; idx < counter.length; idx++) {
			
			// 해당 알파벳의 개수가 저장된 가장 많은 알파벳의 개수보다 많은 경우
			if (counter[idx] > maxCount) {
				
				// 가장 많은 알파벳의 개수 갱신 및 sb 초기화
				maxCount = counter[idx];
				sb = new StringBuilder();
				
				// append() 메서드를 사용해 해당 알파벳을 sb에 추가
				sb.append((char) (idx + 97));
				
			// 해당 알파벳의 개수가 저장된 가장 많은 알파벳의 개수와 같은 경우
			} else if (counter[idx] == maxCount) {
				
				// append() 메서드를 사용해 해당 알파벳을 sb에 추가
				sb.append((char) (idx + 97));
			}
		}
		
		// toString() 및 write() 메서드를 사용해 가장 많이 나온 문자를 알파벳 순으로 출력
		out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}