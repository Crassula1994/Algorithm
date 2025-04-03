package bronze1.num20112;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 단어의 길이를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// 입력 받은 단어 집합을 저장할 2차원 배열 wordSet 초기화
		char[][] wordSet = new char[length][length];
		
		// for 반복문을 사용해 입력 받은 단어 집합을 2차원 배열 wordSet에 저장
		for (int idx = 0; idx < length; idx++)
			wordSet[idx] = in.readLine().toCharArray();
		
		// satorSquareChecker() 및 write() 메서드를 사용해 해당 단어 집합이 사토르 마방진인지 여부를 출력
		out.write(satorSquareChecker(length, wordSet));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// satorSquareChecker() 메서드 정의
	public static String satorSquareChecker(int length, char[][] wordSet) {
		
		// for 반복문을 사용해 각 행을 순회
		for (int r = 0; r < length; r++) {
			
			// for 반복문을 사용해 확인할 칸을 순회
			for (int c = r + 1; c < length; c++) {
				
				// 해당 칸과 대칭인 칸의 글자가 다른 경우 'NO' 반환
				if (wordSet[r][c] != wordSet[c][r])
					return "NO";
			}
		}
		
		// 해당 단어 집합이 사토르 마방진인 경우 'YES' 반환
		return "YES";
	}
}