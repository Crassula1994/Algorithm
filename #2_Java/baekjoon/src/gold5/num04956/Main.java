package gold5.num04956;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 미로의 크기를 저장할 각 변수 초기화
	static int width;
	static int height;
	
	// 미로의 세로 벽과 가로 벽의 위치를 저장할 각 2차원 배열 초기화
	static int[][] verticalWalls;
	static int[][] horizontalWalls;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 미로의 크기를 각 변수에 할당
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			
			// 모든 테스트 케이스를 확인한 경우 반복문 탈출
			if (width == 0 && height == 0)
				break;
			
			// 미로의 세로 벽과 가로 벽의 위치를 저장할 각 2차원 배열 초기화
			verticalWalls = new int[height][width - 1];
			horizontalWalls = new int[height - 1][width];
			
			// for 반복문을 사용해 각 줄을 순회
			for (int line = 0; line < 2 * height - 1; line++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// 홀수 행인 경우
				if (line % 2 == 0) {
					
					// for 반복문을 사용해 세로 벽의 위치를 2차원 배열 verticalWalls에 저장
					for (int c = 0; c < width - 1; c++)
						verticalWalls[line / 2][c] = Integer.parseInt(st.nextToken());
					
				} else {
					
					// for 반복문을 사용해 가로 벽의 위치를 2차원 배열 horizontalWalls에 저장
					for (int c = 0; c < width; c++)
						horizontalWalls[line / 2][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			// pathFinder() 메서드를 호출해 미로를 탈출하기 위한 가장 짧은 경로의 길이를 변수 minLength에 할당
			int minLength = pathFinder();
			
			// write() 메서드를 사용해 미로를 탈출하기 위한 가장 짧은 경로의 길이를 출력
			out.write(minLength + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// pathFinder() 메서드 정의
	public static int pathFinder() {
		
		// 각 위치로의 이동 여부를 저장할 2차원 배열 moved 초기화
		int[][] moved = new int[height][width];
		
		// 다음에 이동할 위치를 저장할 Queue 객체 moveList 초기화
		Queue<int[]> moveList = new LinkedList<>();
		
		// offer() 메서드를 사용해 미로 입구를 moveList에 추가 및 이동 여부를 갱신
		moveList.offer(new int[] {0, 0});
		moved[0][0] = 1;
		
		// while 반복문을 사용해 moveList가 빌 때까지 순회
		while (!moveList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 위치를 배열 curLocation에 할당
			int[] curLocation = moveList.poll();
			
			// 현재 위치를 나타탤 각 좌표를 각 변수에 할당
			int curRow = curLocation[0];
			int curCol = curLocation[1];
			
			// 미로의 출구에 도달한 경우 해당 위치까지의 이동 거리를 반환
			if (curRow == height - 1 && curCol == width - 1)
				return moved[height - 1][width - 1];
			
			// 동쪽으로 이동할 수 있는 경우 해당 위치를 moveList에 추가 및 이동 여부를 갱신
			if (curCol + 1 < width && moved[curRow][curCol + 1] == 0 && verticalWalls[curRow][curCol] == 0) {
				moveList.offer(new int[] {curRow, curCol + 1});
				moved[curRow][curCol + 1] = moved[curRow][curCol] + 1;
			}
			
			// 서쪽으로 이동할 수 있는 경우 해당 위치를 moveList에 추가 및 이동 여부를 갱신
			if (curCol > 0 && moved[curRow][curCol - 1] == 0 && verticalWalls[curRow][curCol - 1] == 0) {
				moveList.offer(new int[] {curRow, curCol - 1});
				moved[curRow][curCol - 1] = moved[curRow][curCol] + 1;
			}
			
			// 남쪽으로 이동할 수 있는 경우 해당 위치를 moveList에 추가 및 이동 여부를 갱신
			if (curRow + 1 < height && moved[curRow + 1][curCol] == 0 && horizontalWalls[curRow][curCol] == 0) {
				moveList.offer(new int[] {curRow + 1, curCol});
				moved[curRow + 1][curCol] = moved[curRow][curCol] + 1;
			}
			
			// 북쪽으로 이동할 수 있는 경우 해당 위치를 moveList에 추가 및 이동 여부를 갱신
			if (curRow > 0 && moved[curRow - 1][curCol] == 0 && horizontalWalls[curRow - 1][curCol] == 0) {
				moveList.offer(new int[] {curRow - 1, curCol});
				moved[curRow - 1][curCol] = moved[curRow][curCol] + 1;
			}
		}
		
		// 미로의 출구에 도달하지 못하는 경우 0 반환
		return 0;
	}
}