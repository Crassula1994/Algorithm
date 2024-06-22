package silver5.num14760;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 격자의 크기를 저장할 배열 size 초기화
	static int size;
	
	// 격자의 상태를 저장할 2차원 배열 grid 초기화
	static char[][] grid;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// readLine() 및 parseInt() 메서드를 사용해 격자의 크기를 변수 size에 할당
			size = Integer.parseInt(in.readLine());
			
			// 격자의 크기가 0인 경우 반복문 탈출
			if (size == 0)
				break;
			
			// 격자의 상태를 저장할 2차원 배열 grid 초기화
			grid = new char[size][size];
			
			// for 반복문을 사용해 입력 받은 격자의 상태를 2차원 배열 grid에 저장
			for (int r = 0; r < size; r++)
				grid[r] = in.readLine().toCharArray();
			
			// for 반복문을 사용해 각 행을 순회
			for (int r = 0; r < size; r++) {
				
				// squareCounter() 메서드를 호출해 해당 행에서 칠해진 칸의 배치를 변수 result에 할당
				String result = squareCounter(r, true);
				
				// isEmpty() 및 write() 메서드를 사용해 해당 행에서 칠해진 칸의 배치를 출력
				out.write(result.isEmpty() ? 0 + "\n" : result + "\n");
			}
			
			// for 반복문을 사용해 각 열을 순회
			for (int c = 0; c < size; c++) {
				
				// squareCounter() 메서드를 호출해 해당 열에서 칠해진 칸의 배치를 변수 result에 할당
				String result = squareCounter(c, false);
				
				// isEmpty() 및 write() 메서드를 사용해 해당 열에서 칠해진 칸의 배치를 출력
				out.write(result.isEmpty() ? 0 + "\n" : result + "\n");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// squareCounter() 메서드 정의
	public static String squareCounter(int lineCnt, boolean isRow) {
		
		// 해당 줄에서 칠해진 칸의 배치를 저장할 StringBuilder 객체 sb 초기화
		StringBuilder sb = new StringBuilder();
		
		// 연속해서 칠해진 칸의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 해당 줄을 순회
		for (int idx = 0; idx < size; idx++) {
			
			// 해당 칸의 정보를 square에 할당
			char square = (isRow) ? grid[lineCnt][idx] : grid[idx][lineCnt];
			
			// 해당 칸이 칠해진 칸인 경우 연속해서 칠해진 칸의 개수를 갱신
			if (square == 'X')
				count++;
			
			// 해당 칸이 빈 칸이거나 마지막 칸이면서, 연속해서 칠해진 칸이 1개 이상인 경우
			if ((square == '.' || idx == size - 1) && count > 0) {
				
				// append() 메서드를 사용해 sb에 연속해서 칠해진 칸의 개수를 저장
				sb.append(count).append(" ");
				
				// 연속해서 칠해진 칸의 개수를 초기화
				count = 0;
			}
		}
		
		// toString() 메서드를 사용해 해당 줄에서 칠해진 칸의 배치를 반환
		return sb.toString();
	}
}