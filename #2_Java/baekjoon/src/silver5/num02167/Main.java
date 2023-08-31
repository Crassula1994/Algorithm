package silver5.num02167;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 배열의 크기를 각 변수에 할당
		int row = Integer.parseInt(st.nextToken());
		int column = Integer.parseInt(st.nextToken());		
		
		// 각 누적 합을 저장할 2차원 배열 sumArray 초기화
		int[][] sumArray = new int[row + 1][column + 1];
		
		// for 반복문을 사용해 배열의 각 행을 순회
		for (int r = 1; r <= row; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 누적 합을 배열 sumArray에 저장
			for (int c = 1; c <= column; c++)
				sumArray[r][c] = sumArray[r][c - 1] + Integer.parseInt(st.nextToken());
		}
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 부분의 개수를 변수 partNum에 할당
		int partNum = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 부분을 순회
		for (int p = 0; p < partNum; p++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 위치 정보를 각 변수에 할당
			int startRow = Integer.parseInt(st.nextToken());
			int startCol = Integer.parseInt(st.nextToken());
			int endRow = Integer.parseInt(st.nextToken());
			int endCol = Integer.parseInt(st.nextToken());
			
			// 총 누적 합을 저장할 변수 sum 초기화
			int sum = 0;
			
			// for 반복문을 사용해 총 누적 합을 갱신
			for (int r = startRow; r <= endRow; r++)
				sum += sumArray[r][endCol] - sumArray[r][startCol - 1];
				
			// write() 메서드를 사용해 총 누적 합을 출력
			out.write(sum + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}