package bronze1.num10163;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 색종이의 수를 변수 cartolina에 할당
		int cartolina = Integer.parseInt(in.readLine());
		
		// 색종이의 위치를 저장할 2차원 배열 plane 초기화
		int[][] plane = new int[1001][1001];
		
		// 각 색종이의 면적을 저장할 배열 area 초기화
		int[] area = new int[cartolina];

		// for 반복문을 사용해 각 색종이를 순회
		for (int i = 0; i < cartolina; i++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 색종이의 위치 및 크기를 각 변수에 할당
			int column = Integer.parseInt(st.nextToken());
			int row = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());

			// for 반복문을 사용해 해당 색종이의 위치를 표시
			for (int r = row; r < row + height; r++) {
				for (int c = column; c < column + width; c++)
					plane[r][c] = i + 1;
			}
		}
		
		// for 반복문을 사용해 평면의 각 행과 열을 순회
		for (int r = 0; r < plane.length; r++) {
			for (int c = 0; c < plane.length; c++) {
			
				// 색종이로 덮인 부분인 경우 면적 계산
				if (plane[r][c] != 0)
					area[plane[r][c] - 1]++;
			}
		}
		
		// for 반복문을 사용해 각 색종이의 면적을 차례로 출력
		for (int idx = 0; idx < area.length; idx++)
			out.write(area[idx] + "\n");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}