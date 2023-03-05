package silver1.num01932;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {

	// 정수 삼각형 및 해당 위치까지의 최대 합을 저장할 각 2차원 배열 초기화
	static Integer[][] triangle;
	static Integer[][] summation;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 삼각형의 크기를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		// 정수 삼각형을 저장할 2차원 배열 triangle 초기화
		triangle = new Integer[size][size];
		
		// 해당 위치까지의 최대 합을 저장할 2차원 배열 summation 초기화
		summation = new Integer[size][size];
		
		// for 반복문을 사용해 2차원 배열 triangle의 각 행을 순회
		for (int r = 0; r < triangle.length; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 배열 triangle에 각 정수를 저장
			for (int c = 0; c < r + 1; c++)
				triangle[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// 첫 숫자까지의 최대 합을 초기화
		summation[0][0] = triangle[0][0];
		
		// 정수 삼각형의 최대 합을 저장할 변수 maxSum 초기화
		int maxSum = Integer.MIN_VALUE;
		
		// for 반복문을 사용해 maxSumFinder() 메서드를 호출하고 정수 삼각형의 최대 합을 갱신
		for (int idx = 0; idx < triangle.length; idx++)
			maxSum = Math.max(maxSumFinder(size - 1, idx), maxSum);
		
		// valueOf() 및 write() 메서드를 사용해 정수 삼각형의 최대 합을 출력
		out.write(String.valueOf(maxSum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// maxSumFinder() 메서드 정의
	public static int maxSumFinder(int row, int column) {
		
		// 최대 합이 저장되어 있는 경우 저장된 값 반환
		if (summation[row][column] != null) {
			return summation[row][column];
		
		// 최대 합이 저장되어 있지 않은 경우
		} else {
			
			// 삼각형 왼쪽 끝인 경우 바로 위쪽의 오른쪽만 선택할 수 있으므로 이를 계산해 배열 summation에 저장
			if (column == 0) {
				summation[row][column] = maxSumFinder(row - 1, 0) + triangle[row][column];
				
			// 삼각형 오른쪽 끝인 경우 바로 위쪽의 왼쪽만 선택할 수 있으므로 이를 계산해 배열 summation에 저장
			} else if (column == row) {
				summation[row][column] = maxSumFinder(row - 1, column - 1) + triangle[row][column];
			
			// 삼각형 중간에 위치한 경우 위쪽의 왼쪽과 오른쪽 모두 선택할 수 있으므로 이를 비교해 배열 summation에 저장
			} else {
				summation[row][column] = Math.max(maxSumFinder(row - 1, column - 1), maxSumFinder(row - 1, column)) + triangle[row][column];
			}
			
			// 저장한 값 반환
			return summation[row][column];
		}
	}
}