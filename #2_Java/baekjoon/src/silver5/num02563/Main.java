package silver5.num02563;

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
		
		// 색종이를 붙일 도화지를 나타낼 2차원 배열 drawingPaper 초기화
		int[][] drawingPaper = new int[100][100];
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 색종이의 수를 변수 cartolina에 할당
		int cartolina = Integer.parseInt(in.readLine());
		
		// 색종이의 면적을 저장할 변수 초기화
		int area = 0;

		// for 반복문을 사용해 각 색종이의 경우를 순회
		for (int i = 0; i < cartolina; i++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력받은 색종이의 행과 열의 위치를 각 변수에 할당
			int colLoc = Integer.parseInt(st.nextToken());
			int rowLoc = Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 색종이가 붙은 위치의 행을 순회
			for (int r = rowLoc; r < rowLoc + 10; r++) {
				
				// for 반복문을 사용해 색종이가 붙은 위치의 열을 순회하며 위치 표시
				for (int c = colLoc; c < colLoc + 10; c++)
					drawingPaper[r][c]++;
			}
		}

		// for 반복문을 사용해 도화지의 각 행을 순회
		for (int r = 0; r < drawingPaper.length; r++) {
			
			// for 반복문을 사용해 도화지의 각 열을 순회
			for (int c = 0; c < drawingPaper.length; c++) {
				
				// 색종이가 붙어 있는 경우 면적 갱신
				if (drawingPaper[r][c] != 0)
					area++;
			}
		}

		// valueOf() 및 write() 메서드를 사용해 색종이가 붙은 면적 출력
		out.write(String.valueOf(area));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}