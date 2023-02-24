package gold4.num09663;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// Main 클래스 정의
public class Main {
	
	// 경우의 수를 저장할 변수 count 초기화
	static int count = 0;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 체스판의 크기를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		// 체스판에 퀸을 놓을 수 있는 위치를 표시할 배열 board 초기화
		int[] board = new int[size];
		
		// fill() 메서드를 사용해 배열 board의 초기값을 -1로 초기화
		Arrays.fill(board, -1);
		
		// nQueen() 메서드를 호출해 경우의 수를 계산
		nQueen(size, 0, board);
		
		// valueOf() 및 write() 메서드를 사용해 경우의 수를 출력
		out.write(String.valueOf(count));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// nQueen() 메서드 정의
	public static void nQueen(int size, int depth, int[] board) {

		// 퀸을 모두 배치한 경우 경우의 수를 조정
		if (depth == size) {
			count++;
			
		// 퀸을 모두 배치하지 못한 경우
		} else {
			
			// for 반복문을 사용해 현재 행의 각 열을 순회
			outer: for (int c = 0; c < size; c++)  {
				
				// 현재 행 이전의 각 행을 순회
				for (int r = 0; r < depth; r++) {
					
					// 해당 열을 선택하는 것이 불가능한 경우 다음 열을 순회
					if (board[r] == c || board[r] + depth - r == c || board[r] - depth + r == c)
						continue outer;
				}
				
				// 해당 열을 선택 후 nQueen() 메서드 재귀 호출
				board[depth] = c;
				nQueen(size, depth + 1, board);
				
				// 해당 행의 선택 여부를 원상 복구
				board[depth] = -1;
			}
		}
	}
}