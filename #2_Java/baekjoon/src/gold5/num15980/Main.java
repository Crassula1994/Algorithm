package gold5.num15980;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 새의 수 및 스승님의 명상 시간을 각 변수에 할당
		int birdNum = Integer.parseInt(st.nextToken());
		int totalTime = Integer.parseInt(st.nextToken());
		
		// 잡아야 할 새의 번호와 해당 새를 잡았을 때 최대 방해 받는 정도를 저장할 각 변수 초기화
		int targetBird = 0;
		int targetDisturbance = Integer.MAX_VALUE;
		
		// 각 시간에서 스승님이 방해 받는 정도를 저장할 배열 disturbances 초기화
		int[] disturbances = new int[totalTime + 1];
		
		// 각 새가 지저귀는 시간을 저장할 2차원 배열 birds 초기화
		int[][] birds = new int[birdNum + 1][totalTime + 1];
		
		// for 반복문을 사용해 각 새의 정보를 순회
		for (int bird = 1; bird <= birdNum; bird++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 charAt() 메서드를 사용해 입력 받은 새의 방향과 지저귀는 시간 문자열을 각 변수에 할당
			char direction = st.nextToken().charAt(0);
			String timeString = st.nextToken();
			
			// for 반복문을 사용해 각 새가 지저귀는 시간을 순회
			for (int time = 0; time < totalTime; time++) {
				
				// 새가 현재 지저귀지 않는 경우 다음 시간을 순회
				if (timeString.charAt(time) == '0')
					continue;
				
				// 해당 새가 지저귀는 시간을 2차원 배열 birds에 저장
				birds[bird][time + 1] = (direction == 'L') ? -1 : 1;
				
				// 해당 시간에서 스승님이 방해 받는 정도를 갱신
				disturbances[time + 1] += birds[bird][time + 1];
			}
		}
		
		// for 반복문을 사용해 각 새를 순회
		for (int bird = 1; bird <= birdNum; bird++) {
			
			// 해당 새를 잡았을 때 현재 시간까지 방해받는 정도 및 최대 방해받는 정도를 저장할 각 변수 초기화
			int curDisturbance = 0;
			int maxDisturbance = 0;
			
			// for 반복문을 사용해 각 시간을 순회
			for (int time = 1; time <= totalTime; time++) {
				
				// 해당 새를 잡았을 때 현재 시간까지 방해받는 정도를 갱신
				curDisturbance += disturbances[time] - birds[bird][time];
				
				// abs() 및 max() 메서드를 사용해 해당 새를 잡았을 때 최대 방해받는 정도를 갱신
				maxDisturbance = Math.max(Math.abs(curDisturbance), maxDisturbance);
			}
			
			// 해당 새를 잡았을 때 최대 방해받는 정도가 저장된 최대 방해받는 정도보다 작은 경우
			if (maxDisturbance < targetDisturbance) {
				
				// 잡아야 할 새의 번호와 해당 새를 잡았을 때 최대 방해 받는 정도를 갱신
				targetBird = bird;
				targetDisturbance = maxDisturbance;
			}
		}
		
		// write() 메서드를 사용해 잡아야 할 새의 번호와 해당 새를 잡았을 때 스승님이 방해 받는 정도를 출력
		out.write(targetBird + "\n" + targetDisturbance);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}