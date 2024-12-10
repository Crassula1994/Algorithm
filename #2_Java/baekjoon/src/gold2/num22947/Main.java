package gold2.num22947;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	/* 작업의 개수, 실행 시간을 강제로 0초로 바꿀 수 있는 작업의 개수, 마지막 작업,
	모든 작업이 완료되는 데 걸리는 최소 시간을 저장할 각 변수 초기화 */
	static int taskNum;
	static int changeCount;
	static int lastTask;
	static int minTime = Integer.MAX_VALUE;
	
	// 각 작업의 실행 시간, 선행 작업의 수, 작업별 다음 작업 순서를 저장할 각 배열 초기화
	static int[] runtimes;
	static int[] prevTasks;
	static List<Integer>[] nextTasks;
	
	// 실행 시간을 강제로 0초로 바꾼 작업을 저장할 Set 객체 zeroTasks 초기화
	static Set<Integer> zeroTasks = new HashSet<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 작업의 개수, 작업 순서의 개수,
		실행 시간을 강제로 0초로 바꿀 수 있는 작업의 개수를 각 변수에 할당 */
		taskNum = Integer.parseInt(st.nextToken());
		int orderNum = Integer.parseInt(st.nextToken());
		changeCount = Integer.parseInt(st.nextToken());
		
		// 각 작업의 실행 시간, 선행 작업의 수, 작업별 다음 작업 순서, 0초로 바꾼 작업을 저장할 각 배열 초기화
		runtimes = new int[taskNum + 1];
		prevTasks = new int[taskNum + 1];
		nextTasks = new ArrayList[taskNum + 1];
		
		// for 반복문을 사용해 작업별 다음 작업 순서를 저장할 각 List 객체 초기화
		for (int idx = 0; idx < nextTasks.length; idx++)
			nextTasks[idx] = new ArrayList<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 작업의 실행 시간을 배열 runtimes에 저장
		for (int idx = 1; idx < runtimes.length; idx++)
			runtimes[idx] = Integer.parseInt(st.nextToken());
		
		// while 반복문을 사용해 각 작업 순서를 순회
		while (orderNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 시작 작업과 끝 작업을 각 변수에 할당
			int startTask = Integer.parseInt(st.nextToken());
			int endTask = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 작업 순서를 배열 nextTasks에 저장
			nextTasks[startTask].add(endTask);
			
			// 끝 작업의 선행 작업의 수를 갱신
			prevTasks[endTask]++;
		}
		
		// for 반복문을 사용해 각 작업을 순회
		for (int task = 1; task < nextTasks.length; task++) {
			
			// 해당 작업이 다음 작업이 없는 마지막 작업인 경우 마지막 작업을 갱신 후 반복문 탈출
			if (nextTasks[task].isEmpty()) {
				lastTask = task;
				break;
			}
		}
		
		// taskSelector() 메서드를 호출해 모든 작업이 완료되는 데 걸리는 최소 시간을 갱신
		taskSelector(2, 0);
		
		// valueOf() 및 write() 메서드를 사용해 모든 작업이 완료되는 데 걸리는 최소 시간을 출력
		out.write(String.valueOf(minTime));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// taskSelector() 메서드 정의
	public static void taskSelector(int curTask, int selectCount) {
		
		// 실행 시간을 강제로 0초로 바꿀 작업을 모두 선택한 경우 모든 작업이 완료되는 데 걸리는 최소 시간을 갱신 후 메서드 종료
		if (selectCount == changeCount) {
			minTime = Math.min(timeCalculator(), minTime);
			return;
		}
		
		// for 반복문을 사용해 각 작업을 순회
		for (int task = curTask; task <= taskNum; task++) {
			
			// 해당 작업이 마지막 작업인 경우 다음 작업을 순회
			if (task == lastTask)
				continue;
			
			// add() 메서드를 사용해 해당 작업을 실행 시간을 강제로 0초로 바꿀 작업으로 선택
			zeroTasks.add(task);
			
			// taskSelector() 메서드 재귀 호출
			taskSelector(task + 1, selectCount + 1);
			
			// remove() 메서드를 사용해 해당 작업을 실행 시간을 강제로 0초로 바꿀 작업에서 제외
			zeroTasks.remove(task);
		}
	}
	
	// ----------------------------------------------------------------------------------------------------

	// timeCalculator() 메서드 정의
	public static int timeCalculator() {
		
		// 해당 작업이 완료되는 데 걸리는 시간을 저장할 변수 time 초기화
		int time = 0;
		
		// clone() 메서드를 사용해 각 작업의 선행 작업의 수 및 시작 시간을 저장할 각 배열 초기화
		int[] prevCounts = prevTasks.clone();
		int[] startTimes = new int[taskNum + 1];
		
		// 다음에 확인할 작업을 저장할 Queue 객체 taskList 초기화
		Queue<int[]> taskList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작 작업의 정보를 taskList에 추가
		taskList.offer(new int[] {1, startTimes[1]});
		
		// while 반복문을 사용해 taskList가 빌 때까지 순회
		while (!taskList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 확인 중인 작업을 배열 curTask에 할당
			int[] curTask = taskList.poll();
			
			// contains() 메서드를 사용해 해당 작업의 실행 시간을 변수 curRuntime에 할당
			int curRuntime = (zeroTasks.contains(curTask[0])) ? 0 : runtimes[curTask[0]];
			
			// max() 메서드를 사용해 해당 작업이 완료되는 데 걸리는 시간을 갱신
			time = Math.max(curTask[1] + curRuntime, time);
			
			// for 반복문을 사용해 현재 작업의 다음 작업을 순회
			for (int nextTask : nextTasks[curTask[0]]) {
				
				// 다음 작업의 선행 작업의 수를 갱신
				prevCounts[nextTask]--;
				
				// max() 메서드를 사용해 다음 작업의 시작 시간을 갱신
				startTimes[nextTask] = Math.max(curTask[1] + curRuntime, startTimes[nextTask]);
				
				// 해당 작업의 선행 작업의 수가 0인 경우 해당 작업을 taskList에 추가
				if (prevCounts[nextTask] == 0)
					taskList.offer(new int[] {nextTask, startTimes[nextTask]});
			}
		}
		
		// 해당 작업이 완료되는 데 걸리는 시간을 반환
		return time;
	}
}