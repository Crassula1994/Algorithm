package gold5.num02447;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {

	// 별과 빈 칸을 저장할 2차원 배열 patterns 초기화
	static char[][] patterns;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 배열의 크기를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		// 별과 빈 칸을 저장할 2차원 배열 patterns 초기화
		patterns = new char[size][size];
		
		// patternMaker() 메서드를 호출해 패턴을 2차원 배열에 저장
		patternMaker(size, 0, 0, false);

		// for 반복문을 사용해 2차원 배열의 행과 열을 순회
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++)
				
				// write() 메서드를 사용해 별 또는 빈칸을 출력
				out.write(patterns[r][c]);
			
			// write() 메서드를 사용해 줄 바꿈 출력
			out.write("\n");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// patternMaker() 메서드 정의
	public static void patternMaker(int size, int startRow, int startCol, boolean isBlank) {
		
		// 3 × 3 크기의 공간으로 분할하기 위해 입력 받은 크기를 갱신해 변수 newSize에 할당
		int newSize = size / 3;
		
		// 빈 칸을 출력해야 하는 경우
		if (isBlank) {
			
			// for 반복문을 사용해 해당 크기의 행과 열을 순회하며 빈 칸 저장
			for (int r = startRow; r < startRow + size; r++) {
				for (int c = startCol; c < startCol + size; c++)
					patterns[r][c] = ' ';
			}
		
		// 입력 받은 크기가 1인 경우
		} else if (size == 1) {
			
			// 해당 칸에 별 저장
			patterns[startRow][startCol] = '*';
		
		// 빈 칸도 아니고 입력 받은 크기도 1이 아닌 경우
		} else {
			
			// for 반복문을 사용해 분할한 3 × 3 크기의 공간을 순회
			for (int r = startRow, cnt = 0; r < startRow + size; r += newSize) {
				for (int c = startCol; c < startCol + size ; c += newSize) {
					
					// 가운데 빈 칸 구역인지, 별을 출력하는 구역인지에 따라 patternMaker() 메서드 재귀 호출
					patternMaker(newSize, r, c, ++cnt == 5);
				}
			}
		}
	}
}