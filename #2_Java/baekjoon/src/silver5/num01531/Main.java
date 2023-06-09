package silver5.num01531;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 그림을 가릴 종이의 개수와 그림을 가리기 위해 필요한 종이의 개수를 각 변수에 할당
		int paperNum = Integer.parseInt(st.nextToken());
		int limit = Integer.parseInt(st.nextToken());
		
		// 모자이크 그림의 상태를 저장할 2차원 배열 drawing 초기화
		int[][] drawing = new int[101][101];
		
		// for 반복문을 사용해 각 종이를 순회
		for (int paper = 0; paper < paperNum; paper++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 좌표를 각 변수에 할당
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 2차원 배열 drawing에 종이를 표시
			for (int r = y1; r <= y2; r++) {
				for (int c = x1; c <= x2; c++)
					drawing[r][c]++;
			}
		}
		
		// 모자이크 중 보이지 않는 그림의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 2차원 배열 drawing의 각 행과 열을 순회
		for (int r = 1; r <= 100; r++) {
			for (int c = 1; c <= 100; c++) {
			
				// 그림을 가리기 위해 필요한 종이의 개수를 만족한 경우 모자이크 중 보이지 않는 그림의 개수를 갱신
				if (drawing[r][c] > limit)
					count++;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 모자이크 중 보이지 않는 그림의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}