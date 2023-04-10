package silver1.num01325;

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
	
	// 컴퓨터의 수, 신뢰 관계의 수, 가장 많이 해킹할 수 있는 컴퓨터의 수를 저장할 각 변수 초기화
	static int computerNum;
	static int connNum;
	static int maxCount = 0;
	
	// 해킹할 수 있는 컴퓨터의 수를 저장할 배열 hackableNum 초기화
	static int[] hackableNum;
	
	// 각 컴퓨터 간의 신뢰 관계를 저장할 배열 connection 초기화
	static List<Integer>[] connection;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 컴퓨터의 수 및 신뢰 관계의 수를 각 변수에 할당
		computerNum = Integer.parseInt(st.nextToken());
		connNum = Integer.parseInt(st.nextToken());
		
		// 각 컴퓨터 간의 신뢰 관계를 저장할 배열 connection 초기화
		connection = new ArrayList[computerNum + 1];
		
		// 해킹할 수 있는 컴퓨터의 수를 저장할 배열 hackableNum 초기화
		hackableNum = new int[computerNum + 1];
		
		// for 반복문을 사용해 신뢰 관계를 저장할 각 List 객체 초기화
		for (int idx = 0; idx < connection.length; idx++)
			connection[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 각 신뢰 관계를 순회
		for (int conn = 0; conn < connNum; conn++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 신뢰하는 컴퓨터와 신뢰 받는 컴퓨터를 각 변수에 할당
			int fromComputer = Integer.parseInt(st.nextToken());
			int toComputer = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 신뢰 관계를 추가
			connection[fromComputer].add(toComputer);
		}
				
		// for 반복문을 사용해 connCounter() 메서드를 호출하고 가장 많이 해킹할 수 있는 컴퓨터를 갱신
		for (int computer = 1; computer <= computerNum; computer++)
			connCounter(computer);
			
		// for 반복문을 사용해 가장 많이 해킹할 수 있는 컴퓨터의 수를 갱신
		for (int idx = 1; idx < hackableNum.length; idx++)
			maxCount = Math.max(hackableNum[idx], maxCount);
		
		// for 반복문을 사용해 가장 많이 해킹할 수 있는 컴퓨터를 오름차순으로 출력
		for (int idx = 1; idx < hackableNum.length; idx++) {
			if (hackableNum[idx] == maxCount)
				out.write(idx + " ");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// connCounter() 메서드 정의
	public static void connCounter(int startComputer) {
		
		// 해당 컴퓨터의 해킹 여부를 저장할 배열 hacked 초기화
		boolean[] hacked = new boolean[computerNum + 1];

		// 다음에 방문할 컴퓨터를 저장할 Queue 객체 hackList 초기화
		Queue<Integer> hackList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작 컴퓨터를 hackList에 추가 후 해킹 처리
		hackList.offer(startComputer);
		hacked[startComputer] = true;
		
		// while 반복문을 사용해 hackList가 빌 때까지 순회
		while (!hackList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 해킹한 컴퓨터를 변수 currentComputer에 할당
			int currentComputer = hackList.poll();
						
			// for 반복문을 사용해 신뢰 관계인 다른 컴퓨터를 순회
			for (int idx = 0; idx < connection[currentComputer].size(); idx++) {
				
				// get() 메서드를 사용해 해당 컴퓨터를 변수 nextComputer에 할당
				int nextComputer = connection[currentComputer].get(idx);
								
				// 해당 컴퓨터를 아직 해킹하지 않은 경우
				if (!hacked[nextComputer]) {
					
					// offer() 메서드를 사용해 해당 컴퓨터를 hackList에 추가 후 해킹 처리
					hackList.offer(nextComputer);
					hacked[nextComputer] = true;
					
					// 해킹된 컴퓨터의 개수를 갱신
					hackableNum[nextComputer]++;
				}
			}
		}
	}
}