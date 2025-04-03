package bronze3.num11312;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 정삼각형으로 덮을 정삼각형,
			정삼각형을 덮을 정삼각형의 크기를 각 변수에 할당 */
			int baseSize = Integer.parseInt(st.nextToken());
			int coverSize = Integer.parseInt(st.nextToken());
			
			// 큰 정삼각형의 한 변을 덮는 작은 정삼각형의 개수를 계산해 변수 sideCount에 할당
			long sideCount = baseSize / coverSize;
			
			// write() 메서드를 사용해 큰 정삼각형을 완벽하게 덮을 수 있는 작은 정삼각형의 최소 개수를 출력
			out.write((sideCount * sideCount) + "\n");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}