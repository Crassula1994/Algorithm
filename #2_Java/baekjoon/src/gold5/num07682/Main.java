package gold5.num07682;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 틱택토 판의 'O'와 'X' 말의 개수를 저장할 각 변수 초기화
	static int totalCountO;
    static int totalCountX;
	
	// 틱택토 판의 상태를 저장할 2차원 배열 board 초기화
	static char[][] board;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// readLine() 메서드를 사용해 입력 받은 틱택토의 상태를 변수 testCase에 할당
			String testCase = in.readLine();
			
			// 모든 테스트 케이스를 확인한 경우 반복문 탈출
			if (testCase.equals("end"))
				break;
			
			// 틱택토 판의 'O'와 'X' 말의 개수를 저장할 각 변수 초기화
			totalCountO = 0;
			totalCountX = 0;
			
			// 틱택토 판의 상태를 저장할 2차원 배열 board 초기화
			board = new char[3][3];
			
			// for 반복문을 사용해 틱택토 판의 각 칸을 순회
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 3; c++) {
					
					// charAt() 메서드를 사용해 입력 받은 틱택토의 상태를 2차원 배열 board에 저장
					board[r][c] = testCase.charAt(r * 3 + c);
					
					// 해당 칸이 'O'인 경우 'O' 말의 개수를 갱신
					if (board[r][c] == 'O') {
						totalCountO++;
					
					// 해당 칸이 'X'인 경우 'X' 말의 개수를 갱신
					} else if (board[r][c] == 'X') {
						totalCountX++;
					}
				}
			}
			
			// tickTackToeChecker() 및 write() 메서드를 사용해 해당 게임판이 틱택토 게임에서 가능한지 여부를 출력
			out.write((tickTackToeChecker()) ? "valid" : "invalid");
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// tickTackToeChecker() 메서드 정의
	public static boolean tickTackToeChecker() {
		
		// 선공과 후공의 개수가 잘못된 경우 false 반환
		if (totalCountO > totalCountX || totalCountX - totalCountO > 1)
			return false;
		
		// tickTackToeCounter() 메서드를 호출해 세 칸을 만든 'O' 및 'X' 말의 개수를 배열 result에 할당
		int[] result = tickTackToeCounter();
		
		// 'O'가 이긴 경우 true를 반환
		if (result[0] == 1 && result[1] == 0 && totalCountO == totalCountX)
			return true;
		
		// 'X'가 이긴 경우 true를 반환
		if (result[0] == 0 && result[1] > 0 && result[1] < 3 && totalCountX == totalCountO + 1)
			return true;
		
		// 게임판이 가득 찬 경우 true를 반환
		if (result[0] == 0 && result[1] == 0 && totalCountX == 5 && totalCountO == 4)
			return true;
		
		// 틱택토 게임의 결과가 될 수 없는 경우 false 반환
		return false;
	}
	
	// ----------------------------------------------------------------------------------------------------

	// tickTackToeCounter() 메서드 정의
	public static int[] tickTackToeCounter() {
		
		// 틱택토를 완성한 개수를 저장할 배열 result 초기화
		int[] result = new int[2];
		
		// for 반복문을 사용해 틱택토 판의 가로를 순회
		outer: for (int r = 0; r < 3; r++) {
			
			// 'O'와 'X' 말의 개수를 저장할 각 변수 초기화
			int countO = 0;
			int countX = 0;
			
			// for 반복문을 사용해 틱택토 판의 각 칸을 순회
			for (int c = 0; c < 3; c++) {
				
				// 한 칸이라도 빈 칸일 경우 다음 가로 줄을 순회
				if (board[r][c] == '.')
					continue outer;
				
				// 해당 칸이 'O'인 경우 'O' 말의 개수를 갱신
				if (board[r][c] == 'O') {
					countO++;
				
				// 해당 칸이 'X'인 경우 'X' 말의 개수를 갱신
				} else {
					countX++;
				}
			}
			
			// 'O' 말로 한 줄이 완성된 경우 'O' 말의 완성된 줄 수를 갱신
			if (countO == 3)
				result[0]++;
			
			// 'X' 말로 한 줄이 완성된 경우 'X' 말의 완성된 줄 수를 갱신
			if (countX == 3)
				result[1]++;
		}
		
		// for 반복문을 사용해 틱택토 판의 세로를 순회
		outer: for (int c = 0; c < 3; c++) {

			// 'O'와 'X' 말의 개수를 저장할 각 변수 초기화
			int countO = 0;
			int countX = 0;
            
			// for 반복문을 사용해 틱택토 판의 각 칸을 순회
			for (int r = 0; r < 3; r++) {
				
				// 한 칸이라도 빈 칸일 경우 다음 세로 줄을 순회
				if (board[r][c] == '.')
					continue outer;
				
				// 해당 칸이 'O'인 경우 'O' 말의 개수를 갱신
				if (board[r][c] == 'O') {
					countO++;
					
				// 해당 칸이 'X'인 경우 'X' 말의 개수를 갱신
				} else {
					countX++;
				}
			}
			
			// 'O' 말로 한 줄이 완성된 경우 'O' 말의 완성된 줄 수를 갱신
			if (countO == 3)
				result[0]++;
			
			// 'X' 말로 한 줄이 완성된 경우 'X' 말의 완성된 줄 수를 갱신
			if (countX == 3)
				result[1]++;
		}
		
		// 'O'와 'X' 말의 개수를 저장할 각 변수 초기화
		int countO = 0;
		int countX = 0;
		
		// for 반복문을 사용해 정방향의 대각선을 순회
		for (int idx = 0; idx < 3; idx++) {
			
			// 한 칸이라도 빈 칸일 경우 반복문 탈출
			if (board[idx][idx] == '.')
				break;

			// 해당 칸이 'O'인 경우 'O' 말의 개수를 갱신
			if (board[idx][idx] == 'O') {
				countO++;
				
			// 해당 칸이 'X'인 경우 'X' 말의 개수를 갱신
			} else {
				countX++;
			}
		}
        
		// 'O' 말로 한 줄이 완성된 경우 'O' 말의 완성된 줄 수를 갱신
		if (countO == 3)
			result[0]++;
		
		// 'X' 말로 한 줄이 완성된 경우 'X' 말의 완성된 줄 수를 갱신
		if (countX == 3)
			result[1]++;
        
		// 'O'와 'X' 말의 개수를 저장할 각 변수 초기화
		countO = 0;
		countX = 0;
		
		// for 반복문을 사용해 역방향의 대각선을 순회
		for (int idx = 0; idx < 3; idx++) {
			
			// 한 칸이라도 빈 칸일 경우 반복문 탈출
			if (board[2 - idx][idx] == '.')
				break;

			// 해당 칸이 'O'인 경우 'O' 말의 개수를 갱신
			if (board[2 - idx][idx] == 'O') {
				countO++;
			
			// 해당 칸이 'X'인 경우 'X' 말의 개수를 갱신  
			} else {
				countX++;
			}
		}
		
		// 'O' 말로 한 줄이 완성된 경우 'O' 말의 완성된 줄 수를 갱신
		if (countO == 3)
			result[0]++;
		
		// 'X' 말로 한 줄이 완성된 경우 'X' 말의 완성된 줄 수를 갱신
		if (countX == 3)
			result[1]++;

        // 틱택토를 완성한 개수를 반환
        return result;
	}
}