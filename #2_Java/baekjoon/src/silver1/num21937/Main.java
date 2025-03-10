package silver1.num21937;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 민상이가 작업할 개수 및 목표 작업을 하기 위해 먼저 해야 하는 일의 개수를 저장할 각 변수 초기화
	static int workNum;
	static int count = 0;
	
	// 작업 순서 정보를 저장할 배열 orders 초기화
	static List<Integer>[] orders;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 민상이가 작업할 개수 및 작업 순서 정보의 개수를 각 변수에 할당
		workNum = Integer.parseInt(st.nextToken());
		int orderNum = Integer.parseInt(st.nextToken());
		
		// 작업 순서 정보를 저장할 배열 orders 초기화
		orders = new ArrayList[workNum + 1];
		
		// for 반복문을 사용해 작업 순서 정보를 저장할 각 List 객체 초기화
		for (int idx = 0; idx < orders.length; idx++)
			orders[idx] = new ArrayList<>();
		
		// while 반복문을 사용해 각 작업 순서를 순회
		while (orderNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 먼저 해야 하는 작업과 나중에 해야 하는 작업을 각 변수에 할당
			int prevWork = Integer.parseInt(st.nextToken());
			int nextWork = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 작업 순서를 배열 orders에 저장
			orders[nextWork].add(prevWork);
		}
		
		// readLine() 및 parseInt() 메서드를 사용해 민상이가 오늘 반드시 끝내야 하는 작업을 변수 targetWork에 할당
		int targetWork = Integer.parseInt(in.readLine());
		
		// workCounter() 메서드를 호출해 목표 작업을 하기 위해 먼저 해야 하는 일의 개수를 갱신
		workCounter(targetWork);
		
		// valueOf() 및 write() 메서드를 사용해 목표 작업을 하기 위해 먼저 해야 하는 일의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// workCounter() 메서드 정의
	public static void workCounter(int targetWork) {
		
		// 각 작업의 확인 여부를 저장할 배열 counted 초기화
		boolean[] counted = new boolean[workNum + 1];
		
		// 다음에 확인할 작업을 저장할 Queue 객체 workList 초기화
		Queue<Integer> workList = new LinkedList<>();
		
		// offer() 메서드를 사용해 목표 작업을 workList에 추가 및 확인 처리
		workList.offer(targetWork);
		counted[targetWork] = true;
		
		// while 반복문을 사용해 workList가 빌 때까지 순회
		while (!workList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 확인 중인 작업을 변수 curWork에 할당
			int curWork = workList.poll();
			
			// for 반복문을 사용해 현재 확인 중인 작업 이전에 수행해야 할 작업을 순회
			for (int nextWork : orders[curWork]) {
				
				// 이미 확인한 작업인 경우 다음 작업을 순회
				if (counted[nextWork])
					continue;
				
				// offer() 메서드를 사용해 해당 작업을 workList에 추가 및 확인 처리
				workList.offer(nextWork);
				counted[nextWork] = true;
				
				// 목표 작업을 하기 위해 먼저 해야 하는 일의 개수를 갱신
				count++;
			}
		}
	}
}