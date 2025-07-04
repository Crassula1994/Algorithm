package bronze1.num15593;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 인명구조원 소의 수를 변수 lifeguardNum에 할당
		int lifeguardNum = Integer.parseInt(in.readLine());
		
		// 현재 인명구조원 소가 근무하는 총 시간 및 한 마리를 해고했을 때 인명구조원 소가 최대로 근무하는 시간을 저장할 각 변수 초기화
		int totalTime = 0;
		int maxTime = 0;
		
		// 각 시간에 근무하는 인명구조원 소의 수를 저장할 배열 counts 초기화
		int[] counts = new int[1000];
		
		// 각 인명구조원 소의 근무 시간을 저장할 2차원 배열 lifeguards 초기화
		int[][] lifeguards = new int[lifeguardNum][2];
		
		// for 반복문을 사용해 각 인명구조원 수의 근무 시간을 순회
		for (int idx = 0; idx < lifeguardNum; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 해당 인명구조원 소의 근무 시간을 2차원 배열 lifeguards에 저장
			lifeguards[idx][0] = Integer.parseInt(st.nextToken());
			lifeguards[idx][1] = Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 해당 인명구조원 소의 근무 시간을 순회
			for (int time = lifeguards[idx][0]; time < lifeguards[idx][1]; time++) {
				
				// 해당 시간에 처음으로 근무하는 인명구조원 소인 경우 현재 인명구조원 소가 근무하는 총 시간을 갱신
				if (counts[time] == 0)
					totalTime++;
				
				// 해당 시간에 근무하는 근무하는 인명구조원 소의 수를 갱신
				counts[time]++;
			}
		}
		
		// for 반복문을 사용해 각 인명구조원 소를 순회
		for (int idx = 0; idx < lifeguardNum; idx++) {
			
			// 해당 소를 해고했을 때 인명구조원 소가 근무하는 총 시간을 저장할 변수 curTime 초기화
			int curTime = totalTime;
			
			// for 반복문을 사용해 해당 인명구조원 소가 근무하는 시간을 순회
			for (int time = lifeguards[idx][0]; time < lifeguards[idx][1]; time++) {
				
				// 해당 시간에 근무하는 인명구조원 소가 유일한 경우 해당 소를 해고했을 때 인명구조원 소가 근무하는 총 시간을 갱신
				if (counts[time] == 1)
					curTime--;
			}
			
			// max() 메서드를 사용해 한 마리를 해고했을 때 인명구조원 소가 최대로 근무하는 시간을 갱신
			maxTime = Math.max(curTime, maxTime);
		}
		
		// valueOf() 및 write() 메서드를 사용해 한 마리를 해고했을 때 인명구조원 소가 최대로 근무하는 시간을 출력
		out.write(String.valueOf(maxTime));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}