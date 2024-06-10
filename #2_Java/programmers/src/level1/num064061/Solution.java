package level1.num064061;

// 필요한 패키지 불러오기
import java.util.Stack;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	@SuppressWarnings("unchecked")
	public static int solution(int[][] board, int[] moves) {
		
		// 터뜨려져 사라진 인형의 수를 저장할 변수 count 초기화
		int count = 0;
		
		// 각 위치에 쌓인 인형을 저장할 배열 clawMachine 초기화
		Stack<Integer>[] clawMachine = new Stack[board[0].length + 1];
		
		// for 반복문을 사용해 각 위치에 쌓인 인형을 저장할 Stack 객체 초기화
		for (int idx = 0; idx < clawMachine.length; idx++)
			clawMachine[idx] = new Stack<>();
		
		// 인형을 집어 올려 쌓인 바구니를 나타낼 Stack 객체 basket 초기화
		Stack<Integer> basket = new Stack<>();
		
		// for 반복문을 사용해 각 칸을 순회
		for (int c = 0; c < board[0].length; c++) {
			
			// for 반복문을 사용해 각 줄을 거꾸로 순회
			for (int r = board.length - 1; r >= 0; r--) {
				
				// 해당 위치가 빈 칸인 경우 반복문 탈출
				if (board[r][c] == 0)
					break;
				
				// push() 메서드를 사용해 해당 칸에 위치한 인형을 배열 clawMachine에 저장
				clawMachine[c + 1].push(board[r][c]);
			}
		}
		
		// for 반복문을 사용해 각 크레인을 작동시킨 위치를 순회
		for (int move : moves) {
			
			// 해당 칸에 인형이 존재하지 않는 경우 다음 크레인의 위치를 순회
			if (clawMachine[move].isEmpty())
				continue;
			
			// pop() 메서드를 사용해 크레인이 뽑은 인형을 변수 doll에 할당
			int doll = clawMachine[move].pop();
			
			// 바구니가 비었거나 바구니에 존재하는 인형과 다른 인형인 경우 해당 인형을 바구니에 저장
			if (basket.isEmpty() || basket.peek() != doll) {
				basket.push(doll);
				
			// 바구니에 존재하는 인형과 같은 인형인 경우
			} else {
				
				// pop() 메서드를 사용해 같은 인형을 바구니에서 제거
				basket.pop();
				
				// 터뜨러져 사라진 인형의 수를 갱신
				count += 2;
			}
		}
		
		// 터뜨려져 사라진 인형의 수를 반환
        return count;
    }
}