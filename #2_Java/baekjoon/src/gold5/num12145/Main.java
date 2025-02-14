package gold5.num12145;

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
			int totalCount = 0;
			
			/* 각 행과 패턴의 길이에서 3으로 이루어진 조합과 1과 2 또는 2로 이루어진 조합이 왔을 때
			드럼을 장식하는 방법의 개수를 저장할 3차원 배열 counts 초기화 */
			int[][][] counts = new int[2][rowNum + 1][13];
			
			// 3으로 이루어진 조합과 1과 2 또는 2로 이루어진 조합을 장식하지 않는 방법의 개수를 초기화
			counts[0][0][1] = counts[1][0][1] = 1;
			
			// for 반복문을 사용해 3으로 이루어진 조합과 1과 2 또는 2로 이루어진 조합을 순회
			for (int comb = 0; comb < 2; comb++) {
				
				// for 반복문을 사용해 각 행과 패턴의 시작 위치를 순회
				for (int r = 0; r < rowNum; r++) {
					for (int pattern = 1; pattern <= 12; pattern++) {
						
						// 현재 드럼을 장식하는 방법의 개수를 변수 count에 할당
						int count = counts[comb][r][pattern];
						
						// 드럼을 장식할 수 없는 경우 다음 패턴의 시작 위치를 순회
						if (count == 0)
							continue;
						
						/* 해당 조합이 3으로 이루어진 조합인 경우 두 줄 뒤의 1과 2 또는 2로 이루어진 조합이 가능하므로
						해당 방법의 개수를 갱신 후 다음 패턴의 시작 위치를 순회 */
						if (comb == 0) {
							counts[1][r + 2][pattern] = (counts[1][r + 2][pattern] + count) % DIVISOR;
							continue;
						}
						
						/* 해당 조합이 2로 이루어진 한 줄 조합인 경우 한 줄 뒤의 3으로 이루어진 조합이 가능하므로
						해당 방법의 개수를 갱신 */
						if (r + 1 <= rowNum)
							counts[0][r + 1][pattern] = (counts[0][r + 1][pattern] + count) % DIVISOR;
						
						/* 해당 조합이 2로 이루어진 크기 2의 정사각형과 1로 이루어진 크기 1의 직사각형으로 이루어진 두 줄 조합인 경우
						두 줄 뒤의 3으로 이루어진 조합이 가능하므로 해당 방법의 개수를 갱신 */
						if (r + 2 <= rowNum && columnNum % 3 == 0)
							counts[0][r + 2][pattern] = (counts[0][r + 2][pattern] + count * 3) % DIVISOR;
					
					}
				}
			}
			
			// format() 및 write()
			out.write(String.format("Case #%d: %d\n", tc, totalCount));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}