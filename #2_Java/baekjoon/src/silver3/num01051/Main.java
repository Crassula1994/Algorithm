package silver3.num01051;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 직사각형의 크기를 각 변수에 할당
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());

		// 직사각형 각 칸에 저장된 숫자 정보를 저장할 2차원 배열 square 초기화
		int[][] square = new int[height][width];

		// for 반복문을 사용해 배열 square의 각 행을 순회
		for (int r = 0; r < height; r++) {

			// readLine() 메서드를 사용해 입력 받은 행의 숫자를 변수 line에 할당
			String line = in.readLine();

			// for 반복문을 사용해 배열 square에 입력 받은 숫자를 저장
			for (int c = 0; c < width; c++)
				square[r][c] = line.charAt(c);
		}

		// min() 메서드를 사용해 꼭짓점의 수가 모두 같은 가장 큰 정사각형의 크기를 저장할 변수 maxSize 초기화
		int maxSize = Math.min(height, width);

		// for 반복문을 사용해 각 정사각형의 크기를 차례로 순회
		outer: for (int size = maxSize; size >= 1; size--) {

			// 크기가 1인 경우 가장 큰 정사각형의 크기를 갱신 후 반복문 탈출
			if (size == 1) {
				maxSize = size;
				break;
			}

			// for 반복문을 사용해 각 정사각형의 시작 지점을 순회
			for (int r = 0; r < height - size + 1; r++) {
				for (int c = 0; c < width - size + 1; c++) {
					
					// 정사각형 네 모퉁이의 값을 각 변수에 할당
					int upperLeft = square[r][c];
					int upperRight = square[r][c + size - 1];
					int lowerLeft = square[r + size - 1][c];
					int lowerRight = square[r + size - 1][c + size - 1];

					// 해당 정사각형의 네 모퉁이의 값이 같은 경우 가장 큰 정사각형의 크기를 갱신 후 반복문 탈출
					if (upperLeft == upperRight && upperRight == lowerLeft && lowerLeft == lowerRight) {
						maxSize = size;
						break outer;
					}
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 가장 큰 정사각형의 크기를 출력
		out.write(String.valueOf(maxSize * maxSize));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}