package silver1.num19840;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 미샤 곱을 나눌 제수를 저장할 상수 DIVISOR 초기화
	static final int DIVISOR = 1000000007;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 집합의 원소의 개수를 변수 elementNum에 할당
		int elementNum = Integer.parseInt(in.readLine());
		
		// 모든 원소의 누적 합, 미샤 곱을 구한 결과를 저장할 각 변수 초기화
		long totalSum = 0;
		long mishaProduct = 0;
		
		// 각 원소와 그 자릿수의 길이를 저장할 각 배열 초기화
		long[] elements = new long[elementNum];
		int[] lengths = new int[elementNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 원소를 순회
		for (int idx = 0; idx < elementNum; idx++) {
			
			// nextToken() 메서드를 사용해 입력 받은 원소를 변수 element에 할당
			String element = st.nextToken();
			
			// parseInt() 및 length() 메서드를 사용해 해당 원소 및 그 자릿수의 길이를 각 배열에 저장
			elements[idx] = Integer.parseInt(element);
			lengths[idx] = element.length();
			
			// 모든 원소의 누적 합을 갱신
			totalSum += elements[idx];
		}
		
		// for 반복문을 사용해 각 원소를 순회
		for (int idx = 0; idx < elementNum; idx++) {
			
			// powerCalculator() 메서드를 호출해 해당 원소가 맨 뒤에 위치하고 나머지 원소를 앞에 배치한 경우의 수를 상정해 미샤 곱을 갱신
			mishaProduct += ((totalSum - elements[idx]) % DIVISOR * powerCalculator(10, lengths[idx])) % DIVISOR;
			mishaProduct += (elements[idx] * (elementNum - 1)) % DIVISOR;
			
			// 미샤 곱을 제수로 나누어 오버플로(Overflow) 방지
			mishaProduct %= DIVISOR;
		}
		
		// valueOf() 및 write() 메서드를 사용해 미샤 곱을 구한 결과를 출력
		out.write(String.valueOf(mishaProduct));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// powerCalculator() 메서드 정의
	public static long powerCalculator(int base, int exponent) {
		
		// 지수가 0인 경우 1을 반환
		if (exponent == 0)
			return 1;
		
		// powerCalculator() 메서드를 재귀호출해 지수의 절반만큼에 해당하는 거듭제곱을 계산한 결과를 변수 half에 할당
		long half = powerCalculator(base, exponent / 2);
		
		// 거듭제곱을 구한 결과를 반환
		return ((exponent & 1) == 1) ? (half * half * base) % DIVISOR : (half * half) % DIVISOR;
	}
}