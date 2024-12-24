package silver3.num16956;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 인접한 칸을 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 목장의 크기를 각 변수에 할당
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		// 늑대를 양이 있는 칸으로 갈 수 없게 할 수 있는지 여부를 저장할 변수 isRestricted 초기화
		boolean isRestricted = true;
		
		// 입력 받은 목장의 상태를 저장할 2차원 배열 farm 초기화
		char[][] farm = new char[height][width];
		
		// for 반복문을 사용해 입력 받은 목장의 상태를 2차원 배열 farm에 저장
		for (int r = 0; r < height; r++)
			farm[r] = in.readLine().toCharArray();
		
		// for 반복문을 사용해 목장의 각 칸을 순회
		outer: for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				
				// 해당 칸에 늑대가 위치하지 않은 경우 다음 칸을 순회
				if (farm[r][c] != 'W')
					continue;
				
				// for 반복문을 사용해 인접한 각 위치를 순회
				for (int d = 0; d < 4; d++) {
					
					// 인접한 위치를 각 변수에 할당
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					// 해당 위치가 목장의 범위를 벗어난 경우 다음 위치를 순회
					if (nr < 0 || nr >= height || nc < 0 || nc >= width)
						continue;
					
					// 해당 위치에 양이 존재하는 경우 늑대를 양이 있는 칸으로 갈 수 없게 할 수 있는지 여부를 갱신 후 반복문 탈출
					if (farm[nr][nc] == 'S') {
						isRestricted = false;
						break outer;
					}
					
					// 해당 위치가 빈 칸인 경우 울타리를 배치
					if (farm[nr][nc] == '.')
						farm[nr][nc] = 'D';
				}
			}
		}
		
		// 늑대를 양이 있는 칸으로 갈 수 없게 할 수 있는 경우
		if (isRestricted) {
			
			// write() 메서드를 사용해 1을 출력
			out.write(1 + "\n");
			
			// for 반복문을 사용해 울타리를 설치한 목장의 상태를 출력
			for (int r = 0; r < height; r++) {
				for (int c = 0; c < width; c++)
					out.write(farm[r][c]);
				
				// newLine() 메서드를 사용해 줄바꿈 출력
				out.newLine();
			}
		
		// 늑대를 양이 있는 칸으로 갈 수 없게 할 수 있는 경우 0을 출력
		} else {
			out.write(String.valueOf(0));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}