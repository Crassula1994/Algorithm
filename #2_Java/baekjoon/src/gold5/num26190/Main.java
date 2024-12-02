package gold5.num26190;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자의 개수를 변수 numberCount에 할당
		int numberCount = Integer.parseInt(in.readLine());
		
		// 가장 작은 정규화된 값과 최소 오차를 저장할 각 변수 초기화
		double minValue = Double.MAX_VALUE;
		double minError = Double.MAX_VALUE;
		
		// 정규화된 숫자 목록과 원래 숫자 목록을 저장할 각 배열 초기화
		double[] normalizedList = new double[numberCount];
		long[] denormalizedList = new long[numberCount];
		
		// for 반복문을 사용해 각 정규화된 값을 순회
		for (int idx = 0; idx < normalizedList.length; idx++) {
			
			// readLine() 및 parseDouble() 메서드를 사용해 입력 받은 정규화된 숫자를 배열 normalizedList에 저장
			normalizedList[idx] = Double.parseDouble(in.readLine());
			
			// min() 메서드를 사용해 가장 작은 정규화된 값을 갱신
			minValue = Math.min(normalizedList[idx], minValue);
		}
		
		// for 반복문을 사용해 각 정규화된 값을 1 이상으로 조정
		for (int idx = 0; idx < normalizedList.length; idx++)
			normalizedList[idx] /= minValue;

		// for 반복문을 사용해 가능한 각 정규화 상수를 순회
		for (int scale = 1; scale <= 10000; scale++) {
			
			// 현재 정규화 상수에서의 오차를 저장할 변수 curError 초기화
			double curError = 0;
			
			// 현재 정규화 상수에서 복원해 반올림한 값을 저장할 배열 scaledList 초기화
			long[] scaledList = new long[numberCount];

			// for 반복문을 사용해 각 숫자를 순회
			for (int idx = 0; idx < normalizedList.length; idx++) {
				
				// round() 메서드를 사용해 복원한 값과 이를 반올림한 값을 각 변수에 할당
				double scaledValue = normalizedList[idx] * scale;
				long roundedValue = Math.round(scaledValue);
				
				// 현재 정규화 상수에서 복원해 반올림한 값을 배열 scaledList에 저장
				scaledList[idx] = roundedValue;
				
				// abs() 및 max() 메서드를 사용해 현재 정규화 상수에서의 오차를 갱신
				curError = Math.max(Math.abs(roundedValue - scaledValue), curError);
			}
			
			// 현재 정규화 상수에서의 오차가 저장된 오차보다 더 적은 경우 최소 오차와 원래 숫자 목록을 갱신
			if (curError < minError) {
				minError = curError;
				denormalizedList = scaledList;
			}
		}
		
		// for 반복문을 사용해 원래 숫자 목록을 출력
		for (long value : denormalizedList)
			out.write(value + "\n");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}