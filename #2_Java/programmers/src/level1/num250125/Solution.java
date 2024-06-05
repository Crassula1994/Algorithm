package level1.num250125;

// Solution 클래스 정의
public class Solution {
	
	// 인접한 위치를 나타낼 각 델타 배열 초기화
	static int[] dh = {-1, 1, 0, 0};
	static int[] dw = {0, 0, -1, 1};
	
	// ----------------------------------------------------------------------------------------------------
	
	// solution() 메서드 정의
	public static int solution(String[][] board, int h, int w) {
		
		// 고른 칸과 이웃한 칸들 중 같은 색으로 칠해져 있는 칸의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// 보드판의 길이를 변수 length에 할당
		int length = board.length;
		
		// for 반복문을 사용해 인접한 위치를 순회
		for (int d = 0; d < 4; d++) {
			
			// 인접한 위치의 좌표를 각 변수에 할당
			int nh = h + dh[d];
			int nw = w + dw[d];
			
			// 해당 위치가 보드판의 범위를 벗어난 경우 다음 위치를 순회
			if (nh < 0 || nh >= length || nw < 0 || nw >= length)
				continue;
			
			// 해당 위치가 고른 위치와 같은 색으로 색칠된 경우 같은 색으로 칠해져 있는 칸의 개수를 갱신
			if (board[h][w].equals(board[nh][nw]))
				count++;
		}
		
		// 고른 칸과 이웃한 칸들 중 같은 색으로 칠해져 있는 칸의 개수를 반환
        return count;
    }
}