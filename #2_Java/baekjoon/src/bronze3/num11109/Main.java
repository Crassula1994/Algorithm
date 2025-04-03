package bronze3.num11109;

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
			
			/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 병렬 버전 개발에 걸리는 시간,
			다음 해 동안 프로그램이 실행되는 횟수, 직렬 버전과 병렬 버전의 실행 시간을 각 변수에 할당 */
			int parallelDevTime = Integer.parseInt(st.nextToken());
			int runCount = Integer.parseInt(st.nextToken());
			int serialRuntime = Integer.parseInt(st.nextToken());
			int parallelRuntime = Integer.parseInt(st.nextToken());
			
			// 직렬화와 병렬화의 시간을 계산해 각 변수에 할당
			int serialTime = runCount * serialRuntime;
			int parallelTime = parallelDevTime + runCount * parallelRuntime;
			
			// 병렬화를 하는 것이 좋은 경우 'parallelize' 출력
			if (serialTime > parallelTime) {
				out.write("parallelize");
				
			// 병렬화를 하는 것이 좋지 않은 경우 'do not parallelize' 출력
			} else if (serialTime < parallelTime) {
				out.write("do not parallelize");
				
			// 직렬화와 병렬화를 통한 시간이 같은 경우 'does not matter' 출력
			} else {
				out.write("does not matter");
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}