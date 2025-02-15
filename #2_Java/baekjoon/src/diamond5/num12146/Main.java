package diamond5.num12146;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 드럼을 장식하는 방법의 수를 나눌 제수 DIVISOR 초기화
	static final int DIVISOR = 1000000007;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 1; tc <= testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 드럼의 크기를 각 변수에 할당
			int rowNum = Integer.parseInt(st.nextToken());
			int columnNum = Integer.parseInt(st.nextToken());
			
			// 드럼을 장식하는 방법의 수를 저장할 변수 totalCount 초기화
			long totalCount = 0;
			
			/* 1 또는 2로 이루어진 조합과 3으로 이루어진 조합이 왔을 때 각 행과 패턴의 주기에 대하여
			드럼을 장식하는 방법의 개수를 저장할 3차원 배열 counts 초기화 */
			long[][][] counts = new long[2][rowNum + 1][13];
			
			// 드럼의 줄이 없을 때 장식하는 방법의 개수를 초기화
			counts[0][0][1] = counts[1][0][1] = 1;
				
			// for 반복문을 사용해 각 행과 패턴의 주기를 순회
			for (int r = 0; r < rowNum; r++) {
				for (int pattern = 1; pattern <= 12; pattern++) {
					
					/* 직전에 1 또는 2로 이루어진 조합으로 드럼을 장식할 수 있고, 3으로 이루어진 두 줄 조합(
						333333333333…
						333333333333…
					)이 가능한 경우 해당 방법의 개수를 갱신
					*/
					if (counts[0][r][pattern] > 0 && r + 2 <= rowNum)
						counts[1][r + 2][pattern] = (counts[1][r + 2][pattern] + counts[0][r][pattern]) % DIVISOR;
					
					// 직전에 3으로 이루어진 조합으로 드럼을 장식한 경우 그 방법의 수를 변수 count에 할당
					long count = counts[1][r][pattern];
					
					// 직전에 3으로 이루어진 조합으로 드럼을 장식할 수 없는 경우 다음 패턴의 주기를 순회
					if (count == 0)
						continue;
					
					/* 2로 이루어진 한 줄 조합(
						222222222222…
					)이 가능한 경우 해당 방법의 개수를 갱신 */
					if (r + 1 <= rowNum)
						counts[0][r + 1][pattern] = (counts[0][r + 1][pattern] + count) % DIVISOR;
					
					/* 2로 이루어진 너비 2의 정사각형과 1로 이루어진 너비 1의 직사각형으로 이루어진 두 줄 조합(
						221221221221…
						221221221221…
					)이 가능한 경우 */
					if (r + 2 <= rowNum && columnNum % 3 == 0) {
						
						// lcmCalculator() 메서드를 호출해 해당 조합의 주기를 변수 newPattern에 할당
						int newPattern = lcmCalculator(pattern, 3);
						
						// 해당 조합을 사용한 방법의 개수를 갱신
						counts[0][r + 2][newPattern] = (counts[0][r + 2][newPattern] + count * 3) % DIVISOR;
					}
					
					/* 2로 이루어진 띠와 1로 이루어진 너비 2의 직사각형으로 이루어진 두 줄 조합(
						222211222211…
						211222211222…
					)이 가능한 경우 */
					if (r + 2 <= rowNum && columnNum % 6 == 0) {
						
						// lcmCalculator() 메서드를 호출해 해당 조합의 주기를 변수 newPattern에 할당
						int newPattern = lcmCalculator(pattern, 6);
						
						// 해당 조합을 사용한 방법의 개수를 갱신
						counts[0][r + 2][newPattern] = (counts[0][r + 2][newPattern] + count * 6) % DIVISOR;
					}
					
					/* 2로 이루어진 띠와 1로 이루어진 너비 1의 직사각형으로 이루어진 세 줄 조합(
						212221222122…
						212121212121…
						222122212221…
					)이 가능한 경우 */
					if (r + 3 <= rowNum && columnNum % 4 == 0) {
						
						// lcmCalculator() 메서드를 호출해 해당 조합의 주기를 변수 newPattern에 할당
						int newPattern = lcmCalculator(pattern, 4);
						
						// 해당 조합을 사용한 방법의 개수를 갱신
						counts[0][r + 3][newPattern] = (counts[0][r + 3][newPattern] + count * 4) % DIVISOR;
					}
				}
			}
			
			// for 반복문을 사용해 드럼을 장식하는 방법의 수를 갱신
			for (int pattern = 1; pattern <= 12; pattern++) {
				totalCount = (totalCount + counts[0][rowNum][pattern] * powerCalculator(pattern, DIVISOR - 2)) % DIVISOR;
				totalCount = (totalCount + counts[1][rowNum][pattern] * powerCalculator(pattern, DIVISOR - 2)) % DIVISOR;
			}
			
			// format() 및 write() 메서드를 사용해 테스트 케이스 번호와 드럼을 장식하는 방법의 수를 출력
			out.write(String.format("Case #%d: %d\n", tc, totalCount));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// lcmCalculator() 메서드 정의
	public static int lcmCalculator(int numberA, int numberB) {
		
		// gcdCalculator() 메서드를 호출해 두 숫자의 최대공약수를 변수 gcd에 할당
		int gcd = gcdCalculator(numberA, numberB);
		
		// 두 숫자의 최소공배수를 계산해 반환
		return gcd * (numberA / gcd) * (numberB / gcd);
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// gcdCalculator() 메서드 정의
	public static int gcdCalculator(int numberA, int numberB) {
		
		// 한 숫자가 다른 숫자로 나누어 떨어지는 경우 나눈 숫자가 최대공약수이므로 이를 반환
		if (numberA % numberB == 0)
			return numberB;
		
		// gcdCalculator() 메서드를 재귀 호출해 두 수의 최대공약수를 반환
		return gcdCalculator(numberB, numberA % numberB);
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// powerCalculator() 메서드 정의
	public static long powerCalculator(long base, int exponent) {
		
		// 지수가 0인 경우 1을 반환
		if (exponent == 0)
			return 1;
		
		// powerCalculator() 메서드를 재귀 호출해 지수가 절반인 거듭제곱을 계산한 결과를 변수 half에 할당
		long half = powerCalculator(base, exponent >> 1);
		
		// 거듭제곱을 계산한 결과를 반환
		return ((exponent & 1) == 1) ? (half * half % DIVISOR) * base % DIVISOR : half * half % DIVISOR;
	}
}