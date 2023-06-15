package bronze1.num02804;

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
		
		// nextToken() 메서드를 사용해 입력 받은 두 단어를 각 변수에 할당
		String acrossWord = st.nextToken();
		String downWord = st.nextToken();
		
		// 두 단어가 겹치는 위치를 저장할 각 변수 초기화
		int acrossIdx = -1;
		int downIdx = -1;
		
		// for 반복문을 사용해 acrossWord의 각 글자를 순회
		outer: for (int i = 0; i < acrossWord.length(); i++) {
			
			// charAt() 메서드를 사용해 해당 위치의 알파벳을 변수 acrossAlphabet에 할당
			char acrossAlphabet = acrossWord.charAt(i);
			
			// for 반복문을 사용해 downWord의 각 글자를 순회
			for (int j = 0; j < downWord.length(); j++) {
				
				// charAt() 메서드를 사용해 해당 위치의 알파벳을 변수 downAlphabet에 할당
				char downAlphabet = downWord.charAt(j);
				
				// 두 알파벳이 동일한 경우 해당 위치를 저장 후 반복문 탈출
				if (acrossAlphabet == downAlphabet) {
					acrossIdx = i;
					downIdx = j;
					break outer;
				}
			}
		}
		
		// length() 메서드를 사용해 각 단어를 크로스워드 퍼즐 형태로 저장할 2차원 배열 crossword 초기화
		char[][] crossword = new char[downWord.length()][acrossWord.length()];
		
		// for 반복문을 사용해 가로 단어를 배열 crossword의 지정된 위치에 할당
		for (int idx = 0; idx < acrossWord.length(); idx++)
			crossword[downIdx][idx] = acrossWord.charAt(idx);
			
		// for 반복문을 사용해 가로 단어를 배열 crossword의 지정된 위치에 할당
		for (int idx = 0; idx < downWord.length(); idx++)
			crossword[idx][acrossIdx] = downWord.charAt(idx);
		
		// for 반복문을 사용해 배열 corssword의 각 행과 열을 순회
		for (int r = 0; r < downWord.length(); r++) {
			for (int c = 0; c < acrossWord.length(); c++) {
				
				// 공백인 경우 '.'을 출력
				if (crossword[r][c] == '\u0000') {
					out.write(".");
					
				// 공백이 아닌 경우 해당 글자를 출력
				} else {
					out.write(crossword[r][c]);
				}
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}