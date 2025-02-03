package silver2.num30610;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 입력 받은 이미지의 크기를 저장할 각 변수 초기화
	static int height;
	static int width;
	
	// 인접한 위치를 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 입력 받은 이미지의 상태를 저장할 2차원 배열 image 초기화
	static boolean[][] image;
	
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
		
		// 입력 받은 이미지의 상태를 저장할 2차원 배열 image 초기화
		image = new boolean[height][width];
		
		// 각 호수의 크기를 저장할 List 객체 lakes 초기화
		List<Integer> lakes = new ArrayList<>();
		
		// for 반복문을 사용해 이미지의 각 줄을 순회
		for (int r = 0; r < height; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 이미지의 줄을 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 각 이미지의 타일을 순회
			for (int c = 0; c < width; c++) {
				
				// 해당 타일이 물 타일인 경우 이미지의 상태를 갱신
				if (line.charAt(c) == '1')
					image[r][c] = true;
			}
		}
		
		// for 반복문을 사용해 각 타일을 순회
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				
				// 해당 타일이 물 타일인 경우 해당 물 타일이 속한 호수의 크기를 lakes에 추가
				if (image[r][c])
					lakes.add(lakeFinder(r, c));
			}
		}
		
		// sort() 메서드를 사용해 호수의 크기를 오름차순으로 정렬
		Collections.sort(lakes);
		
		// size() 및 write() 메서드를 사용해 호수의 개수를 출력
		out.write(lakes.size() + "\n");
		
		// for 반복문을 사용해 각 호수의 크기를 오름차순으로 출력
		for (int size : lakes)
			out.write(size + " ");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// lakeFinder() 메서드 정의
	public static int lakeFinder(int startRow, int startColumn) {
		
		// 해당 호수의 크기를 저장할 변수 size 초기화
		int size = 1;
		
		// 다음에 확인할 타일을 저장할 Queue 객체 tileList 초기화
		Queue<int[]> tileList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작 위치를 tileList에 추가 및 확인 처리
		tileList.offer(new int[] {startRow, startColumn});
		image[startRow][startColumn] = false;
		
		// while 반복문을 사용해 tileList가 빌 때까지 순회
		while (!tileList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 타일을 배열 curTile에 할당
			int[] curTile = tileList.poll();
			
			// for 반복문을 사용해 인접한 타일을 순회
			for (int d = 0; d < 4; d++) {
				
				// 인접한 타일을 각 변수에 할당
				int nr = curTile[0] + dr[d];
				int nc = curTile[1] + dc[d];
				
				// 해당 타일이 이미지의 범위를 벗어나거나 땅 타일인 경우 다음 타일을 순회
				if (nr < 0 || nr >= height || nc < 0 || nc >= width || !image[nr][nc])
					continue;
				
				// 해당 호수의 크기를 갱신
				size++;
				
				// offer() 메서드를 사용해 해당 위치를 tileList에 추가 및 확인 처리
				tileList.offer(new int[] {nr, nc});
				image[nr][nc] = false;
			}
		}
		
		// 해당 호수의 크기를 반환
		return size;
	}
}