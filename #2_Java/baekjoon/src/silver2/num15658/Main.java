package silver2.num15658;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 만들 수 있는 식의 결과의 최댓값과 최솟값을 저장할 각 변수 초기화
	static int maxResult = Integer.MIN_VALUE;
	static int minResult = Integer.MAX_VALUE;
	
	// 각 숫자와 연산자의 개수를 저장할 각 배열 초기화
	static int[] numbers;
	static int[] operators = new int[4];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수의 개수를 변수 numberCnt에 할당
		int numberCnt = Integer.parseInt(in.readLine());
		
		// 각 숫자를 저장할 배열 numbers 초기화
		numbers = new int[numberCnt];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 숫자를 배열 numbers에 저장
		for (int idx = 0; idx < numbers.length; idx++)
			numbers[idx] = Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 연산자의 개수를 배열 operators에 저장
		for (int idx = 0; idx < operators.length; idx++)
			operators[idx] = Integer.parseInt(st.nextToken());
		
		// formulaCalculator() 메서드를 호출해 만들 수 있는 식의 결과의 최댓값과 최솟값을 갱신
		formulaCalculator(1, numbers[0]);
		
		// write() 메서드를 사용해 만들 수 있는 식의 결과의 최댓값과 최솟값을 출력
		out.write(maxResult + "\n" + minResult);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// formulaCalculator() 메서드 정의
	public static void formulaCalculator(int curNum, int result) {
		
		// 모든 숫자를 계산한 경우
		if (curNum == numbers.length) {
			
			// max() 및 min() 메서드를 사용해 만들 수 있는 식의 결과의 최댓값과 최솟값을 갱신
			maxResult = Math.max(result, maxResult);
			minResult = Math.min(result, minResult);
			
			// 메서드 종료
			return;
		}
		
		// for 반복문을 사용해 각 연산자를 순회
		for (int operator = 0; operator < 4; operator++) {
			
			// 해당 연산자를 모두 사용한 경우 다음 연산자를 순회
			if (operators[operator] == 0)
				continue;
			
			// 해당 연산자를 사용한 것으로 처리
			operators[operator]--;
			
			// switch 조건문을 사용해 연산자에 따라 결과를 갱신해 formulaCalculator() 메서드 재귀 호출
			switch (operator) {
				case 0:
					formulaCalculator(curNum + 1, result + numbers[curNum]);
					break;
				case 1:
					formulaCalculator(curNum + 1, result - numbers[curNum]);
					break;
				case 2:
					formulaCalculator(curNum + 1, result * numbers[curNum]);
					break;
				default:
					formulaCalculator(curNum + 1, result / numbers[curNum]);
			}
			
			// 해당 연산자를 사용하지 않은 것으로 원상복구 처리
			operators[operator]++;
		}
	}
}