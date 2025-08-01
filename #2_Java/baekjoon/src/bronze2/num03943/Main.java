package bronze2.num03943;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 헤일스톤 수열의 시작값을 변수 curElement에 할당
			int curElement = Integer.parseInt(in.readLine());
			
			// 헤일스톤 수열에서 가장 큰 값을 저장할 변수 maxElement 초기화
			int maxElement = curElement;
			
			// while 반복문을 사용해 헤일스톤 수열의 각 값을 순회
			while (curElement > 1) {
				
				// 새로운 헤일스톤 수열의 값을 갱신
				curElement = ((curElement & 1) == 1) ? 3 * curElement + 1 : curElement >> 1;
				
				// max() 메서드를 사용해 헤일스톤 수열에서 가장 큰 값을 갱신
				maxElement = Math.max(curElement, maxElement);
			}
			
			// write() 메서드를 사용해 헤일스톤 수열에서 가장 큰 값을 출력
			out.write(maxElement + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}