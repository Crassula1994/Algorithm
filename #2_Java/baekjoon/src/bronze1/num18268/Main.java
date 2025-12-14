package bronze1.num18268;

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

		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 연습 세션의 수 및 소의 수를 각 변수에 할당
		int sessionNum = Integer.parseInt(st.nextToken());
		int cowNum = Integer.parseInt(st.nextToken());
		
		// 일관성 있는 소 쌍의 총 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// 각 소의 연습 세션별 순위를 저장할 2차원 배열 ranks 초기화
		int[][] ranks = new int[cowNum][sessionNum];
		
		// for 반복문을 사용해 각 연습 세션을 순회
		for (int session = 0; session < sessionNum; session++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 소의 순위를 2차원 배열 ranks에 저장
			for (int rank = 0; rank < cowNum; rank++)
				ranks[Integer.parseInt(st.nextToken()) - 1][session] = rank;
		}
		
		// for 반복문을 사용해 각 소의 쌍을 순회
		for (int cow1 = 0; cow1 < cowNum - 1; cow1++) {
			outer: for (int cow2 = cow1 + 1; cow2 < cowNum; cow2++) {
				
				// 첫 번째 연습 세션에서 해당 소 쌍에서의 순위 비교 결과를 변수 result에 할당
				int result = ranks[cow1][0] - ranks[cow2][0];
			
				// for 반복문을 사용해 각 연습 세션을 순회
				for (int session = 1; session < sessionNum; session++) {
					
					// 두 소 쌍의 순위 비교 결과가 첫 번째 연습 세션과 일치하지 않는 경우 다음 소 쌍을 순회
					if (!rankChecker(result, ranks[cow1][session] - ranks[cow2][session]))
						continue outer;
				}
				
				// 일관성 있는 소 쌍의 총 개수를 갱신
				count++;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 일관성 있는 소 쌍의 총 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// rankChecker() 메서드 정의
	public static boolean rankChecker(int baseResult, int curResult) {
		
		// 두 연습 세션의 비교 결과가 일치하는지 여부를 반환
		return baseResult * curResult > 0;
	}
}