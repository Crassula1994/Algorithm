package bronze2.num01173;

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
		
		/* nextToken() 및 parseInt() 메서드를 사용해 운동할 시간, 최소 맥박, 최대 맥박,
		운동과 휴식을 통한 맥박의 변화량을 각 변수에 할당 */
		int targetTime = Integer.parseInt(st.nextToken());
		int minPulse = Integer.parseInt(st.nextToken());
		int maxPulse = Integer.parseInt(st.nextToken());
		int trainingChange = Integer.parseInt(st.nextToken());
		int recoveryChange = Integer.parseInt(st.nextToken());
		
		// 목표한 시간만큼 운동하기 위해 필요한 시간의 최솟값을 저장할 변수 minTime 초기화
		int minTime = 0;
		
		// 목표한 시간만큼 운동을 하는 것이 불가능한 경우 필요한 시간의 최솟값을 -1로 설정
		if (maxPulse - minPulse < trainingChange) {
			minTime = -1;
			
		// 목표한 시간만큼 운동을 하는 것이 가능한 경우
		} else {
			
			// 현재 운동한 시간 및 현재 맥박을 저장할 각 변수 초기화
			int curTime = 0;
			int curPulse = minPulse;
			
			// while 반복문을 사용해 목표한 시간만큼 운동할 때까지 순회
			while (curTime != targetTime) {
				
				// 필요한 시간을 갱신
				minTime++;
				
				// 운동을 한 경우 현재 운동한 시간 및 현재 맥박을 갱신
				if (curPulse + trainingChange <= maxPulse) {
					curTime++;
					curPulse += trainingChange;
				
				// 휴식을 한 경우 현재 맥박을 갱신
				} else {
					curPulse = Math.max(minPulse, curPulse - recoveryChange);
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 목표한 시간만큼 운동하기 위해 필요한 시간의 최솟값을 출력
		out.write(String.valueOf(minTime));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}