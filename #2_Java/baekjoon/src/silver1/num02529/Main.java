package silver1.num02529;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 부등호의 개수, 최대 정수, 최소 정수를 저장할 각 변수 초기화
	static int signCnt;
	static long maxNumber = Long.MIN_VALUE;
	static long minNumber = Long.MAX_VALUE;
	
	// 각 부등호의 정보, 각 숫자의 위치, 각 숫자를 선택했는지 여부를 저장할 각 배열 초기화
	static boolean[] isBigger;
	static Integer[] numbers;
	static boolean[] isSelected = new boolean[10];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 부등호의 개수를 변수 signCnt에 할당
		signCnt = Integer.parseInt(in.readLine());
		
		// 각 부등호의 정보, 각 숫자의 위치를 저장할 각 배열 초기화
		isBigger = new boolean[signCnt];
		numbers = new Integer[signCnt + 1];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 부등호의 정보를 갱신
		for (int idx = 0; idx < signCnt; idx++) {
			
			// nextToken() 및 charAt() 메서드를 사용해 입력 받은 부등호를 변수 sign에 할당
			char sign = st.nextToken().charAt(0);
			
			// '<'인 경우 부등호의 정보를 갱신
			if (sign == '<')
				isBigger[idx] = true;
		}
		
		// for 반복문을 사용해 가능한 숫자를 모두 순회
		for (int n = 0; n < 10; n++) {
			
			// 첫 숫자를 배열 numbers에 갱신 후 선택 처리
			numbers[0] = n;
			isSelected[n] = true;
			
			// numberFinder() 메서드를 호출해 최대 정수와 최소 정수를 갱신
			numberFinder(1);
			
			// 첫 숫자를 지우고, 원상 복구 처리
			numbers[0] = null;
			isSelected[n] = false;
		}
		
		// valueOf() 메서드를 사용해 각 숫자를 문자열로 변환
		String maxString = String.valueOf(maxNumber);
		String minString = String.valueOf(minNumber);
		
		// length() 메서드를 사용해 맨 앞자리에 0이 필요한 경우를 갱신
		maxString = (maxString.length() > signCnt) ? maxString : "0" + maxString;
		minString = (minString.length() > signCnt) ? minString : "0" + minString;
		
		// write() 메서드를 사용해 최대 정수와 최소 정수를 문자열로 출력
		out.write(maxString + "\n" + minString);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------

	// numberFinder() 메서드 정의
	public static void numberFinder(int startIdx) {
		
		// 모든 숫자를 선택한 경우
		if (startIdx > signCnt) {
			
			// 숫자의 위치, 해당 숫자를 저장할 각 변수 초기화
			int idx = 1;
			long number = numbers[0];
			
			// while 반복문을 사용해 숫자 배열을 숫자로 만들 때까지 순회
			while (idx <= signCnt) {
				number *= 10;
				number += numbers[idx];
				idx++;
			}
			
			// max() 및 min() 메서드를 사용해 최대 정수와 최소 정수를 갱신
			maxNumber = Math.max(number, maxNumber);
			minNumber = Math.min(number, minNumber);
			
			// 메서드 종료
			return;
		}
		
		// for 반복문을 사용해 각 숫자를 순회
		for (int n = 0; n < 10; n++) {
			
			// 해당 숫자를 이미 선택한 경우 다음 숫자를 순회
			if (isSelected[n])
				continue;
			
			// 해당 숫자가 부등호 조건을 만족하지 못하는 경우 다음 숫자를 순회
			if ((isBigger[startIdx - 1] && numbers[startIdx - 1] > n) || (!isBigger[startIdx - 1] && numbers[startIdx - 1] < n))
				continue;
			
			// 해당 숫자를 배열 numbers에 갱신 후 선택 처리
			numbers[startIdx] = n;
			isSelected[n] = true;
			
			// numberFinder() 메서드를 재귀 호출
			numberFinder(startIdx + 1);
			
			// 첫 숫자를 지우고, 원상 복구 처리
			numbers[startIdx] = null;
			isSelected[n] = false;
		}
	}
}