package silver4.num09188;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// 모든 테스트 케이스를 순회한 경우 반복문 탈출
			if (st.countTokens() < 2)
				break;
			
			// nextToken() 메서드를 사용해 입력 받은 두 단어를 각 변수에 할당
			String word1 = st.nextToken();
			String word2 = st.nextToken();
			
			// wordChecker(), max(), length() 메서드를 사용해 근사치 측정 결과의 분자와 분모를 각 변수에 할당
			int numerator = Math.max(wordChecker(word1, word2), wordChecker(word2, word1)) * 2;
			int denominator = word1.length() + word2.length();
			
			// gcdCalculator() 메서드를 호출해 분모와 분자의 최대공약수를 변수 gcd에 할당
			int gcd = gcdCalculator(numerator, denominator);
			
			// 분모와 분자를 최대공약수로 약분
			numerator /= gcd;
			denominator /= gcd;
			
			// format() 및 write() 메서드를 사용해 주어진 두 단어를 정해진 형식으로 출력
			out.write(String.format("appx(%s,%s) = ", word1, word2));
			
			// 근사치 측정 결과가 0인 경우 0을 출력
			if (numerator == 0) {
				out.write(String.valueOf(0));
				
			// 근사치 측정 결과가 1인 경우 1을 출력
			} else if (numerator == 1 && denominator == 1) {
				out.write(String.valueOf(1));
				
			// 근사치 측정 결과가 0 또는 1이 아닌 경우 해당 근사치 측정 결과를 출력
			} else {
				out.write(String.format("%d/%d", numerator, denominator));
			}
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// wordChecker() 메서드 정의
	public static int wordChecker(String word1, String word2) {
		
		// 두 단어의 최대 공통 글자 수를 저장할 변수 maxCount 초기화
		int maxCount = 0;
		
		// for 반복문을 사용해 첫 번째 단어를 기준으로 각 글자를 순회
		for (int idx1 = 0; idx1 < word1.length(); idx1++) {
			
			// 현재 공통 글자 수를 저장할 변수 count 초기화
			int count = 0;
			
			// min() 메서드를 사용해 두 번째 단어의 확인할 글자 범위를 변수 maxLimit에 할당
			int maxLimit = Math.min(word1.length() - idx1, word2.length());
			
			// for 반복문을 사용해 두 번째 단어의 각 글자를 순회
			for (int idx2 = 0; idx2 < maxLimit; idx2++) {
				
				// 첫 번째 단어의 글자와 두 번째 단어의 글자가 같은 경우 공통 글자 수를 갱신
				if (word1.charAt(idx1 + idx2) == word2.charAt(idx2))
					count++;
			}
			
			// max() 메서드를 사용해 두 단어의 최대 공통 글자 수를 갱신
			maxCount = Math.max(count, maxCount);
		}
		
		// 두 단어의 최대 공통 글자 수를 반환
		return maxCount;
	}
	
	// ----------------------------------------------------------------------------------------------------

	// gcdCalculator() 메서드 정의
	public static int gcdCalculator(int numberA, int numberB) {
		
		// 한 숫자가 다른 숫자로 나누어 떨어지는 경우 나눈 숫자가 최대공약수이므로 이를 반환
		if (numberA % numberB == 0)
			return numberB;
		
		// gcdCalculator() 메서드를 재귀 호출해 최대공약수를 반환
		return gcdCalculator(numberB, numberA % numberB);
	}
}