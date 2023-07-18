package silver5.num01730;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// Main 클래스 정의
public class Main {
	
	// 인접한 위치를 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	// ----------------------------------------------------------------------------------------------------

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 목판의 크기를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		// 목판의 상태를 저장할 2차원 배열 woodblock 초기화
		char[][] woodblock = new char[size][size];
		
		// for 반복문을 사용해 목판의 상태를 초기화
		for (int r = 0; r < size; r++)
			Arrays.fill(woodblock[r], '.');;
		
		// readLine() 메서드를 사용해 입력 받은 로봇팔의 움직임을 변수 movements에 할당
		String movements = in.readLine();
		
		// 현재 로봇의 위치를 저장할 배열 currentLoc 초기화
		int[] currentLoc = {0, 0};
			
		// for 반복문을 사용해 각 로봇팔의 움직임을 순회
		for (int idx = 0; idx < movements.length(); idx++) {

			// charAt() 메서드를 사용해 해당 로봇팔의 움직임을 변수 movement에 할당
			char movement = movements.charAt(idx);
			
			// 각 위치에 따른 방향을 나타낼 변수 direction 초기화
			int direction = -1;
			
			// switch 조건문을 사용해 각 로봇팔의 움직임에 따라 방향을 설정
			switch (movement) {
				case 'U':
					direction = 0;
					break;
				case 'D':
					direction = 1;
					break;
				case 'L':
					direction = 2;
					break;
				case 'R':
					direction = 3;
			}
			
			// 로봇팔이 이동할 새로운 위치를 각 변수에 할당
			int nr = currentLoc[0] + dr[direction];
			int nc = currentLoc[1] + dc[direction];
			
			// 해당 위치가 목판의 범위를 벗어난 경우 다음 로봇팔의 움직임을 순회
			if (nr < 0 || nr >= size || nc < 0 || nc >= size)
				continue;
			
			// 현재 위치가 아직 아무 것도 지나지 않은 경우 목판의 상태를 변경
			if (woodblock[currentLoc[0]][currentLoc[1]] == '.') {
				woodblock[currentLoc[0]][currentLoc[1]] = (movement == 'U' || movement == 'D') ? '|' : '-';
				
			// 현재 위치가 세로로 지난 상태인 경우 목판의 상태를 변경
			} else if (woodblock[currentLoc[0]][currentLoc[1]] == '|' && (movement == 'L' || movement == 'R')) {
				woodblock[currentLoc[0]][currentLoc[1]] = '+';
				
			// 현재 위치가 가로로 지난 상태인 경우 목판의 상태를 변경
			} else if (woodblock[currentLoc[0]][currentLoc[1]] == '-' && (movement == 'U' || movement == 'D')) {
				woodblock[currentLoc[0]][currentLoc[1]] = '+';
			}
			
			// 다음 위치가 아직 아무 것도 지나지 않은 경우 목판의 상태를 변경
			if (woodblock[nr][nc] == '.') {
				woodblock[nr][nc] = (movement == 'U' || movement == 'D') ? '|' : '-';
				
			// 다음 위치가 세로로 지난 상태인 경우 목판의 상태를 변경
			} else if (woodblock[nr][nc] == '|' && (movement == 'L' || movement == 'R')) {
				woodblock[nr][nc] = '+';
				
			// 현재 위치가 가로로 지난 상태인 경우 목판의 상태를 변경
			} else if (woodblock[nr][nc] == '-' && (movement == 'U' || movement == 'D')) {
				woodblock[nr][nc] = '+';
			}
			
			// 현재 로봇팔의 위치를 갱신
			currentLoc[0] = nr;
			currentLoc[1] = nc;
		}

		// for 반복문을 사용해 목판의 상태를 출력
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++)
				out.write(woodblock[r][c]);
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}