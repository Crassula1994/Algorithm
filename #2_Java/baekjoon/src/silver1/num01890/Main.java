package silver1.num01890;

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

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 게임판의 크기를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		// 게임판의 숫자, 해당 위치까지의 경로의 수를 저장할 각 2차원 배열 board 초기화
		int[][] board = new int[size][size];
		
		// for 반복문을 사용해 각 게임판의 행을 순회
		for (int r = 0; r < size; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 각 게임판의 숫자를 2차원 배열 board에 저장
			for (int c = 0; c < size; c++)
				board[r][c] = Integer.parseInt(st.nextToken());)
		}
		
		// 다음에 방문할 칸을 저장할 Queue 객체 moveList 초기화
		Queue<int[]> moveList = new LinkedList<>();
		
		// 
		
		// valueOf() 및 write() 메서드를 사용해 가장 큰 증가하는 부분 수열의 합을 출력
		out.write(String.valueOf(maxSum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}