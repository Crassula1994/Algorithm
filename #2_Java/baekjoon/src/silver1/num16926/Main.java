package silver1.num16926;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 배열의 크기, 회전의 수를 저장할 각 변수 초기화
	static int row;
	static int column;
	static int rotation;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 배열의 크기 및 회전의 수를 각 변수에 할당
		row = Integer.parseInt(st.nextToken());
		column = Integer.parseInt(st.nextToken());
		rotation = Integer.parseInt(st.nextToken());
		
		// 현재 배열을 저장할 2차원 배열 array 초기화
		int[][] array = new int[row][column];
		
		// for 반복문을 사용해 배열의 각 행을 순회
		for (int r = 0; r < row; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// 입력 받은 각 원소를 2차원 배열 array에 저장
			for (int c = 0; c < column; c++)
				array[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// arrayRotator() 메서드를 호출해 회전을 시킨 결과를 배열 rotatedArray에 할당
		int[][] rotatedArray = arrayRotator(array);
		
		// for 반복문을 사용해 주어진 배열을 회전시킨 결과 각 원소를 출력
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < column; c++)
				out.write(rotatedArray[r][c] + " ");
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// arrayRotator() 메서드 정의
	public static int[][] arrayRotator(int[][] array) {
		
		// for 반복문을 사용해 회전의 횟수만큼 순회
		for (int rt = 0; rt < rotation; rt++) {
			
			// for 반복문을 사용해 회전시킬 고리의 각 왼쪽 상단 모서리를 순회
			for (int group = 0; group < Math.min(row, column) / 2; group++) {
				
				// 시작 지점의 값을 저장할 변수 start 초기화
				int start = array[group][group];
				
				// for 반복문을 사용해 위쪽 행의 회전을 수행
				for (int c = group; c < column - group - 1; c++)
					array[group][c] = array[group][c + 1];
				
				// for 반복문을 사용해 오른쪽 열의 회전을 수행
				for (int r = group; r < row - group - 1; r++)
					array[r][column - group - 1] = array[r + 1][column - group - 1];
				
				// for 반복문을 사용해 아래쪽 행의 회전을 수행
				for (int c = column - group - 1; c > group; c--)
					array[row - group - 1][c] = array[row - group - 1][c - 1];
				
				// for 반복문을 사용해 왼쪽 열의 회전을 수행
				for (int r = row - group - 1; r > group; r--)
					array[r][group] = array[r - 1][group];
				
				// 시작 지점의 값의 회전을 수행
				array[group + 1][group] = start;
			}
		}
		
		// 배열을 회전한 결과를 반환
		return array;
	}
}