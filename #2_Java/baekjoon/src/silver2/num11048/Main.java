package silver2.num11048;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 미로의 크기를 각 변수에 할당
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		// 입력 받은 미로에 위치한 사탕의 개수를 저장할 2차원 배열 maze 초기화
		int[][] maze = new int[height][width];
		
		// for 반복문을 사용해 배열 maze의 각 행을 순회
		for (int r = 0; r < height; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 배열 maze의 각 열에 입력 받은 사탕의 개수를 저장
			for (int c = 0; c < width; c++)
				maze[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// 해당 위치까지 사탕의 개수 최댓값을 저장할 2차원 배열 maxCandies 초기화
		int[][] maxCandies = new int[height][width];
		
		// 첫 번째 위치에서 최대 사탕의 개수를 초기화
		maxCandies[0][0] = maze[0][0];
		
		// for 반복문을 사용해 각 행의 모서리 부분에서 최대 사탕의 개수를 초기화
		for (int r = 1; r < height; r++)
			maxCandies[r][0] = maxCandies[r - 1][0] + maze[r][0];
		
		// for 반복문을 사용해 각 열의 모서리 부분에서 최대 사탕의 개수를 초기화
		for (int c = 1; c < width; c++)
			maxCandies[0][c] = maxCandies[0][c - 1] + maze[0][c];
		
		// for 반복문을 사용해 배열 maxCandies의 각 행과 열을 순회
		for (int r = 1; r < height; r++) {
			for (int c = 1; c < width; c++)
				
				// max() 메서드를 사용해 각 위치에서의 최대 사탕의 개수를 갱신
				maxCandies[r][c] = Math.max(maxCandies[r - 1][c], Math.max(maxCandies[r][c - 1], maxCandies[r - 1][c - 1])) + maze[r][c];
		}
		
		// valueOf() 및 write() 메서드를 사용해 가져올 수 있는 최대 사탕의 개수를 출력
		out.write(String.valueOf(maxCandies[height - 1][width - 1]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}