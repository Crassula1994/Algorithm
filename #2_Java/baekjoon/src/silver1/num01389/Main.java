package silver1.num01389;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 친구 관계의 연결 정보를 저장할 2차원 배열 friendships 초기화
	static boolean[][] friendships;
	
	// 해당 친구의 통과 여부를 저장할 배열 passed 초기화
	static int[] passed;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 유저의 수 및 친구 관계의 수를 각 변수에 할당
		int userNum = Integer.parseInt(st.nextToken());
		int relationNum = Integer.parseInt(st.nextToken());
		
		// 친구 관계의 연결 정보를 저장할 2차원 배열 friendships 초기화
		friendships = new boolean[userNum + 1][userNum + 1];
		
		// for 반복문을 사용해 입력 받은 각 친구 관계를 순회
		for (int relation = 0; relation < relationNum; relation++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 친구 관계를 배열 frinedships에 저장
			int fromUser = Integer.parseInt(st.nextToken());
			int toUser = Integer.parseInt(st.nextToken());
			friendships[fromUser][toUser] = true;
			friendships[toUser][fromUser] = true;			
		}
		
		// for 반복문을 사용해 배열 numbers의 각 원소에 자연수를 저장
		for (int idx = 0, num = 1; idx < numbers.length; idx++)
			numbers[idx] = num++;
		
		// combRepetition() 메서드를 호출해 수열을 차례로 출력
		combRepetition(0, 0, n, m, result, out);

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// combRepetition() 메서드 정의
	public static void combRepetition(int startIdx, int length, int n, int m, int[] result, BufferedWriter out) throws IOException {
		
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
			for (int idx = startIdx; idx < n; idx++) {
				
				// 해당 값을 수열에 추가
				result[length] = numbers[idx];
					
				// combRepetition() 메서드 재귀 호출
				combRepetition(idx, length + 1, n, m, result, out);
			}
		}
	}
}