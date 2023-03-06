package bronze1.num10798;

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
		
		// 5개의 단어를 각 글자별로 저장할 2차원 배열 words 초기화
		char[][] words = new char[5][15];
		
		// for 반복문을 사용해 각 단어를 순회
		for (int r = 0; r < 5; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 단어를 변수 word에 할당
			String word = in.readLine();
			
			// for 반복문을 사용해 각 글자를 배열 words에 저장
			for (int c = 0; c < word.length(); c++)
				words[r][c] = word.charAt(c);
		}

		// for 반복문을 사용해 배열 words의 열과 행을 순회
		for (int c = 0; c < 15; c++) {
			for (int r = 0; r < 5; r++) {

				// 빈 값일 경우 다음 글자를 순회
				if (words[r][c] == 0)
					continue;
				
				// write() 메서드를 사용해 각 글자를 차례로 출력
				out.write(words[r][c]);
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}