package silver1.num14888;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 입력 받은 숫자를 저장할 배열, 입력 받은 연산자의 개수를 저장할 배열 초기화
	static int[] numbers;
	static int[] operators = new int[4];
	
	// 연산 결과의 최댓값과 최솟값을 저장할 각 변수 초기화
	static int maxResult = Integer.MIN_VALUE;
	static int minResult = Integer.MAX_VALUE;
	
	// ----------------------------------------------------------------------------------------------------

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수의 개수를 변수 numCnt에 할당
		int numCnt = Integer.parseInt(in.readLine());
		
		// 입력 받은 숫자를 저장할 배열 numbers 초기화
		numbers = new int[numCnt];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 숫자를 배열 numbers에 저장
		for (int idx = 0; idx < numbers.length; idx++)
			numbers[idx] = Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 숫자를 배열 operators에 저장
		for (int idx = 0; idx < operators.length; idx++)
			operators[idx] = Integer.parseInt(st.nextToken());
		
		// calculator() 메서드를 호출해 연산 결과의 최댓값과 최솟값을 갱신
		calculator(numbers[0], 1);
		
		// write() 메서드를 사용해 연산 결과의 최댓값과 최솟값을 출력
		out.write(maxResult + "\n" + minResult);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// calculator() 메서드 정의
	public static void calculator(int result, int nextIdx) {
		
		// 모든 연산이 끝난 경우
		if (nextIdx == numbers.length) {
			
			// 저장된 최댓값, 최솟값과 비교하여 최댓값 및 최솟값 갱신
			maxResult = (result > maxResult) ? result : maxResult;
			minResult = (result < minResult) ? result : minResult;

		// 모든 연산이 끝나지 않은 경우
		} else {
			
			// for 반복문을 사용해 각 연산자를 순회
			for (int idx = 0; idx < 4; idx++) {
				
				// 연산자가 1개 이상 있는 경우
				if (operators[idx] > 0) {
					
					// 사용한 연산자의 개수 조정
					operators[idx]--;
					
					// 연산자를 사용한 결과에 기초해 calculator() 메서드 재귀 호출
					if (idx == 0) calculator(result + numbers[nextIdx], nextIdx + 1);
					else if (idx == 1) calculator(result - numbers[nextIdx], nextIdx + 1);
					else if (idx == 2) calculator(result * numbers[nextIdx], nextIdx + 1);
					else calculator(result / numbers[nextIdx], nextIdx + 1);
					
					// 사용한 연산자의 개수 원래 상태로 복구
					operators[idx]++;
				}
			}
		}
	}
}