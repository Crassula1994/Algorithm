package silver2.num11051;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 이항계수 연산 결과를 저장할 2차원 배열 results 초기화
	static int[][] results = new int[1001][1001];
	
	//----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 두 자연수를 각 변수에 할당
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		// binoCoeff() 메서드를 호출해 이항계수 연산 결과를 변수 result에 할당
		int result = binoCoeff(n, k);
		
		// valueOf() 및 write() 메서드를 사용해 이항계수를 10007로 나눈 나머지를 출력
		out.write(String.valueOf(result));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	//----------------------------------------------------------------------------------------------------
	
	// binoCoeff() 메서드 정의
	public static int binoCoeff(int n, int k) {
		
		// 값이 배열 results에 저장되어 있는 경우 바로 반환
		if (results[n][k] != 0)
			return results[n][k];
		
		// k가 0이거나 k = n인 경우 1을 저장 후 반환
		if (k == 0 || k == n) {
			results[n][k] = 1;
			return results[n][k];
		}
		
		// 나머지 경우 binoCoeff() 메서드 재귀 호출 후 결과 값 반환
		results[n][k] = (binoCoeff(n - 1, k) + binoCoeff(n - 1, k - 1)) % 10007;
		return results[n][k];
	}
}