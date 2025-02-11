package gold2.num14529;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 연속적인 지역을 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 격자의 상태
	static char[][] grid;
	static boolean[][] isPCL;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 격자의 크기를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		// 격자의 상태를 저장할 2차원 배열 grid 초기화
		grid = new char[size][size];
		
		// for 반복문을 사용해 입력 받은 격자의 상태를 2차원 배열 grid에 저장
		for (int r = 0; r < size; r++)
			grid[r] = in.readLine().toCharArray();
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}