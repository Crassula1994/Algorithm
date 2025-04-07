package silver1.num06462;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 국가 간 정복해야 할 최소 국가의 수를 초기화할 상수 INF 초기화
	static final int INF = 987654321;
	
	// ----------------------------------------------------------------------------------------------------

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 테스트 세트의 번호를 저장할 변수 testSet 초기화
		int testSet = 1;
		
		// while 반복문을 사용해 각 테스트 세트를 순회
		outer: while (true) {
			
			// 각 국가 간 정복해야 할 최소 국가의 수를 저장할 2차원 배열 minCountries 초기화
			int[][] minCountries = new int[21][21];
			
			// for 반복문을 사용해 각 국가 쌍을 순회
			for (int start = 1; start <= 20; start++) {
				for (int end = 1; end <= 20; end++) {
					
					// 같은 국가가 아닌 경우 해당 국가 간 정복해야 할 최소 국가의 수를 초기화
					if (start != end)
						minCountries[start][end] = INF;
				}
			}
			
			// for 반복문을 사용해 각 국가를 순회
			for (int start = 1; start < 20; start++) {
				
				// readLine() 메서드를 사용해 해당 국가의 경계 정보를 변수 boundaryInfo에 할당
				String boundaryInfo = in.readLine();
				
				// 모든 테스트 케이스를 확인한 경우 반복문 탈출
				if (boundaryInfo == null)
					break outer;
				
				// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(boundaryInfo);
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 해당 국가와 인접한 국가의 수를 변수 countryNum에 할당
				int countryNum = Integer.parseInt(st.nextToken());
				
				// while 반복문을 사용해 각 인접한 국가를 순회
				while (countryNum-- > 0) {
				
					// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 인접한 국가를 변수 end에 할당
					int end = Integer.parseInt(st.nextToken());
					
					// 각 국가 간 정복해야 할 최소 국가의 수를 2차원 배열 minCountries에 저장
					minCountries[start][end] = 1;
					minCountries[end][start] = 1;
				}
			}
			
			// for 반복문을 사용해 각 경유 국가를 순회
			for (int mid = 1; mid <= 20; mid++) {
				
				// for 반복문을 사용해 각 시작 국가를 순회
				for (int start = 1; start <= 20; start++) {
					
					// for 반복문을 사용해 각 도착 국가를 순회
					for (int end = 1; end <= 20; end++) {
						
						// 저장된 정복해야 할 최소 국가보다 경유 국가를 통한 정복해야 할 최소 국가가 더 적은 경우 이를 갱신
						if (minCountries[start][end] > minCountries[start][mid] + minCountries[mid][end])
							minCountries[start][end] = minCountries[start][mid] + minCountries[mid][end];
					}
				}
			}
			
			// format() 및 write() 메서드를 사용해 테스트 세트의 번호를 출력
			out.write(String.format("Test Set #%d\n", testSet++));
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
			int testCase = Integer.parseInt(in.readLine());
			
			// while 반복문을 사용해 각 테스트 케이스를 순회
			while (testCase-- > 0) {
				
				// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 정복을 시작할 국가와 목표 국가를 각 변수에 할당
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				// format() 및 write() 메서드를 사용해 해당 국가 간 정복해야 할 최소 국가의 수를 출력
				out.write(String.format("%2d to %2d: %d\n", start, end, minCountries[start][end]));
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}