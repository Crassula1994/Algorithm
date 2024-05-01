package gold5.num02493;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 탑의 수를 변수 towerNum에 할당
		int towerNum = Integer.parseInt(in.readLine());
		
		// 각 탑의 높이 및 레이저 신호를 수신한 탑들의 번호를 저장할 각 배열 초기화
		int[] heights = new int[towerNum + 1];
		int[] receivedTower = new int[towerNum + 1];
		
		// 신호를 수신한 탑을 저장할 Stack 객체 signalReceiver 초기화
		Stack<Integer> signalReceiver = new Stack<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 탑을 순회
		for (int idx = 1; idx < heights.length; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 해당 탑의 높이를 배열 heights에 저장
			heights[idx] = Integer.parseInt(st.nextToken());
			
			// while 반복문을 사용해 signalReceiver가 빌 때까지 순회
			while (!signalReceiver.isEmpty()) {
				
				// 해당 탑의 높이가 이전에 저장된 탑의 높이보다 작은 경우 반복문 탈출
				if (heights[idx] < heights[signalReceiver.peek()])
					break;
				
				// pop() 메서드를 사용해 이전에 저장된 탑의 번호를 제거
				signalReceiver.pop();
			}
			
			// singalReceiver가 비어 있지 않은 경우 레이저 신호를 수신한 탑의 번호를 갱신
			if (!signalReceiver.isEmpty())
				receivedTower[idx] = signalReceiver.peek();
			
			// push() 메서드를 사용해 해당 탑의 번호를 signalReceiver에 추가
			signalReceiver.push(idx);
		}
		
		// for 반복문을 사용해 레이저 신호를 수신한 탑들의 번호를 출력
		for (int idx = 1; idx < receivedTower.length; idx++)
			out.write(receivedTower[idx] + " ");

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}