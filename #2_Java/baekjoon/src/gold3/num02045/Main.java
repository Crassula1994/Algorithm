package gold3.num02045;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 마방진을 저장할 2차원 배열 magicSquare 초기화
	static int[][] magicSquare = new int[3][3];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// for 반복문을 사용해 마방진의 각 행을 순회
		for (int r = 0; r < 3; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 마방진의 입력 받은 각 값을 2차원 배열 magicSquare에 저장
			for (int c = 0; c < 3; c++)
				magicSquare[r][c] = Integer.parseInt(st.nextToken());
		}
			
		// sumFinder() 메서드를 호출해 마방진의 각 줄이 이루어야 하는 합을 변수 targetSum에 할당
		int targetSum = sumFinder();
		
		// sqaureMaker() 메서드를 호출해 마방진을 완성
		squareMaker(targetSum);
		
		// for 반복문을 사용해 완성된 마방진을 출력
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++)
				out.write(magicSquare[r][c] + " ");
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// sumFinder() 메서드 정의
	public static int sumFinder() {
		
		// 마방진의 각 줄이 이루어야 하는 합을 저장할 변수 sum 초기화
		int sum = 0;
		
		// 대각선이 모두 지워진 경우
		if (isEmptyDiagonalLine()) {
			
			// for 반복문을 사용해 마방진의 총합을 갱신
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 3; c++)
					sum += magicSquare[r][c];
			}
			
			// 마방진의 각 줄이 이루어야 하는 합을 반환
			return sum / 2;
		}
		
		// for 반복문을 사용해 각 행과 열에 대해 마방진의 각 줄이 이루어야 하는 합을 갱신
		for (int idx = 0; idx < 3; idx++) {
			sum = Math.max(magicSquare[idx][0] + magicSquare[idx][1] + magicSquare[idx][2], sum);
			sum = Math.max(magicSquare[0][idx] + magicSquare[1][idx] + magicSquare[2][idx], sum);
		}
		
		// max() 메서드를 사용해 각 대각선에 대해 마방진의 각 줄이 이루어야 하는 합을 갱신
		sum = Math.max(magicSquare[0][0] + magicSquare[1][1] + magicSquare[2][2], sum);
		sum = Math.max(magicSquare[0][2] + magicSquare[1][1] + magicSquare[2][0], sum);
		
		// 마방진의 각 줄이 이루어야 하는 합을 반환
		return sum;
	}
	
	// ----------------------------------------------------------------------------------------------------

	// isEmptyDiagonalLine() 메서드 정의
	public static boolean isEmptyDiagonalLine() {
		
		// 정방향 대각선이 모두 지워진 경우 true를 반환 
		if (magicSquare[0][0] + magicSquare[1][1] + magicSquare[2][2] == 0)
			return true;
		
		// 역방향 대각선이 모두 지워진 경우 true를 반환
		if (magicSquare[0][2] + magicSquare[1][1] + magicSquare[2][0] == 0)
			return true;
		
		// 대각선이 모두 지워지지 않은 경우 false를 반환
		return false;
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// squareMaker() 메서드 정의
	public static void squareMaker(int targetSum) {
		
		// for 반복문을 사용해 각 칸을 순회
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				
				// 해당 칸이 지워진 수가 아닌 경우 다음 칸을 순회
				if (magicSquare[r][c] != 0)
					continue;
				
				// numberFinder() 메서드를 호출해 해당 칸에 들어갈 수를 갱신
				magicSquare[r][c] = numberFinder(r, c, targetSum);
			}
		}
	}
	
	// ----------------------------------------------------------------------------------------------------

	// numberFinder() 메서드 정의
	public static int numberFinder(int curRow, int curColumn, int targetSum) {
		
		// for 반복문을 사용해 현재 숫자가 속한 행을 순회
		for (int c = 0, curSum = 0; c < 3; c++) {
			
			// 해당 행에 또 다른 지워진 수가 있는 경우 반복문 탈출
			if (c != curColumn && magicSquare[curRow][c] == 0)
				break;
			
			// 현재 행의 합을 갱신
			curSum += magicSquare[curRow][c];
			
			// 마지막 칸인 경우 해당 칸에 들어갈 수를 반환
			if (c == 2)
				return targetSum - curSum;
		}
		
		// for 반복문을 사용해 현재 숫자가 속한 열을 순회
		for (int r = 0, curSum = 0; r < 3; r++) {
			
			// 해당 열에 또 다른 지워진 수가 있는 경우 반복문 탈출
			if (r != curRow && magicSquare[r][curColumn] == 0)
				break;
			
			// 현재 열의 합을 갱신
			curSum += magicSquare[r][curColumn];
			
			// 마지막 칸인 경우 해당 칸에 들어갈 수를 반환
			if (r == 2)
				return targetSum - curSum;
		}
		
		// 정방향 대각선에 속한 경우 해당 칸에 들어갈 수를 반환
		if (curRow == curColumn)
			return targetSum - (magicSquare[0][0] + magicSquare[1][1] + magicSquare[2][2]);
		
		// 역박향 대각선에 속한 경우 해당 칸에 들어갈 수를 반환
		return targetSum - (magicSquare[0][2] + magicSquare[1][1] + magicSquare[2][0]);
	}
}