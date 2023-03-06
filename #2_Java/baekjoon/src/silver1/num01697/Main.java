package silver1.num01697;

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
	
	// 수빈이와 동생의 최단 시간 거리를 저장할 배열 location 초기화
	static int[] location = new int[100001];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st  = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 수빈이와 동생의 위치를 각 변수에 할당
		int startLoc = Integer.parseInt(st.nextToken());
		int targetLoc = Integer.parseInt(st.nextToken());
		
		// 수빈이와 동생이 같은 위치에 있는 경우 0을 출력
		if (startLoc == targetLoc) {
			out.write(String.valueOf(0));

		// 수빈이와 동생이 같은 위치에 있지 않은 경우
		} else {
			
			// timeCalculator() 메서드를 호출해 동생을 찾는 최단 시간을 계산
			timeCalculator(startLoc, targetLoc);
			
			// valueOf() 및 write() 메서드를 사용해 동생을 찾는 최단 시간을 출력
			out.write(String.valueOf(location[targetLoc] - 1));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// timeCalculator() 메서드 정의
	public static void timeCalculator(int startLoc, int targetLoc) {
		
		// 차례로 탐색할 위치를 저장할 Queue 객체 visitList 초기화
		Queue<Integer> visitList = new LinkedList<>();
		
		// offer() 메서드를 사용해 수빈이의 출발 위치를 visitList에 추가
		visitList.offer(startLoc);
		
		// 해당 위치에 소요 시간을 갱신
		location[startLoc] = 1;
		
		// while 반복문을 사용해 visitList가 빌 때까지 순회
		while (!visitList.isEmpty()) {
			
			// poll() 메서드를 사용해 수빈이의 현재 위치를 변수 currentLoc에 할당
			int currentLoc = visitList.poll();
			
			// 동생을 찾은 경우 반복문 탈출
			if (currentLoc == targetLoc)
				break;
			
			// 수빈이가 왼쪽으로 한 칸 이동해도 범위를 벗어나지 않고 해당 위치를 방문하지 않은 경우
			if (currentLoc - 1 >= 0 && location[currentLoc - 1] == 0) {
				
				// 해당 위치에 소요 시간을 갱신
				location[currentLoc - 1] = location[currentLoc] + 1;
				
				// offer() 메서드를 사용해 visitList에 해당 위치 추가
				visitList.offer(currentLoc - 1);
			}
			
			// 수빈이가 오른쪽으로 한 칸 이동해도 범위를 벗어나지 않고 해당 위치를 방문하지 않은 경우
			if (currentLoc + 1 < location.length && location[currentLoc + 1] == 0) {
				
				// 해당 위치에 소요 시간을 갱신
				location[currentLoc + 1] = location[currentLoc] + 1;
				
				// offer() 메서드를 사용해 visitList에 해당 위치 추가
				visitList.offer(currentLoc + 1);
			}
			
			// 수빈이가 오른쪽으로 두 배 이동해도 범위를 벗어나지 않고 해당 위치를 방문하지 않은 경우
			if (currentLoc * 2 < location.length && location[currentLoc * 2] == 0) {
				
				// 해당 위치에 소요 시간을 갱신
				location[currentLoc * 2] = location[currentLoc] + 1;
				
				// offer() 메서드를 사용해 visitList에 해당 위치 추가
				visitList.offer(currentLoc * 2);
			}
		}
	}
}