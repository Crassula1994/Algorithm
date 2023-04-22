package gold4.num14226;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

// Main 클래스 정의
public class Main {
	
	// 각 이모티콘을 만드는 데 필요한 최소 시간을 저장할 2차원 배열 minTime 초기화
	static Integer[][] minTime = new Integer[1001][1001];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 이모티콘의 수를 변수 emoticonNum에 할당
		int emoticonNum = Integer.parseInt(in.readLine());
		
		// timeCalculator() 메서드를 호출해 입력 받은 이모티콘의 수를 만들기 위해 필요한 최소 시간을 변수 result에 할당
		int result = timeCalculator(emoticonNum);
		
		// valueOf() 및 write() 메서드를 사용해 입력 받은 이모티콘의 수를 만들기 위해 필요한 최소 시간을 출력
		out.write(String.valueOf(result));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// timeCalculator() 메서드 정의
	public static int timeCalculator(int targetNum) {
		
		// 최소 시간을 계산할 이모티콘의 개수를 저장할 Queue 객체 timeList 초기화
		Queue<int[]> timeList = new LinkedList<>();
		
		// offer() 메서드를 사용해 초기 상태인 이모티콘이 1개인 경우를 timeList에 추가 및 최단 시간 계산 처리
		timeList.offer(new int[] {1, 0});
		minTime[1][0] = 0;
		
		// 입력 받은 이모티콘의 수를 만들기 위해 필요한 최소 시간을 저장할 변수 result 초기화
		int result = 0;
		
		// while 반복문을 사용해 timeList가 빌 때까지 순회
		while (!timeList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 계산한 이모티콘의 수를 배열 currentNum에 할당
			int[] currentNum = timeList.poll();
			
			// 화면에 표시된 이모티콘의 수 및 클립보드에 저장된 이모티콘의 수를 각 변수에 할당
			int screen = currentNum[0];
			int clipboard = currentNum[1];
			
			// 화면에 표시된 이모티콘의 수가 목표로 한 이모티콘의 수에 도달한 경우 최단 시간을 갱신 후 반복문 탈출
			if (screen == targetNum) {
				result = minTime[screen][clipboard];
				break;
			}
			
			// 현재 화면의 이모티콘을 복사했을 때, 해당 경우를 계산한 적이 없는 경우
			if (minTime[screen][screen] == null) {
				
				// offer() 메서드를 사용해 해당 경우를 timeList에 추가 및 최단 시간 계산 처리
				timeList.offer(new int[] {screen, screen});
				minTime[screen][screen] = minTime[screen][clipboard] + 1;
			}
			
			// 클립보드에 저장된 이모티콘을 붙여넣었을 때, 범위를 벗어나지 않고 계산한 적이 없는 경우
			if (clipboard > 0 && screen + clipboard < minTime.length && minTime[screen + clipboard][clipboard] == null) {
				
				// offer() 메서드를 사용해 해당 경우를 timeList에 추가 및 최단 시간 계산 처리
				timeList.offer(new int[] {screen + clipboard, clipboard});
				minTime[screen + clipboard][clipboard] = minTime[screen][clipboard] + 1;
			}
			
			// 이모티콘의 개수를 하나 제거했을 때, 범위를 벗어나지 않고 계산한 적이 없는 경우
			if (screen - 1 >= 0 && minTime[screen - 1][clipboard] == null) {
				
				// offer() 메서드를 사용해 해당 경우를 timeList에 추가 및 최단 시간 계산 처리
				timeList.offer(new int[] {screen - 1, clipboard});
				minTime[screen - 1][clipboard] = minTime[screen][clipboard] + 1;
			}
		}
		
		// 입력 받은 이모티콘의 수를 만들기 위해 필요한 최소 시간을 반환
		return result;
	}
}