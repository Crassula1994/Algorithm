package silver3.num15651;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 수열을 뽑을 숫자가 저장된 배열 numbers 초기화
	static int[] numbers;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 자연수를 각 변수에 할당
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// n까지의 자연수를 저장할 배열 numbers 초기화
		numbers = new int[n];
		
		// 결과를 저장할 배열 result 초기화
		int[] result = new int[m];
		
		// for 반복문을 사용해 배열 numbers의 각 원소에 자연수를 저장
		for (int idx = 0, num = 1; idx < numbers.length; idx++)
			numbers[idx] = num++;
		
		// permRepetition() 메서드를 호출해 수열을 차례로 출력
		permRepetition(0, n, m, result, out);

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// permRepetition() 메서드 정의
	public static void permRepetition(int length, int n, int m, int[] result, BufferedWriter out) throws IOException {
		
		// m개의 값을 추출해 수열을 모두 만든 경우
		if (length == m) {
			
			// for 반복문을 사용해 수열을 출력
			for (int idx = 0; idx < m; idx++)
				out.write(result[idx] + " ");
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
			
		// m개의 값을 추출해 수열을 모두 만들지 못한 경우
		} else {
			
			// for 반복문을 사용해 모든 자연수를 차례로 순회
			for (int idx = 0; idx < n; idx++) {
				
				// 해당 값을 수열에 추가
				result[length] = numbers[idx];
					
				// permRepetition() 메서드 재귀 호출
				permRepetition(length + 1, n, m, result, out);
			}
		}
	}
}