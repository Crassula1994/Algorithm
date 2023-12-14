package silver2.num11060;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 미로의 상태를 저장할 배열 maze 초기화
	static int[] maze;
	
	// ----------------------------------------------------------------------------------------------------

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 미로의 크기를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		// 미로의 상태를 저장할 배열 maze 초기화
		maze = new int[size];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 미로의 정수를 배열 maze에 저장
		for (int idx = 0; idx < maze.length; idx++)
			maze[idx] = Integer.parseInt(st.nextToken());
		
		// jumpCounter() 메서드를 호출해 재환이가 가장 오른쪽 칸에 도달하기까지 필요한 최소 점프 횟수를 변수 minCnt에 할당
		int minCnt = jumpCounter(0);
		
		// valueOf() 및 write() 메서드를 사용해 재환이가 가장 오른쪽 칸에 도달하기까지 필요한 최소 점프 횟수를 출력
		out.write(String.valueOf(minCnt));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// jumpCounter() 메서드 정의
	public static int jumpCounter(int startIdx) {
		
		// 다음에 방문할 칸을 저장할 Queue 객체 cellList 초기화
		Queue<Integer> cellList = new LinkedList<>();
		
		// 각 위치까지의 점프 횟수를 저장할 배열 counts 초기화
		Integer[] counts = new Integer[maze.length];
		
		// offer() 메서드를 사용해 재환이의 처음 위치를 cellList에 추가 및 점프 횟수 초기화
		cellList.offer(startIdx);
		counts[startIdx] = 0;
		
		// while 반복문을 사용해 cellList가 빌 때까지 순회
		while (!cellList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재의 위치를 변수 curIdx에 할당
			int curIdx = cellList.poll();
			
			// 현재 위치가 오른쪽 끝인 경우 점프 횟수를 반환
			if (curIdx == maze.length - 1)
				return counts[curIdx];
			
			// for 반복문을 사용해 현재 위치에서 이동할 수 있는 칸을 순회
			for (int nextIdx = curIdx + 1; nextIdx <= curIdx + maze[curIdx]; nextIdx++) {
				
				// 이동할 수 있는 칸이 미로의 범위를 벗어난 경우 반복문 탈출
				if (nextIdx >= maze.length)
					break;
				
				// 해당 칸을 이미 확인한 경우 다음 칸을 순회
				if (counts[nextIdx] != null)
					continue;
				
				// offer() 메서드를 사용해 해당 칸을 cellList에 추가 및 점프 횟수 갱신
				cellList.offer(nextIdx);
				counts[nextIdx] = counts[curIdx] + 1;
			}
		}
	
		// 가장 오른쪽 끝에 도달하지 못하는 경우 -1 반환
		return -1;
	}
}