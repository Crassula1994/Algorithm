package gold3.num02151;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

// Main 클래스 정의
public class Main {
	
	// 집의 크기를 나타낼 변수 size 초기화
	static int size;
	
	// 빛의 이동 방향, 집에 대한 정보, 문의 위치를 나타낼 2차원 배열 초기화
	static int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
	static char[][] house;
	static int[][] doors = new int[2][2];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 집의 크기를 변수 size에 할당
		size = Integer.parseInt(in.readLine());
		
		// 집에 대한 정보를 나타낼 2차원 배열 house 초기화
		house = new char[size][size];
		
		// for 반복문을 사용해 2차원 배열 house의 각 행을 순회
		for (int r = 0, idx = 0; r < size; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 해당 줄의 정보를 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 2차원 배열 house의 각 열을 순회
			for (int c = 0; c < size; c++) {
				
				// charAt() 메서드를 사용해 입력 받은 각 위치의 정보를 2차원 배열 house에 저장
				house[r][c] = line.charAt(c);
				
				// 해당 위치가 문인 경우
				if (house[r][c] == '#') {
					
					// 배열 doors에 해당 위치를 저장
					doors[idx][0] = r;
					doors[idx][1] = c;
					
					// 저장하는 인덱스를 갱신
					idx++;
				}
			}
		}
		
		// mirrorSetter() 메서드를 호출해 설치해야 할 거울의 최소 개수를 변수 minCnt에 할당
		int minCnt = mirrorSetter();
		
		// valueOf() 및 wirte() 메서드를 사용해 설치해야 할 거울의 최소 개수를 출력
		out.write(String.valueOf(minCnt));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// mirrorSetter() 메서드 정의
	public static int mirrorSetter() {
		
		// 해당 위치의 이동 정보를 저장할 3차원 배열 moved 초기화
		Integer[][][] moved = new Integer[size][size][4];
		
		// 다음에 빛이 이동할 위치를 저장할 PriorityQueue 객체 moveList 초기화
		PriorityQueue<int[]> moveList = new PriorityQueue<>((l1, l2) -> {
			return moved[l1[0]][l1[1]][l1[2]] - moved[l2[0]][l2[1]][l2[2]];
		});
		
		// for 반복문을 사용해 시작 위치로부터 네 방향을 순회
		for (int dir = 0; dir < 4; dir++) {
			
			// offer() 메서드를 사용해 moveList에 시작 위치를 추가 및 이동 처리
			moved[doors[0][0]][doors[0][1]][dir] = 0;
			moveList.offer(new int[] {doors[0][0], doors[0][1], dir});
		}
		
		// 설치해야 할 거울의 최소 개수를 저장할 변수 minCnt 초기화
		int minCnt = 0;
		
		// while 반복문을 사용해 moveList가 빌 때까지 순회
		while (!moveList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 이동한 위치를 배열 currentLoc에 할당
			int[] currentLoc = moveList.poll();

			// 해당 위치가 도착 위치인 경우 설치해야 할 거울의 최소 개수를 갱신 후 반복문 탈출
			if (currentLoc[0] == doors[1][0] && currentLoc[1] == doors[1][1]) {
				minCnt = moved[currentLoc[0]][currentLoc[1]][currentLoc[2]];
				break;
			}
			
			// 주어진 방향에 따른 다음 위치를 각 변수에 할당
			int nr = currentLoc[0] + directions[currentLoc[2]][0];
			int nc = currentLoc[1] + directions[currentLoc[2]][1];
			
			// 해당 위치가 범위를 벗어나거나 벽인 경우 다음 위치를 순회
			if (nr < 0 || nr >= size || nc < 0 || nc >= size || house[nr][nc] == '*')
				continue;
			
			// 해당 위치가 거울을 설치할 수 있는 위치이고, 해당 위치로 이동한 적이 없는 경우
			if (house[nr][nc] == '!' && moved[nr][nc][currentLoc[2]] == null) {
				
				// offer() 메서드를 사용해 moveList에 거울을 왼쪽으로 설치했을 경우를 상정하고, 해당 위치를 추가 및 이동 처리
				moved[nr][nc][(currentLoc[2] + 3) % 4] = moved[currentLoc[0]][currentLoc[1]][currentLoc[2]] + 1;
				moveList.offer(new int[] {nr, nc, (currentLoc[2] + 3) % 4});
				
				// offer() 메서드를 사용해 moveList에 거울을 오른쪽으로 설치했을 경우를 상정하고, 해당 위치를 추가 및 이동 처리
				moved[nr][nc][(currentLoc[2] + 1) % 4] = moved[currentLoc[0]][currentLoc[1]][currentLoc[2]] + 1;
				moveList.offer(new int[] {nr, nc, (currentLoc[2] + 1) % 4});
			}
			
			// 해당 위치로 이동한 적이 없거나 더 적은 거울을 사용할 수 있는 경우
			if (moved[nr][nc][currentLoc[2]] == null || moved[nr][nc][currentLoc[2]] > moved[currentLoc[0]][currentLoc[1]][currentLoc[2]]) {
				
				// offer() 메서드를 사용해 moveList에 해당 위치를 추가 및 이동 처리
				moved[nr][nc][currentLoc[2]] = moved[currentLoc[0]][currentLoc[1]][currentLoc[2]];
				moveList.offer(new int[] {nr, nc, currentLoc[2]});
			}
		}
		
		// 설치해야 할 거울의 최소 개수를 반환
		return minCnt;
	}
}