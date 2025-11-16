package bronze3.num09501;

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
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 우주선의 개수 및 목적지까지의 거리를 각 변수에 할당
			int spaceshipNum = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			
			// 목적지까지 갈 수 있는 우주선의 개수를 저장할 변수 count 초기화
			int count = 0;
			
			// while 반복문을 사용해 각 우주선을 순회
			while (spaceshipNum-- > 0) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 우주선의 최고 속도,
				연료 양, 연료소비율을 각 변수에 할당 */
				int maxSpeed = Integer.parseInt(st.nextToken());
				int fuelAmount = Integer.parseInt(st.nextToken());
				int fuelRate = Integer.parseInt(st.nextToken());
				
				// 해당 우주선이 목적지까지 갈 수 있는 경우 목적지까지 갈 수 있는 우주선의 개수를 갱신
				if (fuelAmount * maxSpeed >= fuelRate * distance)
					count++;
			}
			
			// append() 메서드를 사용해 목적지까지 갈 수 있는 우주선의 개수를 sb에 저장
			sb.append(count).append("\n");
		}
		
		// toString() 및 write() 메서드를 사용해 각 테스트 케이스의 목적지까지 갈 수 있는 우주선의 개수를 출력
		out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}