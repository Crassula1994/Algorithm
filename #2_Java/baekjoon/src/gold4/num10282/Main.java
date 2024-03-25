package gold4.num10282;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 컴퓨터 개수, 의존성 개수, 해킹 당한 컴퓨터의 번호를 저장할 각 변수 초기화
	static int computerNum;
	static int dependencyNum;
	static int hackedComputer;
	
	// 의존성 정보와 감염되기까지 걸리는 시간을 저장할 각 배열 초기화
	static List<int[]>[] dependencies;
	static int[] minTime;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 컴퓨터 개수, 의존성 개수, 해킹 당한 컴퓨터의 번호를 각 변수에 할당
			computerNum = Integer.parseInt(st.nextToken());
			dependencyNum = Integer.parseInt(st.nextToken());
			hackedComputer = Integer.parseInt(st.nextToken());
			
			// 의존성 정보와 감염되기까지 걸리는 시간을 저장할 각 배열 초기화
			dependencies = new ArrayList[computerNum + 1];
			minTime = new int[computerNum + 1];
			
			// for 반복문을 사용해 의존성 정보를 저장할 각 List 객체 초기화
			for (int idx = 0; idx < dependencies.length; idx++)
				dependencies[idx] = new ArrayList<>();
			
			// fill() 메서드를 사용해 감염되기까지 걸리는 시간을 초기화
			Arrays.fill(minTime, Integer.MAX_VALUE);
			
			// for 반복문을 사용해 각 의존성 정보를 순회
			for (int d = 0; d < dependencyNum; d++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 의존성 정보를 각 변수에 할당
				int toComputer = Integer.parseInt(st.nextToken());
				int fromComputer = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				
				// add() 메서드를 사용해 의존성 정보를 dependencies에 추가
				dependencies[fromComputer].add(new int[] {toComputer, time});
			}
			
			// timeCalculator() 메서드를 사용해 감염되기까지 걸리는 시간을 갱신
			timeCalculator();
			
			// 총 감염되는 컴퓨터 수 및 마지막 컴퓨터가 감염되기까지 걸리는 시간을 저장할 각 변수 초기화
			int totalCnt = 0;
			int maxTime = 0;
			
			// for 반복문을 사용해 각 컴퓨터의 감염되기까지 걸리는 시간을 순회
			for (int idx = 1; idx < minTime.length; idx++) {
				
				// 해당 컴퓨터가 감염된 경우 총 감염되는 컴퓨터 수 및 마지막 컴퓨터가 감염되기까지 걸리는 시간을 갱신
				if (minTime[idx] != Integer.MAX_VALUE) {
					totalCnt++;
					maxTime = Math.max(minTime[idx], maxTime);
				}			
			}
			
			// write() 메서드를 사용해 총 감염되는 컴퓨터 수 및 마지막 컴퓨터가 감염되기까지 걸리는 시간을 출력
			out.write(totalCnt + " " + maxTime + "\n");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// timeCalculator() 메서드 정의
	public static void timeCalculator() {
		
		// 다음에 감염시킬 컴퓨터의 정보를 저장할 PriorityQueue 객체 hackList 초기화
		PriorityQueue<int[]> hackList = new PriorityQueue<>((c1, c2) -> {
			return c1[1] - c2[1];
		});
		
		// 컴퓨터의 감염 여부를 저장할 배열 hacked 초기화
		boolean[] hacked = new boolean[computerNum + 1];
		
		// 해킹 당한 컴퓨터의 감염되기까지 걸리는 시간을 갱신
		minTime[hackedComputer] = 0;
		
		// offer() 메서드를 사용해 해킹 당한 컴퓨터의 정보를 hackList에 추가
		hackList.offer(new int[] {hackedComputer, 0});
		
		// while 반복문을 사용해 hackList가 빌 때까지 순회
		while (!hackList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 감염 시킨 컴퓨터를 배열 curComputer에 할당
			int[] curComputer = hackList.poll();
			
			// 현재 컴퓨터가 해킹 당하지 않은 경우
			if (!hacked[curComputer[0]]) {
				
				// 현재 컴퓨터를 해킹 처리
				hacked[curComputer[0]] = true;
				
				// for 반복문을 사용해 현재 컴퓨터와 의존된 다른 컴퓨터를 순회
				for (int idx = 0; idx < dependencies[curComputer[0]].size(); idx++) {
					
					// 의존된 다른 컴퓨터의 번호와 감염되기까지의 시간을 각 변수에 할당
					int nextComputer = dependencies[curComputer[0]].get(idx)[0];
					int time = dependencies[curComputer[0]].get(idx)[1];
					
					// 의존된 다른 컴퓨터의 감염되기까지의 시간이 저장된 시간보다 적은 경우 감염되기까지의 시간 갱신 후 hackList에 추가
					if (minTime[nextComputer] > minTime[curComputer[0]] + time) {
						minTime[nextComputer] = minTime[curComputer[0]] + time;
						hackList.offer(new int[] {nextComputer, minTime[nextComputer]});
					}
				}
			}
		}
	}
}