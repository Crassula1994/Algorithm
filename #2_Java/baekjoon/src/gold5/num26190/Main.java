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
		
		// 가장 작은 정규화된 값을 저장할 minValue 초기화
		double minValue = Double.MAX_VALUE;
		
		// 정규화된 숫자 목록을 저장할 배열 normalizedNumbers 초기화
		double[] normalizedNumbers = new double[numberCount];
		
		// for 반복문을 사용해 각 정규화된 값을 순회
		for (int idx = 0; idx < normalizedNumbers.length; idx++) {
			
			// readLine() 및 parseDouble() 메서드를 사용해 입력 받은 정규화된 숫자를 배열 normalizedNumbers에 저장
			normalizedNumbers[idx] = Double.parseDouble(in.readLine());
			
			// min() 메서드를 사용해 가장 작은 정규화된 값을 갱신
			minValue = Math.min(normalizedNumbers[idx], minValue);
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}