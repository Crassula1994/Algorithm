package gold2.num28016;

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
	
	// 최대 확률의 자릿수를 저장할 상수 MAX_PROB_LENGTH 초기화
	static final int MAX_PROB_LENGTH = 100;
	
	// 추첨 판의 세로 길이와 가로 길이를 저장할 각 변수 초기화
	static int height;
	static int width;
	
	// 추첨 판의 상태를 저장할 2차원 배열 board 초기화
	static boolean[][] board;
	
	// 각 추첨 판에서의 확률을 저장할 3차원 배열 probabilities 초기화
	static int[][][] probabilities;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드르 사용해 입력 받은 추첨 판의 세로 길이와 가로 길이를 각 변수에 할당
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		// 공의 시작 위치와 당첨될 확률이 가장 높은 번호를 저장할 각 변수 초기화
		int startIdx = -1;
		int maxIdx = -1;
		
		// 당첨될 확률이 가장 높은 번호의 확률을 저장할 배열 maxProb 초기화
		int[] maxProb = new int[MAX_PROB_LENGTH];
		
		// 추첨 판의 상태를 저장할 2차원 배열 board 초기화
		board = new boolean[height][width];
		
		// 각 추첨 판에서의 확률을 저장할 3차원 배열 probabilities 초기화
		probabilities = new int[height][width][MAX_PROB_LENGTH];
		
		// for 반복문을 사용해 추첨 판의 각 행을 순회
		for (int r = 0; r < height; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 추첨 판의 각 열을 순회
			for (int c = 0; c < width; c++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 추첨 판의 상태를 변수 status에 할당
				int status = Integer.parseInt(st.nextToken());
				
				// 해당 위치에 못이 존재하는 경우 추첨 판의 상태를 갱신
				if (status == 1)
					board[r][c] = true;
				
				// 해당 위치가 공의 시작 위치인 경우 공의 시작 위치를 갱신
				if (status == 2)
					startIdx = c;
			}
		}
		
		// lotterySimulator() 메서드를 호출해 각 추첨 판에서의 확률을 갱신
		lotterySimulator(startIdx);
		
		// for 반복문을 사용해 각 추첨 번호를 순회
		for (int idx = 0; idx < width; idx++) {
			
			// 해당 위치의 당첨 확률이 저장된 최대 당첨 확률보다 높은 경우 최대 당첨 확률과 당첨될 확률이 가장 높은 번호를 갱신
			if (probComparator(maxProb, probabilities[height - 1][idx])) {
				maxProb = probabilities[height - 1][idx];
				maxIdx = idx;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 당첨될 확률이 가장 높은 번호를 출력
		out.write(String.valueOf(maxIdx));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// lotterySimulator() 메서드 정의
	public static void lotterySimulator(int startIdx) {
		
		// 현재 위치까지 공이 이동했는지 여부를 저장할 2차원 배열 moved 초기화
		boolean[][] moved = new boolean[height][width];
		
		// 다음에 확인할 위치를 저장할 Queue 객체 moveList 초기화
		Queue<int[]> moveList = new LinkedList<>();
		
		// 시작 위치에서의 확률을 갱신
		probabilities[0][startIdx][0] = 1;
		
		// offer() 메서드를 사용해 시작 위치를 moveList에 추가 및 시작 위치를 이동 처리
		moveList.offer(new int[] {0, startIdx});
		moved[0][startIdx] = true;
		
		// while 반복문을 사용해 moveList가 빌 때까지 순회
		while (!moveList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 위치를 배열 curPosition에 할당
			int[] curPosition = moveList.poll();
			
			// 현재 위치의 행과 열을 각 변수에 할당
			int curRow = curPosition[0];
			int curColumn = curPosition[1];
			
			// 마지막 줄에 도달한 경우 다음 위치를 순회
			if (curRow == height - 1)
				continue;
			
			// 다음 위치의 행을 변수 nextRow에 할당
			int nextRow = curRow + 1;
			
			// 아래에 못이 존재하는 경우
			if (board[nextRow][curColumn]) {
				
				// probDivider() 메서드를 호출해 확률의 절반을 배열 halfProb에 할당
				int[] halfProb = probDivider(probabilities[curRow][curColumn]);
				
				// 다음 칸의 위치를 저장할 배열 nextColumns 초기화
				int[] nextColumns = {curColumn - 1, curColumn + 1};
				
				// for 반복문을 사용해 각 다음 칸을 순회
				for (int nextColumn : nextColumns) {
					
					// 해당 위치로 공이 이동할 수 없는 경우 다음 위치를 순회
					if (board[nextRow][nextColumn] || board[curRow][nextColumn])
						continue;
						
					// probAdder() 메서드를 호출해 다음 위치의 확률을 갱신
					probabilities[nextRow][nextColumn] = probAdder(probabilities[nextRow][nextColumn], halfProb);
					
					// 다음 위치로 이동했던 경우 다음 위치를 순회
					if (moved[nextRow][nextColumn])
						continue;
				
					// offer() 메서드를 사용해 다음 위치를 moveList에 추가 및 다음 위치를 이동 처리
					moveList.offer(new int[] {nextRow, nextColumn});
					moved[nextRow][nextColumn] = true;
				}
			
			// 아래에 못이 존재하지 않는 경우
			} else {
				
				// probAdder() 메서드를 호출해 다음 위치의 확률을 갱신
				probabilities[nextRow][curColumn]
						= probAdder(probabilities[nextRow][curColumn], probabilities[curRow][curColumn]);
				
				// 다음 위치로 이동했던 경우 다음 위치를 순회
				if (moved[nextRow][curColumn])
					continue;
			
				// offer() 메서드를 사용해 다음 위치를 moveList에 추가 및 다음 위치를 이동 처리
				moveList.offer(new int[] {nextRow, curColumn});
				moved[nextRow][curColumn] = true;
			}
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// probDivider() 메서드 정의
	public static int[] probDivider(int[] curProb) {
		
		// 해당 확률의 절반을 저장할 배열 halfProb 초기화
		int[] halfProb = new int[MAX_PROB_LENGTH];
		
		// for 반복문을 사용해 해당 확률의 절반을 배열 halfProb에 저장
		for (int idx = MAX_PROB_LENGTH - 1; idx > 0; idx--)
			halfProb[idx] = curProb[idx - 1];
		
		// 해당 확률의 절반을 반환
		return halfProb;
	}
	
	// ----------------------------------------------------------------------------------------------------

	// probAdder() 메서드 정의
	public static int[] probAdder(int[] baseProb, int[] curProb) {
		
		// 두 확률의 합을 저장할 배열 nextProb 초기화
		int[] nextProb = new int[MAX_PROB_LENGTH];
		
		// for 반복문을 사용해 각 자릿수를 거꾸로 순회
		for (int idx = MAX_PROB_LENGTH - 1; idx >= 0; idx--) {
			
			// 현재 확률의 자릿수의 합을 갱신
			nextProb[idx] += baseProb[idx] + curProb[idx];
			
			// 자릿수가 2 이상인 경우 다음 자릿수로 올림 처리
			if (nextProb[idx] >= 2) {
				nextProb[idx - 1] += nextProb[idx] / 2;
				nextProb[idx] %= 2;
			}
		}
		
		// 두 확률의 합을 저장한 배열을 반환
		return nextProb;
	}
	
	// ----------------------------------------------------------------------------------------------------

	// probComparator() 메서드 정의
	public static boolean probComparator(int[] baseProb, int[] curProb) {
		
		// for 반복문을 사용해 각 확률의 자릿수를 순회
		for (int idx = 0; idx < MAX_PROB_LENGTH; idx++) {
			
			// 해당 자릿수가 동일한 경우 다음 자릿수를 순회
			if (baseProb[idx] == curProb[idx])
				continue;
			
			// 현재 확률이 기준 확률보다 높은지 여부를 반환
			return baseProb[idx] < curProb[idx];
		}
		
		// 두 확률이 동일한 경우 false 반환
		return false;
	}
}