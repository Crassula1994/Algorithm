package silver2.num16390;

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
	
	// 이미지의 크기를 저장할 각 변수 초기화
	static int height;
	static int width;
	
	// 인접한 위치를 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	// 이미지의 상태를 저장할 2차원 배열 image 초기화
	static char[][] image;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 이미지의 크기를 각 변수에 할당
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		// 고리의 수를 저장할 변수 loopNum 초기화
		int loopNum = 0;
		
		// 이미지의 상태를 저장할 2차원 배열 image 초기화
		image = new char[height][width];
		
		// for 반복문을 사용해 이미지의 각 행을 순회
		for (int r = 0; r < height; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 이미지의 행의 상태를 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 이미지의 각 상태를 2차원 배열 image에 저장
			for (int c = 0; c < width; c++)
				image[r][c] = line.charAt(c);
		}
		
		// for 반복문을 사용해 이미지의 각 픽셀을 순회
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				
				// 해당 픽셀이 흰 픽셀인 경우 다음 픽셀을 순회
				if (image[r][c] == '.')
					continue;
				
				// loopFinder() 메서드를 호출해 닫힌 고리를 확인
				loopFinder(r, c);
				
				// 고리의 수를 갱신
				loopNum++;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 고리의 수를 출력
		out.write(String.valueOf(loopNum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// loopFinder() 메서드 정의
	public static void loopFinder(int startRow, int startCol) {
		
		// 다음에 확인할 위치를 저장할 Queue 객체 checkList 초기화
		Queue<int[]> checkList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작 위치를 checkList에 추가 및 확인 처리
		checkList.offer(new int[] {startRow, startCol});
		image[startRow][startCol] = '.';
		
		// while 반복문을 사용해 checkList가 빌 때까지 순회
		while (!checkList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 확인 중인 위치를 배열 curLoc에 할당
			int[] curLoc = checkList.poll();
			
			// for 반복문을 사용해 인접한 위치를 순회
			for (int d = 0; d < 8; d++) {
				
				// 인접한 위치를 각 변수에 할당
				int nr = curLoc[0] + dr[d];
				int nc = curLoc[1] + dc[d];
				
				// 해당 위치가 이미지의 크기를 벗어난 경우 다음 위치를 순회
				if (nr < 0 || nr >= height || nc < 0 || nc >= width)
					continue;
				
				// 해당 위치가 흰 픽셀이거나 이미 확인한 곳인 경우 다음 위치를 순회
				if (image[nr][nc] == '.')
					continue;
				
				// offer() 메서드를 사용해 해당 위치를 checkList에 추가 및 확인 처리
				checkList.offer(new int[] {nr, nc});
				image[nr][nc] = '.';
			}
		}
	}
}