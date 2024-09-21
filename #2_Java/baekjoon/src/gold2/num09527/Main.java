package gold2.num09527;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 입력 받을 수 있는 자연수의 최댓값을 저장할 상수 MAX_VALUE 초기화
	static final long MAX_VALUE = (long) 1e16;
	
	/* toBinaryString() 및 length() 메서드를 사용해 이진수의 길이에 따른
	1의 개수의 누적 합을 저장할 배열 bitCountSum 초기화 */
	static long[] bitCountSum = new long[Long.toBinaryString(MAX_VALUE).length() + 1];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseLong() 메서드를 사용해 입력 받은 두 자연수를 각 변수에 할당
		long startNumber = Long.parseLong(st.nextToken());
		long endNumber = Long.parseLong(st.nextToken());
		
		// for 반복문을 사용해 이진수의 길이에 따른 1의 개수의 누적 합을 갱신
		for (int idx = 1; idx < bitCountSum.length; idx++)
			bitCountSum[idx] = (bitCountSum[idx - 1] << 1) + (1L << (idx - 1));
		
		// bitCountCalculator() 메서드를 호출해 두 자연수 사이의 1의 개수를 변수 totalCount에 할당
		long totalCount = bitCountCalculator(endNumber) - bitCountCalculator(startNumber - 1);
		
		// valueOf() 및 write() 메서드를 사용해 두 자연수 사이의 1의 개수를 출력
		out.write(String.valueOf(totalCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// bitCountCalculator() 메서드 정의
	public static long bitCountCalculator(long number) {
		
		// 2 이하의 수가 입력된 경우 그 숫자를 그대로 반환
		if (number <= 2)
			return number;
		
		// 해당 숫자까지의 1의 개수를 저장할 변수 bitCount 초기화
		long bitCount = 0;
		
		// log() 메서드를 사용해 가장 높은 자릿수를 나타낼 변수 maxLength 초기화
		int maxLength = (int) (Math.log(number) / Math.log(2)) + 1;
		
		// for 반복문을 사용해 각 자릿수를 순회
		for (int length = maxLength; length > 0; length--) {
			
			// 해당 자릿수가 0인 경우 다음 자릿수를 순회
			if ((number & (1L << (length - 1))) == 0)
				continue;
			
			// 해당 자릿수에서 셀 수 있는 1의 개수를 해당 숫자까지의 1의 개수에 갱신
			bitCount += bitCountSum[length - 1] + number - (1L << (length - 1)) + 1;
			
			// 해당 자릿수의 1을 제거
			number -= 1L << (length - 1);
		}
		
		// 해당 숫자까지의 1의 개수를 반환
		return bitCount;
	}
}