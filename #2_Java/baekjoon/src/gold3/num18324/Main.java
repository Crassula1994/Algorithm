package gold3.num18324;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 레이스의 길이 및 테스트 케이스의 수를 각 변수에 할당
		int totalLength = Integer.parseInt(st.nextToken());
		int testCase = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 결승선 통과 시 제한 속도를 변수 speedLimit에 할당
			int speedLimit = Integer.parseInt(in.readLine());
			
			// 레이스에서 베시가 달린 거리, 결승선 통과 시 걸리는 최소 시간을 저장할 각 변수 초기화
			int distance = 0;
			int minTime = 0;
			
			// for 반복문을 사용해 제한 속도에 이를 때까지 각 속도를 순회
			for (int speed = 1; speed <= speedLimit; speed++) {
				
				// 레이스에서 베시가 달린 거리 및 결승선 통과 시 걸리는 최소 시간을 갱신
				distance += speed;
				minTime++;
				
				// 레이스에서 베시가 달린 거리가 레이스의 길이 이상인 경우 반복문 탈출
				if (distance >= totalLength)
					break;
			}
			
			// 레이스에서 베시가 달린 거리가 레이스의 길이 미만인 경우
			if (distance < totalLength) {
				
				// 현재 최고 속도를 저장할 변수 maxSpeed 초기화
				int maxSpeed = speedLimit;
			
				// while 반복문을 사용해 베시가 달린 거리가 레이스의 길이 이상이 될 때까지 순회
				while (distance < totalLength) {
					
					// 현재 최고 속도로 1초 더 달린 것으로 상정해 거리 및 최소 시간을 갱신
					distance += maxSpeed;
					minTime++;
					
					// 레이스에서 베시가 달린 거리가 레이스의 길이 이상인 경우 반복문 탈출
					if (distance >= totalLength)
						break;
					
					// 현재 최고 속도에서 속도를 더 높여 1초 더 달린 것으로 상정해 거리 및 최소 시간을 갱신
					distance += ++maxSpeed;
					minTime++;
				}
			}
						
			// write() 메서드를 사용해 결승선 통과 시 걸리는 최소 시간을 출력
			out.write(minTime + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}