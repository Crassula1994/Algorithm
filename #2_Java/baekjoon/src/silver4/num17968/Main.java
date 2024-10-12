package silver4.num17968;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 수열의 각 원소를 저장할 배열 sequence 초기화
	static int[] sequence;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 찾고자 하는 수열의 원소 순서를 변수 targetElement에 할당
		int targetElement = Integer.parseInt(in.readLine());
		
		// 2 미만의 원소인 경우 1을 출력
		if (targetElement < 2) {
			out.write(String.valueOf(1));
		
		// 2 이상의 원소인 경우
		} else {
			
			// 수열의 각 원소를 저장할 배열 sequence 초기화
			sequence = new int[targetElement + 1];
			
			// 수열의 0번째와 1번째 원소의 값을 초기화
			sequence[0] = 1;
			sequence[1] = 1;
			
			// for 반복문을 사용해 각 수열의 원소를 순회
			for (int idx = 2; idx < sequence.length; idx++) {
				
				// 해당 원소의 값을 초기화
				sequence[idx] = 1;
				
				// while 반복문을 사용해 해당 원소의 값이 될 수 있는 최소의 숫자를 찾아 갱신
				while (!elementFinder(idx, sequence[idx]))
					sequence[idx]++;
			}
			
			// valueOf() 및 write() 메서드를 사용해 찾고자 하는 수열의 원소 순서에 해당하는 원소를 출력
			out.write(String.valueOf(sequence[targetElement]));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// elementFinder() 메서드 정의
	public static boolean elementFinder(int idx, int value) {
		
		// for 반복문을 사용해 해당 원소가 만족해야 하는 각 조건을 순회
		for (int k = 1; idx - 2 * k >= 0; k++) {
			
			// 해당 원소가 해당 조건을 만족하지 않는 경우 false 반환
			if (sequence[idx] - sequence[idx - k] == sequence[idx - k] - sequence[idx - 2 * k])
				return false;
		}
		
		// 해당 원소가 수열의 조건을 모두 만족하는 경우 true 반환
		return true;
	}
}