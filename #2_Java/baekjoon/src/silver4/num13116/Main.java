package silver4.num13116;

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
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 두 자연수를 각 변수에 할당
			int numberA = Integer.parseInt(st.nextToken());
			int numberB = Integer.parseInt(st.nextToken());
			
			// while 반복문을 사용해 두 자연수에 대한 최소 공통 조상을 찾을 때까지 순회
			while (numberA != numberB) {
				
				// 첫 번째 자연수가 두 번째 자연수보다 더 큰 경우 첫 번째 자연수의 부모 정점으로 이동
				if (numberA > numberB) {
					numberA /= 2;
					
				// 두 번째 자연수가 첫 번째 자연수보다 더 큰 경우 두 번째 자연수의 부모 정점으로 이동
				} else {
					numberB /= 2;
				}
			}
			
			// write() 메서드를 사용해 해당 테스트 케이스에 대한 정답을 출력
			out.write((numberA * 10) + "\n");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}