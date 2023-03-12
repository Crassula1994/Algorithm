package silver1.num06064;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++ ) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 마지막 해 및 순서를 알고자 하는 해를 각 변수에 할당
			int lastYearX = Integer.parseInt(st.nextToken());
			int lastYearY = Integer.parseInt(st.nextToken());
			int targetYearX = Integer.parseInt(st.nextToken());
			int targetYearY = Integer.parseInt(st.nextToken());
			
			// 해당 해가 존재하는지를 나타내는 변수 초기화
			boolean hasAnswer = false;
			
			// for 반복문을 사용해 각 해를 탐색
			for (int year = targetYearY; year <= lastYearX * lastYearY; year += lastYearY) {
				
				// 해당 해가 첫 해와 같은 경우
				if (year % lastYearX == targetYearX) {
					
					// 해당 해 출력 및 해가 존재하는지 여부를 갱신 후 반복문 탈출
					out.write(year + "\n");
					hasAnswer = true;
					break;
				}
				
				// 나머지가 0이 나오고 해당 해가 첫 해와 같은 경우
				if (year % lastYearX == 0 && targetYearX == lastYearX) {
					
					// 해당 해 출력 및 해가 존재하는지 여부를 갱신 후 반복문 탈출
					out.write(year + "\n");
					hasAnswer = true;
					break;
				}
			}
			
			// 해당 해가 존재하지 않는 경우 -1 출력
			if (!hasAnswer)
				out.write(-1 + "\n");
		}
	
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}