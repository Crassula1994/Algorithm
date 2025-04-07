package gold4.num13707;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 목표 정수를 만들 수 있는 경우의 수를 나눌 수를 저장할 상수 DIVISOR 초기화
	static final int DIVISOR = 1_000_000_000;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 목표 정수, 목표 정수를 만들기 위해 합칠 정수의 개수를 각 변수에 할당
		int targetNumber = Integer.parseInt(st.nextToken());
		int countLimit = Integer.parseInt(st.nextToken());
		
		// 합칠 정수의 개수별 각 목표 정수를 만들 수 있는 경우의 수를 저장할 2차원 배열 counts 초기화
		int[][] counts = new int[targetNumber + 1][countLimit + 1];
		
		// fill() 메서드를 사용해 0을 각 합칠 정수의 개수별로 만들 수 있는 경우의 수를 초기화
		Arrays.fill(counts[0], 1);
		
		// for 반복문을 사용해 각 숫자를 순회
		for (int number = 1; number <= targetNumber; number++) {
			
			// for 반복문을 사용해 합칠 정수의 개수별 만들 수 있는 경우의 수를 갱신
			for (int sumCount = 1; sumCount <= countLimit; sumCount++)
				counts[number][sumCount] = (counts[number - 1][sumCount] + counts[number][sumCount - 1]) % DIVISOR;
		}
		
		// valueOf() 및 write() 메서드를 사용해 목표 정수를 만들 수 있는 경우의 수를 출력
		out.write(String.valueOf(counts[targetNumber][countLimit]));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}