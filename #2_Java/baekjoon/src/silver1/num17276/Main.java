package silver1.num17276;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 배열의 상태를 저장할 2차원 배열 array 초기화
	static int[][] array;
	
	// ------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 배열의 크기와 각도를 각 변수에 할당
			int size = Integer.parseInt(st.nextToken());
			int angle = Integer.parseInt(st.nextToken());
			
			// 배열의 상태를 저장할 2차원 배열 array 초기화
			array = new int[size][size];
			
			// for 반복문을 사용해 각 행을 순회
			for (int r = 0; r < size; r++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// for 반복문을 사용해 각 배열의 원소를 2차원 배열 array에 저장
				for (int c = 0; c < size; c++)
					array[r][c] = Integer.parseInt(st.nextToken());
			}
			
			// arrayRotator() 메서드를 호출해 배열 돌리기를 수행
			arrayRotator(size, angle);
			
			// for 반복문을 사용해 배열을 돌린 결과를 출력
			for (int r = 0; r < size; r++) {
				for (int c = 0; c < size; c++)
					out.write(array[r][c] + " ");
				
				// newLine() 메서드를 사용해 줄바꿈 출력
				out.newLine();
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ------------------------------------------------------------------------------------------
	
	// arrayRotator() 메서드 정의
	public static void arrayRotator(int size, int angle) {
		
		// 360도가 입력된 경우 메서드 종료
		if (angle == 360 || angle == -360)
			return;
		
		// 시계 방향으로 45도씩 몇 번 돌려야 하는지를 계산해 변수 count에 할당
		int count = (angle < 0) ? (angle + 360) / 45 : angle / 45;
		
		// 배열을 돌린 결과를 저장할 2차원 배열 rotatedArray 초기화
		int[][] rotatedArray = new int[size][size];
		
		// for 반복문을 사용해 배열을 돌린 결과의 각 원소를 초기화
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++)
				rotatedArray[r][c] = array[r][c];
		}
		
		// while 반복문을 사용해 각 배열을 돌리는 횟수를 순회
		while (count-- > 0) {
			
			// for 반복문을 사용해 네 개 축을 돌리기
			for (int idx = 0; idx < size; idx++) {
				rotatedArray[idx][size / 2] = array[idx][idx];
				rotatedArray[idx][size - idx - 1] = array[idx][size / 2];
				rotatedArray[size / 2][idx] = array[size - idx - 1][idx];
				rotatedArray[idx][idx] = array[size / 2][idx];
	        }
			
			// for 반복문을 사용해 배열을 돌린 결과를 원본 배열에 반영
			for (int r = 0; r < size; r++) {
				for (int c = 0; c < size; c++)
					array[r][c] = rotatedArray[r][c];
			}
		}
	}
}