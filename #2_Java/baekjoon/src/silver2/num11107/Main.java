package silver2.num11107;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 주사위의 수와 살아남기 위해 필요한 점수에 따른 승률을 저장할 2차원 배열 survivalRates 초기화
	static Double[][] survivalRates = new Double[101][101];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 주사위의 수와 살아남기 위해 필요한 점수를 각 변수에 할당
			int diceNum = Integer.parseInt(st.nextToken());
			int targetPoint = Integer.parseInt(st.nextToken());
			
			// chanceCalculator(), format(), write() 메서드를 사용해 해당 게임에서 살아남을 확률을 출력
			out.write(String.format("%.3f", chanceCalculator(diceNum, targetPoint)));
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// chanceCalculator() 메서드 정의
	public static double chanceCalculator(int diceNum, int targetPoint) {
		
		// 이미 계산된 확률인 경우 해당 확률을 반환
		if (survivalRates[diceNum][targetPoint] != null)
			return survivalRates[diceNum][targetPoint];
		
		// 살아남기 위해 필요한 점수가 0인 경우 살아남을 확률은 100%이므로 이를 반환
		if (targetPoint == 0)
			return survivalRates[diceNum][targetPoint] = 1.0;
		
		// 주사위의 개수가 0인 경우 살아남을 확률은 0%이므로 이를 반환
		if (diceNum == 0)
			return survivalRates[diceNum][targetPoint] = 0.0;
		
		// chanceCalculator() 메서드를 재귀 호출해 현재 주사위의 수와 살아남기 위해 필요한 점수에서의 확률을 변수 survivalRate에 할당
		double survivalRate = 0.7 * chanceCalculator(diceNum - 1, targetPoint)
				+ 0.2 * chanceCalculator(diceNum - 1, targetPoint - 1)
				+ 0.1 * chanceCalculator(diceNum, targetPoint - 1);
		
		// 해당 게임에서 살아남을 확률을 반환
		return survivalRates[diceNum][targetPoint] = survivalRate;
	}
}