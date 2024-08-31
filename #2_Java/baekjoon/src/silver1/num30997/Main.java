package silver1.num30997;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 복권에서 선택할 수 있는 숫자의 최댓값,
		복권 추첨에 참여하는 인원, 추첨하는 횟수를 각 변수에 할당 */
		int maxNumber = Integer.parseInt(st.nextToken());
		int participantNum = Integer.parseInt(st.nextToken());
		int lotteryCount = Integer.parseInt(st.nextToken());
		
		// pow() 메서드를 사용해 하루가 복권에 당첨될 최대 확률의 분모와 분자를 나타낼 각 변수 초기화
		long numerator = 0;
		long denominator = (long) Math.pow(3 * participantNum, lotteryCount + 1);
		
		// 각 숫자를 선택한 횟수, 하루가 고를 숫자를 저장할 각 배열 초기화
		int[] counts = new int[maxNumber + 1];
		int[] maxCombs = new int[3];
		
		// for 반복문을 사용해 다른 사람이 선택한 번호를 순회
		for (int participant = 0; participant < participantNum - 1; participant++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// while 반복문을 사용해 선택한 각 숫자에 대하여 그 선택 횟수를 갱신
			while (st.hasMoreTokens())
				counts[Integer.parseInt(st.nextToken())]++;
		}
		
		// for 반복문을 사용해 하루가 선택할 세 숫자의 조합을 순회
		for (int numberA = 1; numberA <= maxNumber - 2; numberA++) {
			for (int numberB = numberA + 1; numberB <= maxNumber - 1; numberB++) {
				for (int numberC = numberB + 1; numberC <= maxNumber; numberC++) {
					
					// 하루가 선택한 세 숫자가 선택된 횟수의 합을 변수 sum에 할당
					int sum = counts[numberA] + counts[numberB] + counts[numberC] + 3;
					
					// pow() 메서드를 사용해 해당 조합이 당첨될 경우의 수를 계산하고 변수 casesNum에 할당
					long casesNum = (long) Math.pow(3 * participantNum - sum, lotteryCount) * sum;
					
					// 해당 조합의 경우의 수가 저장된 최대 당첨 확률의 분자보다 큰 경우 분자 값과 그 조합을 갱신
					if (casesNum > numerator) {
						numerator = casesNum;
						maxCombs[0] = numberA;
						maxCombs[1] = numberB;
						maxCombs[2] = numberC;
					}
				}
			}
		}
		
		// gcdCalculator()를 호출해 분모와 분자를 약분할 숫자를 변수 divisor에 할당
		long divisor = gcdCalculator(denominator, numerator);
		
		// 분모와 분자를 약분 처리
		numerator /= divisor;
		denominator /= divisor;
		
		// write() 메서드를 사용해 하루가 복권에 당첨될 최대 확률을 출력
		out.write(numerator + " " + denominator + "\n");
		
		// for 반복문을 사용해 하루가 골라야 하는 숫자를 출력
		for (int number : maxCombs)
			out.write(number + " ");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// gcdCalculator() 메서드 정의
	public static long gcdCalculator(long numberA, long numberB) {
		
		// 나머지가 0인 경우 나눈 숫자가 최대공약수이므로 이를 반환
		if (numberB == 0)
			return numberA;
		
		// gcdCalculator() 메서드를 재귀 호출해 최대공약수를 반환
		return gcdCalculator(numberB, numberA % numberB);
	}
}