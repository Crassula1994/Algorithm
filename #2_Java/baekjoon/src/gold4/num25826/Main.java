package gold4.num25826;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 2차원 배열의 크기 및 질의의 개수를 각 변수에 할당
		int size = Integer.parseInt(st.nextToken());
		int queryNum = Integer.parseInt(st.nextToken());
		
		// 2차원 배열의 각 원소 초깃값, 각 원소에 더한 값, 각 원소까지의 누적 합을 저장할 각 2차원 배열 초기화
		int[][] array = new int[size + 1][size + 1];
		long[][] addedValues = new long[size + 2][size + 2];
		long[][] arraySum = new long[size + 1][size + 1];
		
		// for 반복문을 사용해 2차원 배열의 각 행을 순회
		for (int r = 1; r <= size; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 2차원 배열의 각 원소 초깃값을 2차원 배열 array에 저장
			for (int c = 1; c <= size; c++)
				array[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// while 반복문을 사용해 각 질의를 순회
		while (queryNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 질의의 종류, 질의의 대상 범위를 각 변수에 할당
			int category = Integer.parseInt(st.nextToken());
			int startRow = Integer.parseInt(st.nextToken()) + 1;
			int startColumn = Integer.parseInt(st.nextToken()) + 1;
			int endRow = Integer.parseInt(st.nextToken()) + 1;
			int endColumn = Integer.parseInt(st.nextToken()) + 1;
			
			// 질의의 종류가 유형 1인 경우
			if (category == 1) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 더해야 할 값을 변수 value에 할당
				int value = Integer.parseInt(st.nextToken());
				
				// IMOS 기법을 사용해 각 범위에 더해야 할 값을 2차원 배열 addedValues에 갱신
				addedValues[startRow][startColumn] += value;
				addedValues[startRow][endColumn + 1] -= value;
				addedValues[endRow + 1][startColumn] -= value;
				addedValues[endRow + 1][endColumn + 1] += value;
				
			// 질의의 종류가 유형 2인 경우
			} else {
				
				// for 반복문을 사용해 각 행에 대하여 더해야 할 값을 갱신
				for (int r = 1; r <= size + 1; r++) {
					for (int c = 1; c <= size + 1; c++)
						addedValues[r][c] += addedValues[r][c - 1];
				}
				
				// for 반복문을 사용해 각 열에 대하여 더해야 할 값을 갱신
				for (int c = 1; c <= size + 1; c++) {
					for (int r = 1; r <= size + 1; r++)
						addedValues[r][c] += addedValues[r - 1][c];
				}
				
				// for 반복문을 사용해 각 원소까지의 누적합을 2차원 배열 arraySum에 저장
				for (int r = 1; r <= size; r++) {
					for (int c = 1; c <= size; c++)
						arraySum[r][c] = arraySum[r - 1][c] + arraySum[r][c - 1] - arraySum[r - 1][c - 1]
								+ array[r][c] + addedValues[r][c];
				}
				
				// 유형 2의 질의 결과를 계산해 변수 result에 할당
				long result = arraySum[endRow][endColumn] - arraySum[endRow][startColumn - 1]
						- arraySum[startRow - 1][endColumn] + arraySum[startRow - 1][startColumn - 1];
				
				// valueOf() 및 write() 메서드를 사용해 유형 2의 질의 결과를 출력
				out.write(String.valueOf(result));
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}