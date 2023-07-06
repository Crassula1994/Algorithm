package gold5.num25682;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 보드의 크기 및 목표 크기를 각 변수에 할당
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		int size = Integer.parseInt(st.nextToken());
		
		// 입력 받은 보드와 같은 크기의 체스판과 일치하지 않는 칸의 개수를 저장할 각 2차원 배열 초기화
		int[][] blackBoard = new int[height + 1][width + 1];
		int[][] whiteBoard = new int[height + 1][width + 1];
		
		// for 반복문을 사용해 보드의 각 행을 순회
		for (int r = 1; r <= height; r++) {
			
			// readLine() 메서드를 사용해 해당 행의 색상을 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 보드의 각 열을 순회
			for (int c = 1; c <= width; c++) {
				
				// charAt() 메서드를 사용해 해당 열의 색상을 변수 color에 할당
				char color = line.charAt(c - 1);
				
				// 해당 위치의 색상이 검은색인지 여부를 나타내는 변수 isBlack 초기화
				boolean isBlack = (color == 'B') ? true : false;
				
				// 이전까지의 누적합을 각 변수에 할당
				int blackSum = blackBoard[r - 1][c] + blackBoard[r][c - 1] - blackBoard[r - 1][c - 1];
				int whiteSum = whiteBoard[r - 1][c] + whiteBoard[r][c - 1] - whiteBoard[r - 1][c - 1];
				
				// 짝수 행, 짝수 열인 경우 체스판과 일치하지 않는 칸의 개수를 각 2차원 배열에 저장
				if ((r + c) % 2 == 0) {
					blackBoard[r][c] = (isBlack) ? blackSum + 1 : blackSum;
					whiteBoard[r][c] = (isBlack) ? whiteSum : whiteSum + 1;
				
				// 홀수행, 홀수 열인 경우 체스판과 일치하지 않는 칸의 개수를 각 2차원 배열에 저장
				} else {
					blackBoard[r][c] = (isBlack) ? blackSum : blackSum + 1;
					whiteBoard[r][c] = (isBlack) ? whiteSum + 1 : whiteSum;
				}
			}
		}
		
		// 다시 칠해야 하는 정사각형 개수의 최솟값을 저장할 변수 minCnt 초기화
		int minCnt = Integer.MAX_VALUE;
		
		// for 반복문을 사용해 각 목표 크기의 행과 열을 순회
		for (int r = size; r <= height; r++) {
			for (int c = size; c <= width; c++) {
				
				// min() 메서드를 사용해 다시 칠해야 하는 정사각형 개수의 최솟값을 갱신
				int count = Math.min(
					blackBoard[r][c] - blackBoard[r - size][c] - blackBoard[r][c - size] + blackBoard[r - size][c - size],
					whiteBoard[r][c] - whiteBoard[r - size][c] - whiteBoard[r][c - size] + whiteBoard[r - size][c - size]
				);
				minCnt = Math.min(minCnt, count);
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 다시 칠해야 하는 정사각형 개수의 최솟값을 출력
		out.write(String.valueOf(minCnt));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}