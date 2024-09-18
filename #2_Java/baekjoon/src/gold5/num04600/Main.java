package gold5.num04600;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Bridge 클래스 정의
	static class Bridge {
		
		// 다리를 동시에 건널 수 있는 사람의 수, 건너는 데 드는 시간을 저장할 각 변수 초기화
		int capacity;
		int time;
		
		// 매개변수를 입력 받는 생성자 정의
		public Bridge(int capacity, int time) {
			this.capacity = capacity;
			this.time = time;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 다리의 수 및 사람의 수를 각 변수에 할당
			int bridgeNum = -Integer.parseInt(st.nextToken());
			int personNum = Integer.parseInt(st.nextToken());
			
			// 마지막 줄인 경우 반복문 탈출
			if (bridgeNum == 0 && personNum == 0)
				break;
			
			// 모든 사람이 상근이의 명령을 지키면서 다리를 건너는 데 드는 가장 빠른 시간을 저장할 변수 minTime 초기화
			int minTime = 0;
			
			// 각 위치별 존재하는 사람의 수, 다리의 정보를 저장할 각 배열 초기화
			int[] people = new int[bridgeNum + 1];
			Bridge[] bridges = new Bridge[bridgeNum];
			
			// 해당 다리를 건너는 그룹의 정보를 저장할 2차원 배열 groups 초기화
			int[][] groups = new int[bridgeNum][2];
			
			// for 반복문을 사용해 각 다리의 정보를 순회
			for (int idx = 0; idx < bridges.length; idx++) {
			
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 동시에 건널 수 있는 사람의 수,
				그 다리를 건너는 데 드는 시간을 각 변수에 할당 */
				int capacity = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				
				// 해당 다리의 정보를 배열 bridges에 저장
				bridges[idx] = new Bridge(capacity, time);
			}
			
			// 다리를 건너기 전 사람의 위치를 배열 people에 초기화
			people[0] = personNum;
			
			// while 반복문을 사용해 모든 사람이 다리를 건널 때까지 순회
			while (people[bridgeNum] < personNum) {
				
				// 이번 차례에서 지나가게 만들 시간을 저장할 변수 time 초기화
				int time = Integer.MAX_VALUE;
				
				// for 반복문을 사용해 각 다리를 순회
				for (int idx = 0; idx < bridgeNum; idx++) {
				
					// 해당 다리를 건너야 하는 사람이 남아 있고, 현재 다리를 건너는 그룹이 없는 경우
					if (people[idx] > 0 && groups[idx][0] == 0) {
						
						// min() 메서드를 사용해 이동할 사람의 수를 변수 groupSize에 할당
						int groupSize = Math.min(people[idx], bridges[idx].capacity);
						
						// 해당 다리를 이동하는 그룹을 추가
						people[idx] -= groupSize;
						groups[idx][0] += groupSize;
						groups[idx][1] += bridges[idx].time;
					}
					
					// 현재 이동하고 있는 그룹이 있는 경우 해당 다리를 지나는 데 필요한 시간 중 가장 짧은 시간을 time에 저장
					if (groups[idx][0] > 0)
						time = Math.min(groups[idx][1], time);
				}
								
				// for 반복문을 사용해 각 다리를 순회
				for (int idx = 0; idx < bridgeNum; idx++) {
				
					// 현재 이동하고 있는 그룹이 없는 경우 다음 다리를 순회
					if (groups[idx][0] == 0)
						continue;
					
					// 현재 그룹이 다리를 지나는 데 필요한 시간을 갱신
					groups[idx][1] -= time;
					
					// 해당 그룹이 다리를 다 지난 경우 해당 그룹이 다리를 다 지난 상태로 갱신
					if (groups[idx][1] == 0) {
						people[idx + 1] += groups[idx][0];
						groups[idx][0] = 0;
					}
				}
				
				// 해당 시간이 지난 것으로 처리
				minTime += time;
			}
			
			// write() 메서드를 사용해 모든 사람이 상근이의 명령을 지키면서 다리를 건너는 데 드는 가장 빠른 시간을 출력
			out.write(minTime + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}