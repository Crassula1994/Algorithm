package bronze2.num16916;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 입력 받은 두 문자열 및 KMP 알고리즘의 실패함수를 저장할 각 배열 초기화
	static char[] originalStr;
	static char[] targetStr;
	static int[] failureFunc;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 두 문자열을 각 배열에 저장
		originalStr = in.readLine().toCharArray();
		targetStr = in.readLine().toCharArray();
		
		// failureFunctionMaker() 메서드를 호출해 KMP 알고리즘의 실패함수를 갱신
		failureFunctionMaker();
		
		// write() 메서드를 사용해 주어진 문자열이 원본 문자열의 부분 문자열인지 여부를 출력
		out.write(String.valueOf(stringChecker()));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// failureFunctionMaker() 메서드 정의
	public static void failureFunctionMaker() {
		
		// 실패함수를 저장할 배열 failureFunc 초기화
		failureFunc = new int[targetStr.length];
		
		// for 반복문을 사용해 부분 문자열의 각 문자를 순회
		for (int idx = 1, targetIdx = 0; idx < failureFunc.length; idx++) {
			
			// while 반복문을 사용해 일치하는 문자가 있을 때까지 비교할 문자의 위치를 갱신
			while (targetIdx > 0 && targetStr[idx] != targetStr[targetIdx])
				targetIdx = failureFunc[targetIdx - 1];
			
			// 일치하는 문자가 있는 경우 비교할 문자의 위치와 실패함수의 값을 갱신
			if (targetStr[idx] == targetStr[targetIdx])
				failureFunc[idx] = ++targetIdx;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// stringChecker() 메서드 정의
	public static int stringChecker() {
		
		// for 반복문을 사용해 원본 문자열을 순회
		for (int idx = 0, targetIdx = 0; idx < originalStr.length; idx++) {
			
			// while 반복문을 사용해 일치하는 문자가 있을 때까지 비교할 문자의 위치를 갱신
			while (targetIdx > 0 && originalStr[idx] != targetStr[targetIdx])
				targetIdx = failureFunc[targetIdx - 1];
			
			// 일치하는 문자가 있는 경우 비교할 문자의 위치와 실패함수의 값을 갱신
			if (originalStr[idx] == targetStr[targetIdx]) {
				
				// 찾는 문자열을 모두 찾은 경우 1을 반환
				if (targetIdx == targetStr.length - 1)
					return 1;
				
				// 비교할 문자의 위치를 갱신
				targetIdx++;
			}
		}
		
		// 주어진 문자열이 부분 문자열이 아닌 경우 0을 반환
		return 0;
	}
}