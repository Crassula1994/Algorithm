package silver4.num10157;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 공연장의 크기를 각 변수에 할당
		int column = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		
		// 공연장의 좌석을 저장할 2차원 배열 seats 초기화
		int[][] seats = new int[row][column];
		
		// readLine() 및 parseInt() 메서드를 사용해 관객의 대기번호를 변수 targetNum에 할당
		int targetNum = Integer.parseInt(in.readLine());
		
		// 좌석의 이동 방향을 담은 각 델타 배열을 초기화
		int[] dr = {1, 0, -1, 0};
		int[] dc = {0, 1, 0, -1};
		
		// 관객의 대기번호가 공연장의 좌석 수를 초과한 경우 0을 출력
		if (targetNum > row * column) {
			out.write("0");
		
		// 관객의 대기번호가 공연장의 좌석 수를 초과하지 않는 경우
		} else {
			
			// 현재의 행과 열의 번호, 방향을 담을 각 변수 초기화
			int r = 0;
			int c = 0;
			int direction = 0;
			
			// 좌석을 배정할 관객의 대기번호를 저장할 변수 num 초기화
			int num = 1;
			
			// while 반복문을 사용해 목표로 하는 관객의 대기번호가 나올 때까지 순회
			while (true) {
				
				// 좌석에 해당 대기번호의 관객을 배정
				seats[r][c] = num++;
				
				// 관객의 대기번호에 도달한 경우 반복문 탈출
				if (num > targetNum)
					break;
				
				// 다음 위치의 인덱스를 델타 배열을 활용하여 각 변수에 할당
				int nr = r + dr[direction];
				int nc = c + dc[direction];
				
				// 해당 위치가 배열의 범위를 벗어나거나 이미 좌석이 배정된 경우 
				if (nr < 0 || nr > row - 1 || nc < 0 || nc > column - 1 || seats[nr][nc] != 0) {
					
					// 방향 전환
					direction = (direction == 3) ? 0 : direction + 1;
					
					// 다음 위치 재할당
					nr = r + dr[direction];
					nc = c + dc[direction];
				}
				
				// 다음 위치를 갱신
				r = nr;
				c = nc;
			}
		
			// write() 메서드를 사용해 해당 관객의 좌석번호를 출력
			out.write((c + 1) + " " + (r + 1));
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}