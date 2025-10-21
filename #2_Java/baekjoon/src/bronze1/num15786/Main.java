package bronze1.num15786;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 원본 알파벳의 수 및 포스트잇의 개수를 각 변수에 할당
		int patternLength = Integer.parseInt(st.nextToken());
		int noteNum = Integer.parseInt(st.nextToken());
		
		// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 석규가 기억하는 알파벳을 배열 pattern에 저장
		char[] pattern = in.readLine().toCharArray();
		
		// while 반복문을 사용해 판별해야 할 각 포스트잇을 순회
		while (noteNum-- > 0) {
			
			// 해당 포스트잇에 적힌 알파벳이 비밀번호일 가능성이 있는지 여부를 저장할 변수 isPossible 초기화
			boolean isPossible = false;
			
			// readLine() 메서드를 사용해 입력 받은 포스트잇의 문자열을 변수 note에 할당
			String note = in.readLine();
			
			// length() 메서드를 사용해 입력 받은 포스트잇 문자열의 길이를 변수 noteLength에 할당
			int noteLength = note.length();
			
			// 포스트잇에 적힌 문자열의 알파벳 개수가 기억하는 원본 알파벳의 개수 이상인 경우
			if (noteLength >= patternLength) {
				
				// for 반복문을 사용해 포스트잇 문자열의 각 알파벳을 순회
				for (int noteIdx = 0, patternIdx = 0; noteIdx < noteLength; noteIdx++) {
					
					/* 해당 알파벳이 원본 알파벳과 일치하고 모든 원본 알파벳과 일치하는 경우
					해당 포스트잇에 적힌 알파벳이 비밀번호일 가능성이 있는지 여부를 갱신 후 반복문 탈출 */
					if (note.charAt(noteIdx) == pattern[patternIdx] && ++patternIdx == patternLength) {
						isPossible = true;
						break;
					}
				}
			}
			
			// valueOf() 및 write() 메서드를 사용해 해당 포스트잇에 적힌 알파벳이 비밀번호일 가능성이 있는지 여부를 출력
			out.write(String.valueOf(isPossible));
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}