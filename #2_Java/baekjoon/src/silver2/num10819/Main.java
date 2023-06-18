package silver2.num10819;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 입력 받은 정수의 개수, 식의 최댓값을 저장할 각 변수 초기화
	static int numberCnt;
	static int maxValue = Integer.MIN_VALUE;
	
	// 각 정수를 저장할 배열 numArray 초기화
	static int[] numArray;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 정수의 개수를 변수 numberCnt에 할당
		numberCnt = Integer.parseInt(in.readLine());
		
		// 각 정수를 저장할 배열 numArray 초기화
		numArray = new int[numberCnt];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 정수를 배열 numArray에 저장
		for (int idx = 0; idx < numArray.length; idx++)
			numArray[idx] = Integer.parseInt(st.nextToken());
		
		// 각 배열 숫자의 선택 여부, 선택한 숫자를 저장할 각 배열 초기화
		boolean[] isSelected = new boolean[numberCnt];
		Integer[] newArray = new Integer[numberCnt];
		
		// formulaCalculator() 메서드를 사용해 식의 최댓값을 갱신
		formulaCalculator(0, isSelected, newArray);
		
		// valueOf() 및 write() 메서드를 사용해 식의 최댓값을 출력
		out.write(String.valueOf(maxValue));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// formulaCalculator() 메서드 정의
	public static void formulaCalculator(int depth, boolean[] isSelected, Integer[] newArray) {
		
		// 모든 숫자를 선택한 경우
		if (depth == numberCnt) {
			
			// 식의 계산 결과를 저장할 변수 result 초기화
			int result = 0;
			
			// for 반복문을 사용해 식의 계산 결과를 갱신
			for (int idx = 0; idx < newArray.length - 1; idx++)
				result += Math.abs(newArray[idx] - newArray[idx + 1]);
			
			// max() 메서드를 사용해 식의 최댓값을 갱신
			maxValue = Math.max(result, maxValue);
			
			// 메서드 종료
			return;
		}
		
		// for 반복문을 사용해 주어진 배열의 각 숫자를 순회
		for (int idx = 0; idx < numArray.length; idx++) {
			
			// 해당 숫자를 선택하지 않은 경우
			if (!isSelected[idx]) {
				
				// 해당 숫자 선택 처리
				isSelected[idx] = true;
				newArray[depth] = numArray[idx];
				
				// formulaCalculator() 메서드 재귀 호출
				formulaCalculator(depth + 1, isSelected, newArray);
				
				// 해당 숫자 선택 원상복구 처리
				isSelected[idx] = false;
				newArray[depth] = null;
			}
		}
	}
}