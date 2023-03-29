package silver1.num11660;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 표의 크기 및 합을 구해야 하는 횟수를 각 변수에 할당
		int size = Integer.parseInt(st.nextToken());
		int testCase = Integer.parseInt(st.nextToken());
		
		// 입력 받은 숫자의 누적 합을 저장할 2차원 배열 table 초기화
		int[][] summation = new int[size + 1][size + 1];
		
		// for 반복문을 사용해 배열 table의 각 행을 순회
		for (int r = 1; r <= size; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 배열 table의 각 열을 순회하며 각 값을 table에 저장
			for (int c = 1; c <= size; c++)
				summation[r][c] = summation[r][c - 1] + Integer.parseInt(st.nextToken());
		}
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 네 개의 정수를 각 변수에 할당
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			// 해당 범위의 수의 합을 저장할 변수 sum 초기화
			int sum = 0;
			
			// for 반복문을 사용해 범위의 각 행을 순회하며 해당 범위의 수의 합을 갱신
			for (int r = x1; r <= x2; r++)
				sum += summation[r][y2] - summation[r][y1 - 1];
			
			// write() 메서드를 사용해 해당 범위에 존재하는 수의 합을 출력
			out.write(sum + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}