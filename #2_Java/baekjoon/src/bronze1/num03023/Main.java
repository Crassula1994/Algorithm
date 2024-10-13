package bronze1.num03023;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 카드의 왼쪽 윗부분의 크기를 각 변수에 할당
		int rowNum = Integer.parseInt(st.nextToken());
		int columnNum = Integer.parseInt(st.nextToken());		
		
		// 카드 왼쪽 윗부분의 디자인을 저장할 2차원 배열 cards 초기화
		char[][] cards = new char[rowNum][columnNum];
		
		// for 반복문을 사용해 입력 받은 카드 왼쪽 윗부분의 디자인을 2차원 배열 cards에 저장
		for (int r = 0; r < rowNum; r++)
			cards[r] = in.readLine().toCharArray();
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 에러의 위치를 각 변수에 할당
		int errorR = Integer.parseInt(st.nextToken()) - 1;
		int errorC = Integer.parseInt(st.nextToken()) - 1;
		
		// for 반복문을 사용해 각 카드의 행을 순회
		for (int r = 0; r < rowNum * 2; r++) {
			
			// for 반복문을 사용해 각 카드의 열을 순회
			for (int c = 0; c < columnNum * 2; c++) {
				
				// 출력해야 할 카드의 기호를 저장할 변수 cell 초기화
				char cell;
				
				// 카드 왼쪽 윗부분인 경우 출력해야 할 기호를 갱신
				if (r < rowNum && c < columnNum) {
					cell = cards[r][c];
					
				// 카드 오른쪽 윗부분인 경우 출력해야 할 기호를 갱신
				} else if (r < rowNum && c >= columnNum) {
					cell = cards[r][columnNum - (c % columnNum) - 1];
					
				// 카드 왼쪽 아랫부분인 경우 출력해야 할 기호를 갱신
				} else if (r >= rowNum && c < columnNum) {
					cell = cards[rowNum - (r % rowNum) - 1][c];
					
				// 카드 오른쪽 아랫부분인 경우 출력해야 할 기호를 갱신
				} else {
					cell = cards[rowNum - (r % rowNum) - 1][columnNum - (c % columnNum) - 1];
				}
				
				// 해당 위치가 에러의 위치인 경우 출력해야 할 기호를 갱신
				if (r == errorR && c == errorC)
					cell = (cell == '#') ? '.' : '#';
				
				// write() 메서드를 사용해 출력해야 할 기호를 출력
				out.write(cell);
			}
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}