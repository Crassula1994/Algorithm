package gold2.num17136;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 1이 적힌 모든 칸을 붙이는데 필요한 색종이의 최소 개수를 저장할 변수 minCnt 초기화
	static int minCnt = Integer.MAX_VALUE;
	
	// 각 색종이의 개수를 저장할 배열 cartolina 초기화
	static int[] cartolina = {0, 5, 5, 5, 5, 5};
	
	// 현재 종이의 상태를 저장할 2차원 배열 paper 초기화
	static int[][] paper = new int[10][10];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// for 반복문을 사용해 종이의 각 행을 순회
		for (int r = 0; r < 10; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 종이의 각 숫자를 2차원 배열 paper에 저장
			for (int c = 0; c < 10; c++)
				paper[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// cartolinaPaster() 메서드를 호출해 1이 적힌 모든 칸을 붙이는데 필요한 색종이의 최소 개수를 갱신
		cartolinaPaster(0, 0, 0);
		
		// 1을 모두 덮는 것이 불가능한 경우 -1을 출력
		if (minCnt == Integer.MAX_VALUE) {
			out.write(String.valueOf(-1));
		
		// 1을 모두 덮는 것이 가능한 경우 필요한 색종이의 최소 개수를 출력
		} else {
			out.write(String.valueOf(minCnt));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// cartolinaPaster() 메서드 정의
	public static void cartolinaPaster(int row, int column, int count) {
		
		// 저장된 색종이의 최소 개수보다 더 색종이를 많이 사용한 경우 메서드 종료
		if (count > minCnt)
			return;
		
		// 마지막 칸까지 모두 순회한 경우 색종이의 최소 개수 갱신 후 메서드 종료
		if (row == 9 && column == 10) {
			minCnt = Math.min(count, minCnt);
			return;
		}
		
		// 해당 줄을 모두 순회한 경우 다음 줄로 넘어가도록 cartolinaPaster() 메서드 재귀호출 후 메서드 종료
		if (column == 10) {
			cartolinaPaster(row + 1, 0, count);
			return;
		}
		
		// 해당 위치에 1이 존재하는 경우
		if (paper[row][column] == 1) {
			
			// for 반복문을 사용해 각 크기의 색종이를 순회
			for (int size = 5; size >= 1; size--) {
				
				// 해당 크기의 색종이를 붙일 수 있는 경우
				if (cartolina[size] > 0 && canPaste(row, column, size)) {
					
					// numberChanger() 메서드를 호출해 해당 색종이를 붙인 것으로 처리
					cartolina[size]--;
					numberChanger(row, column, size, 0);
					
					// cartolinaPaster() 메서드 재귀 호출
					cartolinaPaster(row, column + 1, count + 1);
					
					// numberChanger() 메서드를 호출해 해당 색종이를 뗀 것으로 처리
					cartolina[size]++;
					numberChanger(row, column, size, 1);
				}
			}
			
		// 해당 위치에 0이 존재하는 경우 cartolinaPaster() 메서드 재귀 호출
		} else {
			cartolinaPaster(row, column + 1, count);
		}
	}

	// ----------------------------------------------------------------------------------------------------
	
	// canPaste() 메서드 정의
	public static boolean canPaste(int row, int column, int size) {
		
		// 해당 크기의 색종이를 붙일 경우 종이의 경계 밖으로 벗어나는 경우 false 반환
		if (row + size - 1 > 9 || column + size - 1 > 9)
			return false;
		
		// for 반복문을 사용해 각 범위를 순회
		for (int r = row; r < row + size; r++) {
			for (int c = column; c < column + size; c++) {
				
				// 해당 값이 0인 경우 false 반환
				if (paper[r][c] == 0)
					return false;
			}
		}
		
		// 해당 크기의 색종이를 붙일 수 있는 경우 true 반환
		return true;
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// numberChanger() 메서드 정의 
	public static void numberChanger(int row, int column, int size, int targetNumber) {
		
		// for 반복문을 사용해 해당 범위의 값을 목표로 하는 값으로 변경
		for (int r = row; r < row + size; r++) {
			for (int c = column; c < column + size; c++)
				paper[r][c] = targetNumber;
		}
	}
}