package gold4.num24462;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 알람의 개수 및 건모가 일어나야 하는 시각을 각 변수에 할당
		int alarmNum = Integer.parseInt(st.nextToken());
		int targetTime = Integer.parseInt(st.nextToken());
		
		// 알람이 울리는 최대 횟수 및 건모가 켜야 할 알람 번호를 저장할 각 변수 초기화
		int maxCount = 0;
		int targetAlarmA = 0;
		int targetAlarmB = 0;
		
		// 각 알람의 정보를 저장할 2차원 배열 alarms 초기화
		int[][] alarms = new int[alarmNum + 1][2];
		
		// for 반복문을 사용해 각 알람을 순회
		for (int idx = 1; idx < alarms.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 해당 알람의 시작 시각과 스누즈 시간을 2차원 배열 alarms에 저장
			alarms[idx][0] = Integer.parseInt(st.nextToken());
			alarms[idx][1] = Integer.parseInt(st.nextToken());
		}
		
		// for 반복문을 사용해 각 알람 조합을 순회
		for (int alarmA = 1; alarmA < alarmNum; alarmA++) {
			for (int alarmB = alarmA + 1; alarmB <= alarmNum; alarmB++) {
				
				// 해당 알람 조합에서 알람이 울리는 횟수를 저장할 변수 count 초기화
				int count = 0;
				
				// 해당 알람 조합에서 알람이 울리는 횟수를 갱신
				count += (targetTime - alarms[alarmA][0]) / alarms[alarmA][1] + 1;
				count += (targetTime - alarms[alarmB][0]) / alarms[alarmB][1] + 1;
			
				// gcdCalculator() 메서드를 호출해 두 알람의 스누즈 시간에 대한 최소공배수를 변수 lcm에 할당
				long lcm = (long) alarms[alarmA][1] * alarms[alarmB][1] / gcdCalculator(alarms[alarmA][1], alarms[alarmB][1]);

				// max() 메서드를 사용해 두 알람이 겹칠 수 있는 시각, 실제로 겹치기 시작하는 시각을 각 변수에 할당
				long checkTime = Math.max(alarms[alarmA][0], alarms[alarmB][0]);
				long startTime = (checkTime % lcm == 0) ? checkTime : (checkTime / lcm + 1) * lcm;
				
				// 두 알람이 실제로 겹치는 경우 해당 알람 조합에서 알람이 울리는 횟수를 갱신
				if (startTime <= targetTime)
					count -= (targetTime - startTime) / lcm + 1;
				
				// 해당 알람 조합에서 알람이 울리는 횟수가 저장된 최대 횟수보다 큰 경우
				if (count > maxCount) {
					
					// 알람이 울리는 최대 횟수 및 건모가 켜야 할 알람 번호를 갱신
					maxCount = count;
					targetAlarmA = alarmA;
					targetAlarmB = alarmB;
				}
			}
		}
		
		// write() 메서드를 사용해 건모가 켜야 할 알람 번호 및 알람이 울리는 최대 횟수를 출력
		out.write(targetAlarmA + " " + targetAlarmB + "\n" + maxCount);

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// gcdCalculator() 메서드 정의
	public static long gcdCalculator(long numberA, long numberB) {
		
		// 한 숫자가 다른 숫자로 나누어 떨어지는 경우 나눈 숫자가 최대공약수이므로 이를 반환
		if (numberA % numberB == 0)
			return numberB;
		
		// gcdCalculator() 메서드를 재귀 호출해 최대공약수를 반환
		return gcdCalculator(numberB, numberA % numberB);
	}
}