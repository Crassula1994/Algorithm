package silver2.num10997;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// Main 클래스 정의
public class Main {
	
	// 입력 받은 숫자, 모양의 크기를 저장할 각 변수 초기화
	static int number;
	static int height;
	static int width;
	
	// 모양을 저장할 2차원 배열 shape 초기화
	static char[][] shape;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
		number = Integer.parseInt(in.readLine());
		
		// 입력 받은 숫자가 1인 경우 별 하나를 출력
		if (number == 1) {
			out.write("*");
			
		// 입력 받은 숫자가 2 이상인 경우
		} else {
			
			// 모양의 크기를 저장할 각 변수 초기화
			height = 4 * number - 1;
			width = 4 * number - 3; 
			
			// 모양을 저장할 2차원 배열 shape 초기화
			shape = new char[height][width];
			
			// for 반복문을 사용해 모양을 빈 칸으로 채우기
			for (int r = 0; r < height; r++)
				Arrays.fill(shape[r], ' ');
			
			// shapeMaker() 메서드를 호출해 모양을 생성
			shapeMaker(1);
			
			// for 반복문을 사용해 모양을 출력
			for (int r = 0; r < height; r++) {
				for (int c = 0; c < width; c++) {
					out.write(shape[r][c]);
					
					// 첫 번째 줄인 경우 반복문 탈출
					if (r == 1)
						break;
				}
				
				// newLine() 메서드를 사용해 줄바꿈을 출력
				out.newLine();
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// shapeMaker() 메서드 정의
	public static void shapeMaker(int depth) {
		
		// 가장 안쪽인 경우
		if (depth == number) {
			
			// for 반복문을 사용해 가장 안쪽의 모양을 갱신
			for (int r = height / 2 - 1; r <= height / 2 + 1; r++)
				shape[r][width / 2] = '*';
			
			// 메서드 종료
			return;
		}
		
		// 해당 모양의 각 위치를 각 변수에 할당
		int leftLimit = 2 * depth - 2;
		int rightLimit = width - leftLimit - 1;
		int upperLimit = leftLimit;
		int lowerLimit = height - leftLimit - 1;
		
		// for 반복문을 사용해 위쪽과 아래쪽의 칸에 별을 삽입
		for (int c = leftLimit; c <= rightLimit; c++) {
			shape[upperLimit][c] = '*';
			shape[lowerLimit][c] = '*';
		}
		
		// for 반복문을 사용해 왼쪽의 칸에 별을 삽입
		for (int r = upperLimit + 1; r < lowerLimit; r++)
			shape[r][leftLimit] = '*';
		
		// for 반복문을 사용해 오른쪽의 칸에 별을 삽입
		for (int r = upperLimit + 2; r < lowerLimit; r++)
			shape[r][rightLimit] = '*';
		
		// 다음 모양과의 연결 부분에 별을 삽입
		shape[upperLimit + 2][rightLimit - 1] = '*';
		
		// shapeMaker() 메서드 재귀 호출
		shapeMaker(depth + 1);
	}
}