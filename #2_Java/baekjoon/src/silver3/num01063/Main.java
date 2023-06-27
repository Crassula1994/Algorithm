package silver3.num01063;

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
		
		// nextToken() 메서드를 사용해 입력 받은 킹의 킹의 위치, 돌의 위치를 각 변수에 할당
		String kingLoc = st.nextToken();
		String stoneLoc = st.nextToken();
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 움직이는 횟수를 변수 moveCnt에 할당
		int moveCnt = Integer.parseInt(st.nextToken());
		
		// 각 이동 방향을 저장할 델타 배열 초기화
		int[] dr = {0, 0, 1, -1, -1, -1, 1, 1};
		int[] dc = {1, -1, 0, 0, 1, -1, 1, -1};
		
		// abs() 메서드를 사용해 킹과 돌의 위치를 가져와 좌표로 변환하고 이를 각 변수에 할당
		int kingRow = Math.abs(kingLoc.charAt(1) - '8');
		int kingCol = kingLoc.charAt(0) - 'A';
		int stoneRow = Math.abs(stoneLoc.charAt(1) - '8');
		int stoneCol = stoneLoc.charAt(0) - 'A';
		
		// for 반복문을 사용해 입력 받은 각 이동 정보를 순회
		for (int m = 0; m < moveCnt; m++) {

			// readLine() 메서드를 사용해 입력 받은 이동 정보를 변수 info에 할당
			String info = in.readLine();
			
			// 이동하는 정보를 저장할 변수 direction 초기화
			int direction = -1;
			
			// switch 조건문을 사용해 입력 받은 이동 정보에 따라 변수 direction을 갱신
			switch (info) {
				case "R":
					direction = 0;
					break;
				case "L":
					direction = 1;
					break;
				case "B":
					direction = 2;
					break;
				case "T":
					direction = 3;
					break;
				case "RT":
					direction = 4;
					break;
				case "LT":
					direction = 5;
					break;
				case "RB":
					direction = 6;
					break;
				case "LB":
					direction = 7;
			}
			
			// 새로 이동할 킹의 위치를 각 변수에 할당
			int kingNewRow = kingRow + dr[direction];
			int kingNewCol = kingCol + dc[direction];
			
			// 새로 이동할 킹의 위치가 범위를 벗어난 경우 다음 위치를 순회
			if (kingNewRow < 0 || kingNewRow >= 8 || kingNewCol < 0 || kingNewCol >= 8)
				continue;
			
			// 새로 이동할 킹의 위치가 기존의 돌의 위치와 같은 경우
			if (kingNewRow == stoneRow && kingNewCol == stoneCol) {
				
				// 새로 이동할 돌의 위치를 각 변수에 할당
				int stoneNewRow = stoneRow + dr[direction];
				int stoneNewCol = stoneCol + dc[direction];
				
				// 새로 이동할 돌의 위치가 범위를 벗어난 경우 다음 위치를 순회
				if (stoneNewRow < 0 || stoneNewRow >= 8 || stoneNewCol < 0 || stoneNewCol >= 8)
					continue;
				
				// 돌의 위치를 갱신
				stoneRow = stoneNewRow;
				stoneCol = stoneNewCol;
			}
			
			// 킹의 위치를 갱신
			kingRow = kingNewRow;
			kingCol = kingNewCol;
		}
		
		// abs() 및 valueOf() 메서드를 사용해 킹과 돌의 좌표를 다시 위치로 변환하고 각 변수에 할당
		kingLoc = (char) (kingCol + 65) + String.valueOf(Math.abs(kingRow - 8));
		stoneLoc = (char) (stoneCol + 65) + String.valueOf(Math.abs(stoneRow - 8));
		
		// write() 메서드를 사용해 킹의 마지막 위치 및 돌의 마지막 위치를 출력
		out.write(kingLoc + "\n" + stoneLoc);

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}