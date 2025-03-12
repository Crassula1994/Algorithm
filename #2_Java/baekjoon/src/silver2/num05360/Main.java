package silver2.num05360;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 데이터 세트의 개수를 변수 dataSet에 할당
		int dataSet = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 데이터 세트를 순회
		while (dataSet-- > 0) {
			
			// readLine(), nextPermutationFinder(), write() 메서드를 사용해 입력 받은 숫자의 바로 다음 순열인 숫자를 출력
			out.write(nextPermutationFinder(in.readLine()));
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// nextPermutationFinder() 메서드 정의
	private static String nextPermutationFinder(String numberStr) {
		
		// toCharArray() 메서드를 사용해 입력 받은 숫자의 각 자릿수를 배열 digits에 저장
		char[] digits = numberStr.toCharArray();
		
		// for 반복문을 사용해 각 자릿수를 거꾸로 순회
		for (int idx = digits.length - 1; idx > 0; idx--) {
			
			// 해당 자릿수가 앞 자릿수보다 더 큰 경우
			if (digits[idx - 1] < digits[idx]) {
				
				/* 다음 순열을 찾을 기준점인 피벗 포인트(Pivot Point)의 위치, 피벗 포인트의 다음 자릿수로서
				피벗 포인트의 숫자와 바꿀 위치와 그 자릿수를 각 변수에 할당 */
				int pivotIdx = idx - 1;
				int nextPivotIdx = idx;
				char nextPivotDigit = digits[idx];
				
				// for 반복문을 사용해 해당 자릿수 다음의 각 자릿수를 순회
				for (int targetIdx = idx + 1; targetIdx < digits.length; targetIdx++) {
					
					/* 해당 자릿수의 숫자가 피벗 포인트의 숫자보다 크면서 저장된 바꿀 자릿수보다 작은 경우
					피벗 포인트의 숫자와 바꿀 위치 및 저장된 바꿀 자릿수를 갱신 */
					if (digits[targetIdx] > digits[idx - 1] && digits[targetIdx] < nextPivotDigit) {
						nextPivotDigit = digits[targetIdx];
						nextPivotIdx = targetIdx;
					}
				}
				
				// 피벗 포인트의 숫자와 바꿀 위치의 숫자를 교환
				char temp = digits[pivotIdx];
				digits[pivotIdx] = digits[nextPivotIdx];
				digits[nextPivotIdx] = temp;
				
				// sort() 메서드를 사용해 피벗 포인트 이후의 나머지 자릿수를 오름차순 정렬
				Arrays.sort(digits, idx, digits.length);
				
				// 각 자릿수의 배열을 문자열로 변환해 반환
				return new String(digits);
			}
		}
		
		// 입력 받은 숫자가 가능한 가장 큰 순열인 경우 'USELESS' 반환
		return "USELESS";
	}
}