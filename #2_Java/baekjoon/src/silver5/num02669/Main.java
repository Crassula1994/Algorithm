package silver5.num02669;

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

		// 직사각형 네 개를 저장할 2차원 배열 map 초기화
		int[][] map = new int[100][100];
		
		// for 반복문을 사용해 네 개의 직사각형을 순회
		for (int square = 0; square < 4; square++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 왼쪽 아래 꼭짓점의 좌표를 각 변수에 할당
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			
			// nextToken() 및 parseInt() 메서드를 사용해 오른쪽 위 꼭짓점의 좌표를 각 변수에 할당
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 해당 사각형에 해당하는 행과 열을 순회하며 넓이를 표시
			for (int r = r1; r < r2; r++) {
				for (int c = c1; c < c2; c++) 
					map[r][c]++;
			}
		}
		
		// 직사각형이 차지하는 면적을 저장할 변수 area 초기화
		int area = 0;
		
		// for 반복문을 사용해 배열 map의 행과 열을 순회
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map.length; c++) {
				
				// 직사각형으로 칠해진 경우 면적을 갱신
				if (map[r][c] != 0)
					area++;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 직사각형의 면적을 출력
		out.write(String.valueOf(area));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}