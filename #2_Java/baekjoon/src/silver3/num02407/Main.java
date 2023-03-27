package silver3.num02407;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 조합의 각 숫자를 저장할 각 변수 초기화
	static int n;
	static int m;
	
	// 각 조합의 값을 저장할 2차원 배열 combinations 초기화
	static BigInteger[][] combinations;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 조합의 각 숫자를 각 변수에 할당
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// 각 조합의 값을 저장할 배열 combinations 초기화
		combinations = new BigInteger[n + 1][n + 1];
			
		// combCalculator() 메서드를 호출해 해당 조합의 값을 계산하고 이를 배열 combinations에 저장
		combCalculator();

		// valueOf() 및 write() 메서드를 사용해 해당 조합의 값을 출력
		out.write(String.valueOf(combinations[n][m]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// combCalculator() 메서드 정의 
	public static void combCalculator() {
		
		// for 반복문을 사용해 n의 값을 순회
		for (int nv = 0; nv <= n; nv++) {
			
			// for 반복문을 사용해 m의 값을 순회
			for (int mv = 0; mv <= nv; mv++) {
				
				// m이 0이거나 n과 같은 경우 1을 저장
				if (mv == 0 || mv == nv) {
					combinations[nv][mv] = new BigInteger("1");
				
				// 나머지 경우 add() 메서드를 사용해 조합 도출 공식으로 값을 저장
				} else {
					combinations[nv][mv] = combinations[nv - 1][mv].add(combinations[nv - 1][mv - 1]);
				}
			}
		}
	}
}