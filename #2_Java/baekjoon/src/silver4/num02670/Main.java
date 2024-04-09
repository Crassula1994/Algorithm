package silver4.num02670;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 양의 실수의 개수를 변수 decimalNum에 할당
		int decimalNum = Integer.parseInt(in.readLine());

		// 양의 실수 및 해당 실수까지의 최대곱을 저장할 각 배열 초기화
		double[] numbers = new double[decimalNum];
		double[] maxNumbers = new double[decimalNum];
		
		// for 반복문을 사용해 입력 받은 각 실수를 배열 numbers에 저장
		for (int idx = 0; idx < numbers.length; idx++)
			numbers[idx] = Double.parseDouble(in.readLine());
		
		// 첫 번째 실수까지의 최대곱을 갱신
		maxNumbers[0] = numbers[0];
		
		// 연속된 최대 곱을 저장할 변수 maxValue 초기화
		double maxValue = numbers[0];
		
		// for 반복문을 사용해 각 실수를 순회
		for (int idx = 1; idx < numbers.length; idx++) {
			
			// max() 메서드를 사용해 해당 실수까지의 최대곱 및 연속된 최대 곱을 갱신
			maxNumbers[idx] = Math.max(maxNumbers[idx - 1] * numbers[idx], numbers[idx]);
			maxValue = Math.max(maxNumbers[idx], maxValue);
		}
		
		// format() 및 write() 메서드를 사용해 연속된 최대 곱을 소수점 이하 셋째 자리까지 출력
		out.write(String.format("%.3f", maxValue));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}