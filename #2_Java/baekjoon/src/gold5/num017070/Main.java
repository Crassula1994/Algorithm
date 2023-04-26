package gold5.num017070;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {

	// 집의 크기, 파이프의 한쪽 끝을 목적지로 이동시키는 방법의 수를 저장할 각 변수 초기화
	static int size;
	static int count;
	
	// 집의 상태를 저장할 2차원 배열 house 초기화
	static int[][] house;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 집의 크기를 변수 size에 할당
		size = Integer.parseInt(in.readLine());
		
		// 집의 상태를 저장할 2차원 배열 house 초기화
		house = new int[size][size];
		
		// for 반복문을 사용해 배열 house의 각 행을 순회
		for (int r = 0; r < size; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 집의 상태를 배열 house에 저장
			for (int c = 0; c < size; c++)
				house[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// pathFinder() 메서드를 호출해 파이프의 한쪽 끝을 목적지로 이동시키는 방법의 수를 갱신
		pathFinder(0, 1, "horizontal");
		
		// valueOf() 및 write() 메서드를 사용해 파이프의 한쪽 끝을 목적지로 이동시키는 방법의 수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// pathFinder() 메서드 정의
	public static void pathFinder(int row, int col, String status) {
		
		// 해당 위치가 목적지인 경우 목적지로 이동시키는 방법의 수를 갱신 후 메서드 종료
		if (row == size - 1 && col == size - 1) {
			count++;
			return;
		}
				
		// switch 조건문을 사용해 파이프의 상태를 구분
		switch (status) {
		
			// 가로로 놓인 경우
			case "horizontal":
				
				// 가로로 옮길 수 있는 경우 이를 상정해 pathFinder() 메서드 재귀 호출
				if (col + 1 < size && house[row][col + 1] == 0)
					pathFinder(row, col + 1, "horizontal");
				
				// 대각으로 옮길 수 있는 경우 이를 상정해 pathFinder() 메서드 재귀 호출
				if (row + 1 < size && col + 1 < size && !isWall(row, col))
					pathFinder(row + 1, col + 1, "diagonal");
				
				// 조건문 탈출
				break;
				
			// 세로로 놓인 경우
			case "vertical":
				
				// 세로로 옮길 수 있는 경우 이를 상정해 pathFinder() 메서드 재귀 호출
				if (row + 1 < size && house[row + 1][col] == 0)
					pathFinder(row + 1, col, "vertical");
				
				// 대각으로 옮길 수 있는 경우 이를 상정해 pathFinder() 메서드 재귀 호출
				if (row + 1 < size && col + 1 < size && !isWall(row, col))
					pathFinder(row + 1, col + 1, "diagonal");
				
				// 조건문 탈출
				break;
				
			// 대각으로 놓인 경우
			default:
		
				// 가로로 옮길 수 있는 경우 이를 상정해 pathFinder() 메서드 재귀 호출
				if (col + 1 < size && house[row][col + 1] == 0)
					pathFinder(row, col + 1, "horizontal");
				
				// 세로로 옮길 수 있는 경우 이를 상정해 pathFinder() 메서드 재귀 호출
				if (row + 1 < size && house[row + 1][col] == 0)
					pathFinder(row + 1, col, "vertical");
				
				// 대각으로 옮길 수 있는 경우 이를 상정해 pathFinder() 메서드 재귀 호출
				if (row + 1 < size && col + 1 < size && !isWall(row, col))
					pathFinder(row + 1, col + 1, "diagonal");
		}
	}

	// ----------------------------------------------------------------------------------------------------
	
	// isWall() 메서드 정의
	public static boolean isWall(int row, int col) {
		
		// 나머지 위치가 모두 벽이 아닌 경우 false 반환
		if (house[row + 1][col] == 0 && house[row][col + 1] == 0 && house[row + 1][col + 1] == 0)
			return false;
		
		// 하나의 위치라도 벽인 경우 true 반환
		return true;
	}
}