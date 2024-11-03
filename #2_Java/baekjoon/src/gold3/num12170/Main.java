package gold3.num12170;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 주어진 문자열을 숫자로 변환한 결과를 저장할 배열 stringNumber 초기화
	static int[] stringNumber;
	
	// 사원수 곱셈표를 저장할 2차원 배열 quaternion 초기화
	static int[][] quaternion = {
			{1, 2, 3, 4},
			{2, -1, 4, -3},
			{3, -4, -1, 2},
			{4, 3, -2, -1}
	};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 1; tc <= testCase; tc++) {
			
			// write() 메서드를 사용해 케이스 번호를 출력
			out.write("Case #" + tc + ": ");
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 문자열의 길이 및 반복 횟수를 각 변수에 할당
			int length = Integer.parseInt(st.nextToken());
			int repetitions = Integer.parseInt(st.nextToken());
			
			// readLine() 메서드를 사용해 입력 받은 문자열을 변수 inputString에 할당
			String inputString = in.readLine();
			
			// 문자열의 총 길이를 변수 totalLength에 할당
			int totalLength = length * repetitions;
			
			// 문자열의 길이가 3 미만인 경우 'NO' 출력
			if (totalLength < 3) {
				out.write("NO");
				
			// 문자열의 길이가 3 이상인 경우
			} else {
				
				// 주어진 문자열을 숫자로 변환한 결과를 저장할 배열 stringNumber 초기화
				stringNumber = new int[totalLength];
				
				// 숫자로 변환한 결과를 저장할 인덱스를 나타낼 변수 idx 초기화
				int idx = 0;
			
				// while 반복문을 사용해 각 반복 횟수를 순회
				while (repetitions-- > 0) {
					
					// for 반복문을 사용해 입력 받은 문자열의 각 문자를 순회
					for (char character: inputString.toCharArray()) {
						
						// switch 조건문을 사용해 각 숫자를 변환한 결과를 배열 stringNumber에 저장
						switch (character) {
							case 'i':
								stringNumber[idx++] = 2;
								break;
							case 'j':
								stringNumber[idx++] = 3;
								break;
							case 'k':
								stringNumber[idx++] = 4;
								break;
							default:
								stringNumber[idx++] = 1;
						}
					}
				}
				
				// 해당 문자열을 'ijk'로 줄일 수 있는 경우 'YES' 출력
				if (stringMultiplier(0, totalLength - 1) == -1 && stringChecker()) {
					out.write("YES");
					
				// 해당 문자열을 'ijk'로 줄일 수 없는 경우 'NO' 출력
				} else {
					out.write("NO");
				}
			}
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// stringMultiplier() 메서드 정의
	public static int stringMultiplier(int start, int end) {
		
		// 사원수 곱셈의 결과를 저장할 변수 result 초기화
		int result = 1;
		
		// for 반복문을 사용해 사원수 곱셈의 결과를 갱신
		for (int idx = start; idx <= end; idx++)
			result = quaternionCalculator(result, stringNumber[idx]);
		
		// 사원수 곱셈의 결과를 반환
		return result;
	}
	
	// ----------------------------------------------------------------------------------------------------

	// quaternionCalculator() 메서드 정의
	public static int quaternionCalculator(int row, int column) {
		
		// signum() 메서드를 사용해 부호의 연산 결과를 변수 sign에 할당
		int sign = (int) (Math.signum(row) * Math.signum(column));
		
		// abs() 메서드를 사용해 사원수 곱셈의 결과를 반환
		return sign * quaternion[Math.abs(row) - 1][Math.abs(column) - 1];
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// stringChecker() 메서드 정의
	public static boolean stringChecker() {
		
		// 첫 번째 부분의 사원수 곱셈 결과를 저장할 변수 resultI 초기화
		int resultI = 1;
		
		// for 반복문을 사용해 'i'로 줄일 각 문자의 위치를 순회
		for (int iIdx = 0; iIdx < stringNumber.length - 2; iIdx++) {
			
			// quaternionCalculator() 메서드를 호출해 첫 번째 부분의 사원수 곱셈 결과를 갱신
			resultI = quaternionCalculator(resultI, stringNumber[iIdx]);
			
			// 해당 문자열을 'i'로 줄일 수 없는 경우 다음 문자를 순회
			if (resultI != 2)
				continue;
			
			// 두 번째 부분의 사원수 곱셈 결과를 저장할 변수 resultJ 초기화
			int resultJ = 1;
			
			// for 반복문을 사용해 'j'로 줄일 각 문자의 위치를 순회
			for (int jIdx = iIdx + 1; jIdx < stringNumber.length - 1; jIdx++) {
				
				// quaternionCalculator() 메서드를 호출해 두 번째 부분의 사원수 곱셈 결과를 갱신
				resultJ = quaternionCalculator(resultJ, stringNumber[jIdx]);
				
				// 해당 문자열을 'j'로 줄일 수 없는 경우 다음 문자를 순회
				if (resultJ != 3)
					continue;
				
				// 마지막 문자열로 'k'를 만들 수 있는 경우 true 반환
				if (stringMultiplier(jIdx + 1, stringNumber.length - 1) == 4)
					return true;
			}
		}
		
		// 해당 문자열을 'ijk'로 줄일 수 없는 경우 false 반환
		return false;
	}
}