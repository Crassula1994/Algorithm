package silver2.num10164;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 격자의 크기 및 ○ 표시가 되어 있는 칸을 각 변수에 할당
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		int stopover = Integer.parseInt(st.nextToken());
		
		// 각 격자의 칸에 도달하는 방법의 수를 저장할 2차원 배열 counts 초기화
		int[][] counts = new int[height + 1][width + 1];
		
		// 시작 칸에 도달하는 방법의 수를 초기화
		counts[1][1] = 1;
		
		// ○ 표시가 되어 있는 칸이 없는 경우
		if (stopover == 0) {
			
			// for 반복문을 사용해 각 칸을 순회
			for (int r = 1; r <= height; r++) {
				for (int c = 1; c <= width; c++) {
					
					// 시작 칸인 경우 다음 칸을 순회
					if (r == 1 && c == 1)
						continue;
					
					// 해당 칸에 도달하는 방법의 수를 갱신
					counts[r][c] = counts[r - 1][c] + counts[r][c - 1];
				}
			}
		
		// ○ 표시가 되어 있는 칸이 있는 경우
		} else {
			
			// ○ 표시가 되어 있는 칸의 위치를 계산해 각 변수에 할당
			int sr = (stopover % width == 0) ? stopover / width : stopover / width + 1;
			int sc = (stopover % width == 0) ? width : stopover % width;
			
			// for 반복문을 사용해 시작 칸부터 ○ 표시가 되어 있는 칸까지 각 칸을 순회
			for (int r = 1; r <= sr; r++) {
				for (int c = 1; c <= sc; c++) {
					
					// 시작 칸인 경우 다음 칸을 순회
					if (r == 1 && c == 1)
						continue;
					
					// 해당 칸에 도달하는 방법의 수를 갱신
					counts[r][c] = counts[r - 1][c] + counts[r][c - 1];
				}
			}
			
			// for 반복문을 사용해 ○ 표시가 되어 있는 칸부터 도착 칸까지 각 칸을 순회
			for (int r = sr; r <= height; r++) {
				for (int c = sc; c <= width; c++) {
					
					// ○ 표시가 되어 있는 칸인 경우 다음 칸을 순회
					if (r == sr && c == sc)
						continue;
					
					// 해당 칸에 도달하는 방법의 수를 갱신
					counts[r][c] = counts[r - 1][c] + counts[r][c - 1];
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 도착 칸에 도달하는 방법의 수를 출력
		out.write(String.valueOf(counts[height][width]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}