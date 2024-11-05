package gold4.num25597;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 푸앙이의 완주 거리 및 완주 시간을 저장할 각 변수 초기화
	static int targetDist;
	static int totalTime;
	
	// 푸앙이가 선택할 수 있는 버튼 및 각 버튼의 사용 여부를 저장할 각 배열 초기화
	static int[] speedButtons = {8, 4, 1};
	static boolean[] isPressed = new boolean[3];
	
	// 푸앙이가 최소로 누른 버튼의 횟수를 저장할 List 객체 minCounts 초기화
	static List<Count> minCounts = new ArrayList<>(); 
	
	// ----------------------------------------------------------------------------------------------------
	
	// Count 클래스 정의
	static class Count {
		
		// 버튼을 누르는 시각과 버튼의 종류를 저장할 각 변수 초기화
		int pressTime;
		int pressButton;
		
		// 매개변수를 입력 받는 생성자 정의
		public Count(int pressTime, int pressButton) {
			this.pressTime = pressTime;
			this.pressButton = pressButton;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 푸앙이의 완주 거리 및 완주 시간을 각 변수에 할당
		targetDist = Integer.parseInt(st.nextToken());
		totalTime = Integer.parseInt(st.nextToken());
		
		// buttonSelector() 메서드를 호출해 누를 버튼에 따라 푸앙이가 누른 버튼의 최소 횟수를 갱신
		buttonSelector(0);
		
		// 푸앙이가 주어진 시간 동안 목표 거리를 이동하는 것이 불가능한 경우 -1을 출력
		if (minCounts.isEmpty()) {
			out.write(String.valueOf(-1));
			
		// 푸앙이가 주어진 시간 동안 목표 거리를 이동하는 것이 가능한 경우
		} else {
			
			// size() 및 write() 메서드를 사용해 푸앙이가 누른 버튼의 횟수를 출력
			out.write(minCounts.size() + "\n");
			
			// for 반복문을 사용해 각 버튼을 누른 시각 및 누른 버튼의 종류를 출력
			for (Count count : minCounts)
				out.write(count.pressTime + " " + count.pressButton + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// buttonSelector() 메서드 정의
	public static void buttonSelector(int curButton) {
		
		// 모든 버튼을 선택한 경우
		if (curButton == 3) {
			
			// 각 버튼을 사용했을 때 남은 거리 및 시간을 저장할 각 변수 초기화
			int remainDist = targetDist;
			int remainTime = totalTime;
			
			// 각 버튼으로 이동한 시간을 저장할 배열 periods 초기화
			int[] periods = new int[3];
			
			// 각 버튼을 누른 시간을 저장할 List 객체 counts 초기화
			List<Count> counts = new ArrayList<>();
			
			// for 반복문을 사용해 각 버튼을 순회
			for (int idx = 0; idx < 3; idx++) {
				
				// 해당 버튼을 누르지 않는 경우 다음 버튼을 순회
				if (!isPressed[idx])
					continue;
				
				// 해당 버튼으로 이동한 시간을 배열 periods에 저장
				periods[idx] = remainDist / speedButtons[idx];
				
				// 해당 버튼을 사용하고 남은 거리를 갱신
				remainDist %= speedButtons[idx];
			}
			
			// 각 버튼을 모두 누르고도 거리가 남거나 목표 시간을 초과하는 경우 메서드 종료
			if (remainDist > 0 || periods[0] + periods[1] + periods[2] > totalTime)
				return;
			
			// for 반복문을 사용해 각 버튼을 순회
			for (int idx = 0; idx < 3; idx++) {
				
				// 해당 버튼을 누르지 않는 경우 다음 버튼을 순회
				if (periods[idx] == 0)
					continue;
				
				// add() 메서드를 사용해 해당 버튼을 누르는 시간을 counts에 추가
				counts.add(new Count(remainTime - periods[idx], speedButtons[idx]));
				
				// 해당 버튼을 사용하고 남은 시간을 갱신
				remainTime -= periods[idx];
			}
			
			// 버튼을 누른 횟수가 저장된 최소로 누른 버튼의 횟수보다 적은 경우
			if (minCounts.isEmpty() || counts.size() < minCounts.size()) {
				
				// reverse() 메서드를 사용해 버튼을 누른 순서를 시간 순서대로 정렬
				Collections.reverse(counts);
				
				// 푸앙이가 최소로 누른 버튼의 횟수를 갱신
				minCounts = counts;
			}
			
			// 메서드 종료
			return;
		}
		
		// 해당 버튼을 선택한 것으로 상정해 buttonSelector() 메서드 재귀호출
		isPressed[curButton] = true;
		buttonSelector(curButton + 1);
		
		// 해당 버튼을 선택하지 않은 것으로 상정해 buttonSelector() 메서드 재귀호출
		isPressed[curButton] = false;
		buttonSelector(curButton + 1);
	}
}