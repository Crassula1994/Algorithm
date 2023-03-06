package silver2.num09184;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 재귀함수의 결과를 저장할 3차원 배열 results 초기화
	static int[][][] results = new int[21][21][21];

	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// while 반복문을 사용해 각 경우를 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 정수를 각 변수에 할당
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			// 세 정수가 모두 -1인 경우 반복문 탈출
			if (a == -1 && b == -1 && c == -1)
				break;
			
			// recursiveFunc() 메서드를 호출해 주어진 재귀함수의 실행 결과를 변수 result에 할당
			int result = recursion(a, b, c);
			
			// write() 메서드를 사용해 실행 결과를 출력
			out.write("w(" + a + ", " + b + ", " + c + ") = " + result + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// recursion() 메서드 정의
	public static int recursion(int a, int b, int c) {
		
		// a, b, c 중 하나의 정수가 0 이하인 경우 1 반환
		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		
		// a, b, c 중 하나의 값이 20을 초과한 경우 recursive 메서드 재귀 호출
		} else if (a > 20 || b > 20 || c > 20) {
			return recursion(20, 20, 20);
			
		// 이미 저장된 값이 있는 경우 이를 반환
		} else if (results[a][b][c] != 0) {
			return results[a][b][c];	
		
		// a가 b보다 크고, b가 c보다 큰 경우 연산 수행 후 결과 저장
		} else if (a < b && b < c) {
			return results[a][b][c] = recursion(a, b, c - 1) + recursion(a, b - 1, c - 1) - recursion(a, b - 1, c);
			
		// 나머지 경우 연산 수행 후 결과 저장
		} else {
			return results[a][b][c] = recursion(a - 1, b, c) + recursion(a - 1, b - 1, c) + recursion(a - 1, b, c - 1) - recursion(a - 1, b - 1, c - 1);
		}
	}
}