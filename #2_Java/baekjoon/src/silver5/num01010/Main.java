package silver5.num01010;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 조합 연산 결과를 저장할 2차원 배열 results 초기화
	static int[][] results = new int[31][31];
	
	//----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 서쪽, 동쪽의 사이트 개수를 각 변수에 할당
			int west = Integer.parseInt(st.nextToken());
			int east = Integer.parseInt(st.nextToken());
			
			// combination() 메서드를 호출해 조합 연산 결과를 변수 result에 할당
			int result = combination(east, west);
			
			// write() 메서드를 사용해 경우의 수를 출력
			out.write(result + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	//----------------------------------------------------------------------------------------------------
	
	// combination() 메서드 정의
	public static int combination(int n, int m) {
		
		// 값이 배열 results에 저장되어 있는 경우 바로 반환
		if (results[n][m] != 0)
			return results[n][m];
		
		// m이 0이거나 m = n인 경우 1을 저장 후 반환
		if (m == 0 || m == n) {
			results[n][m] = 1;
			return results[n][m];
		}
		
		// 나머지 경우 combination() 메서드 재귀 호출 후 결과 값 반환
		results[n][m] = combination(n - 1, m) + combination(n - 1, m - 1);
		return results[n][m];
	}
}