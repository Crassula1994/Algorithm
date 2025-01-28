package gold4.num16397;

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
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 LED로 표현된 수, 버튼을 누를 수 있는 최대 횟수,
		탈출을 위해 똑같이 만들어야 하는 수를 각 변수에 할당 */
		int originNumber = Integer.parseInt(st.nextToken());
		int maxLimit = Integer.parseInt(st.nextToken());
		int targetNumber = Integer.parseInt(st.nextToken());
		
		// buttonSimulator() 메서드를 호출해 탈출에 필요한 최소의 버튼 횟수를 변수 minCount에 할당
		int minCount = buttonSimulator(originNumber, targetNumber, maxLimit);
		
		// valueOf() 및 write() 메서드를 사용해 탈출에 필요한 최소의 버튼 횟수
		out.write((minCount == -1) ? "ANG" : String.valueOf(minCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// buttonSimulator() 메서드 정의
	public static int buttonSimulator(int originNumber, int targetNumber, int maxLimit) {
		
		// 각 숫자에 도달하기 위한 버튼 횟수를 저장할 배열 counts 초기화
		Integer[] counts = new Integer[100000];
		
		// 다음에 방문할 숫자를 저장할 Queue 객체 numberList 초기화
		Queue<Integer> numberList = new LinkedList<Integer>();
		
		// offer() 메서드를 사용해 현재 LED의 수를 numberList에 추가 후 해당 숫자에 도달하기 위한 버튼 횟수를 갱신
		numberList.offer(originNumber);
		counts[originNumber] = 0;
		
		// while 반복문을 사용해 numberList가 빌 때까지 순회
		while (!numberList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 숫자를 변수 curNumber에 할당
			int curNumber = numberList.poll();
			
			// 현재 버튼을 누른 횟수가 최대 횟수를 초과한 경우 -1을 반환
			if (counts[curNumber] > maxLimit)
				return -1;
			
			// 현재 숫자가 목표한 숫자인 경우 탈출에 필요한 최소의 버튼 횟수를 반환
			if (curNumber == targetNumber)
				return counts[targetNumber];
			
			// 버튼 A를 누를 수 있는 경우 다음 숫자
			if (curNumber < 99999) {
				
				// 버튼 A를 누른 다음 숫자를 변수 nextNumber에 할당
				int nextNumber = curNumber + 1;
				
				// 다음 숫자를 이미 방문하지 않은 경우
				if (counts[nextNumber] == null) {
					
					// offer() 메서드를 사용해 다음 숫자를 numberList에 추가 후 해당 숫자에 도달하기 위한 버튼 횟수를 갱신
					numberList.offer(nextNumber);
					counts[nextNumber] = counts[curNumber] + 1;
				}
			}
			
			// 버튼 B를 누를 수 있는 경우
			if (curNumber != 0 && curNumber * 2 < 100000) {
				
				// valueOf(), length(), pow() 메서드를 사용해 버튼 B를 누른 다음 숫자를 변수 nextNumber에 할당
				int nextNumber = curNumber * 2 - (int) Math.pow(10, String.valueOf(curNumber * 2).length() - 1);
				
				// 다음 숫자를 이미 방문하지 않은 경우
				if (counts[nextNumber] == null) {
				
					// offer() 메서드를 사용해 다음 숫자를 numberList에 추가 후 해당 숫자에 도달하기 위한 버튼 횟수를 갱신
					numberList.offer(nextNumber);
					counts[nextNumber] = counts[curNumber] + 1;
				}
			}
		}
		
		// 탈출을 위해 똑같이 만들어야 하는 수를 만들 수 없는 경우 -1을 반환
		return -1;
	}
}