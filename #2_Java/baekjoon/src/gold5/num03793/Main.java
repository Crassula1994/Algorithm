package gold5.num03793;

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
		
		// 입력 받은 테스트 케이스를 저장할 변수 testCase 초기화
		String testCase;
		
		// while 반복문을 사용해 모든 테스트 케이스를 순회
		while ((testCase = in.readLine()) != null) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(testCase);
			
			// nextToken(), readLine(), toCharArray() 메서드를 사용해 각 문자열을 각 배열에 저장
			char[] stringA = st.nextToken().toCharArray();
			char[] stringB = (st.hasMoreTokens()) ? st.nextToken().toCharArray() : in.readLine().toCharArray();
			
			// 해당 문자열까지 가장 긴 공통 부분 수열의 길이를 저장할 배열 lcsLength 초기화
			int[][] lcsLength = new int[stringA.length + 1][stringB.length + 1];
			
			// for 반복문을 사용해 배열 lcsLength의 행을 차례로 순회
			for (int r = 1; r <= stringA.length; r++) {
				
				// for 반복문을 사용해 배열 lcsLength의 열을 차례로 순회
				for (int c = 1; c <= stringB.length; c++) {
					
					// 해당 행과 열의 문자가 같은 경우 대각선 값에서 1을 더한 값을 저장
					if (stringA[r - 1] == stringB[c - 1]) {
						lcsLength[r][c] = lcsLength[r - 1][c - 1] + 1;
					
					// 해당 행과 열의 문자가 다른 경우 위와 왼쪽의 값 중에서 더 큰 값을 저장
					} else {
						lcsLength[r][c] = Math.max(lcsLength[r - 1][c], lcsLength[r][c - 1]);
					}
				}
			}
			
			// write() 메서드를 사용해 가장 긴 공통 부분 수열의 길이를 출력
			out.write(lcsLength[stringA.length][stringB.length] + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}