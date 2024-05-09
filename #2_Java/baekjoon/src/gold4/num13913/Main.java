package gold4.num13913;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 위치까지의 최소 이동시간 및 직전의 위치를 저장할 각 배열 초기화
	static Integer[] leadTime = new Integer[100001];
	static Integer[] prevLocations = new Integer[100001];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 수빈이와 동생이 있는 위치를 각 변수에 할당
		int startLoc = Integer.parseInt(st.nextToken());
		int endLoc = Integer.parseInt(st.nextToken());
		
		// timeCalculator() 메서드를 호출해 수빈이가 동생을 찾는 가장 빠른 시간을 변수 minTime에 할당
		int minTime = timeCalculator(startLoc, endLoc);
		
		// write() 메서드를 사용해 수빈이가 동생을 찾는 가장 빠른 시간을 출력
		out.write(minTime + "\n");
		
		// 현재 확인 중인 수빈이의 이동 경로를 저장할 변수 currentLoc 초기화
		int currentLoc = endLoc;
		
		// 수빈이의 이동 경로를 저장할 Stack 객체 pathFinder 초기화
		Stack<Integer> pathFinder = new Stack<>();
		
		// while 반복문을 사용해 출발 위치에 도달할 때까지 순회
		while (currentLoc != -1) {
			
			// push() 메서드를 사용해 현재 이동 경로를 pathFinder에 추가
			pathFinder.push(currentLoc);
			
			// 다음에 확인할 이동 경로를 갱신
			currentLoc = prevLocations[currentLoc];
		}
		
		// while 반복문을 사용해 수빈이의 이동 경로를 출력
		while (!pathFinder.isEmpty())
			out.write(pathFinder.pop() + " ");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// timeCalculator() 메서드 정의
	public static int timeCalculator(int startLoc, int endLoc) {
		
		// 다음에 동생을 찾을 위치를 저장할 Queue 객체 searchList 초기화
		Queue<Integer> searchList = new LinkedList<>();
		
		// offer() 메서드를 사용해 출발 위치를 searchList에 추가 및 소요 시간과 직전 위치를 갱신
		searchList.offer(startLoc);
		leadTime[startLoc] = 0;
		prevLocations[startLoc] = -1;
		
		// while 반복문을 사용해 searchList가 빌 때까지 순회
		while (!searchList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 찾고 있는 위치를 변수 currentLoc에 할당
			int currentLoc = searchList.poll();
			
			// 현재 위치에 동생이 있는 경우 반복문 탈출
			if (currentLoc == endLoc)
				break;
			
			// 1초 후에 이동할 수 있는 위치를 저장한 배열 nextLocs 초기화
			int[] nextLocs = {currentLoc - 1, currentLoc + 1, currentLoc * 2};
			
			// for 반복문을 사용해 이동할 수 있는 위치를 순회
			for (int nextLoc : nextLocs) {
				
				// 해당 위치가 범위를 벗어난 경우 다음 위치를 순회
				if (nextLoc < 0 || nextLoc > 100000)
					continue;
				
				// 해당 위치를 이전에 확인한 경우 다음 위치를 순회
				if (leadTime[nextLoc] != null)
					continue;
				
				// offer() 메서드를 사용해 해당 위치를 searchList에 추가 및 소요 시간과 직전 위치를 갱신
				searchList.offer(nextLoc);
				leadTime[nextLoc] = leadTime[currentLoc] + 1;
				prevLocations[nextLoc] = currentLoc;
			}
		}
		
		// 수빈이가 동생을 찾는 가장 빠른 시간을 반환
		return leadTime[endLoc];
	}
}