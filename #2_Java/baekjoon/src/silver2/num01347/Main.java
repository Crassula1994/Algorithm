package silver2.num01347;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// 이동 방향을 저장할 각 델타 배열 초기화
		int[] dr = {1, 0, -1, 0};
		int[] dc = {0, 1, 0, -1};

		// 홍준이의 이동을 기록할 2차원 배열 maze 초기화
		char[][] maze = new char[101][101];
		
		// for 반복문을 사용해 2차원 배열 maze의 모든 값을 '#'로 초기화
		for (int r = 0; r < 101; r++)
			Arrays.fill(maze[r], '#');
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 내용의 길이를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// readLine() 메서드를 사용해 입력 받은 홍준이가 적은 내용을 변수 content에 할당
		String content = in.readLine();
		
		// 홍준이의 이동 방향과 위치를 저장할 각 변수 초기화
		int direction = 0;
		int curRow = 50;
		int curCol = 50;
		maze[curRow][curCol] = '.';
		
		// 출력해야 할 각 위치를 나타낼 각 변수 초기화
		int minRow = 50, minCol = 50;
		int maxRow = 50, maxCol = 50;
		
		// for 반복문을 사용해 홍준이가 적은 내용을 차례로 순회
		for (int idx = 0; idx < length; idx++) {
			
			// charAt() 메서드를 사용해 홍준이가 기록한 내용을 변수 character에 할당
			char character = content.charAt(idx);
			
			// switch 조건문을 사용해 홍준이가 기록한 내용에 따라 명령을 실행
			switch (character) {
				
				// 'F'가 기록된 경우
				case 'F':
					
					// 이동해야 할 위치를 갱신
					curRow += dr[direction];
					curCol += dc[direction];
					
					// 현재 방향대로 이동 처리
					maze[curRow][curCol] = '.';
					
					// min() 및 max() 메서드를 사용해 출력해야 할 위치를 갱신
					minRow = Math.min(curRow, minRow);
					minCol = Math.min(curCol, minCol);
					maxRow = Math.max(curRow, maxRow);
					maxCol = Math.max(curCol, maxCol);
					
					// 조건문 탈출
					break;
					
				// 'L'이 기록된 경우
				case 'L':
					
					// 방향을 변경 처리 후 조건문 탈출
					direction = (direction == 3) ? 0 : direction + 1;
					break;
					
				// 'R'이 기록된 경우
				default:
					
					// 방향을 변경 처리
					direction = (direction == 0) ? 3 : direction - 1;
			}
		}
		
		// for 반복문을 사용해 미로 지도를 출력
		for (int r = minRow; r <= maxRow; r++) {
			for (int c = minCol; c <= maxCol; c++)
				out.write(maze[r][c]);
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}