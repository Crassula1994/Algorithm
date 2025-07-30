package bronze4.num31962;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 버스의 개수 및 도착해야 하는 시간을 각 변수에 할당
		int busNum = Integer.parseInt(st.nextToken());
		int timeLimit = Integer.parseInt(st.nextToken());
		
		// 가장 늦게 출발하는 버스가 출발할 때까지 걸리는 시간을 저장할 변수 targetTime 초기화
		int targetTime = -1;
		
		// while 반복문을 사용해 각 버스의 정보를 순회
		while (busNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			st = new StringTokenizer(in.readLine());
			
			/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 버스가 출발할 때까지 걸리는 시간
			및 정류장에서 학교까지 가는 데 걸리는 시간을 각 변수에 할당 */
			int waitTime = Integer.parseInt(st.nextToken());
			int rideTime = Integer.parseInt(st.nextToken());
			
			// 학교에 도착해야 하는 시간에 도착할 수 없는 경우 다음 버스를 순회
			if (waitTime + rideTime > timeLimit)
				continue;
			
			// max() 메서드를 사용해 가장 늦게 출발하는 버스가 출발할 때까지 걸리는 시간을 갱신
			targetTime = Math.max(waitTime, targetTime);
		}
		
		// valueOf() 및 write() 메서드를 사용해 가장 늦게 출발하는 버스가 출발할 때까지 걸리는 시간을 출력
		out.write(String.valueOf(targetTime));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}