package silver2.num03541;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 버튼을 누르는 횟수 및 엘리베이터의 개수를 각 변수에 할당
		int pressCount = Integer.parseInt(st.nextToken());
		int elevatorNum = Integer.parseInt(st.nextToken());
		
		// 엘리베이터를 타고 갈 수 있는 가장 낮은 층을 저장할 변수 minFloor 초기화
		int minFloor = Integer.MAX_VALUE;
		
		// for 반복문을 사용해 각 엘리베이터를 순회
		for (int elevator = 0; elevator < elevatorNum; elevator++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 엘리베이터 버튼을 각 변수에 할당
			int upButton = Integer.parseInt(st.nextToken());
			int downButton = Integer.parseInt(st.nextToken());
			
			// gcdCalculator() 메서드를 호출해 두 버튼의 최대공약수를 계산하고 변수 gcd에 할당
			int gcd = gcdCalculator(Math.max(upButton, downButton), Math.min(upButton, downButton));
			
			// 원래 층수로 돌아오는 데 필요한 버튼 횟수를 계산해 변수 cycleCount에 할당
			int cycleCount = upButton / gcd + downButton / gcd;
			
			// 실제로 버튼을 눌러야 하는 횟수 및 현재 층수를 저장할 각 변수 초기화
			int curCount = (pressCount % cycleCount == 0) ? cycleCount : pressCount % cycleCount;
			int curFloor = 0;
			
			// while 반복문을 사용해 실제로 버튼을 눌러야 하는 횟수만큼 버튼을 모두 누를 때까지 순회
			while (curCount-- > 0) {
				
				// 아래로 가는 버튼을 누를 수 있는 경우 아래로 가는 버튼을 누른 것으로 처리
				if (curFloor - downButton > 0) {
					curFloor -= downButton;
					
				// 아래로 가는 버튼을 누를 수 없는 경우 위로 가는 버튼을 누른 것으로 처리
				} else {
					curFloor += upButton;
				}
			}
			
			// min() 메서드를 사용해 엘리베이터를 타고 갈 수 있는 가장 낮은 층을 갱신
			minFloor = Math.min(curFloor, minFloor);
		}
		
		// valueOf() 및 write() 메서드를 사용해 엘리베이터를 타고 갈 수 있는 가장 낮은 층을 출력
		out.write(String.valueOf(minFloor));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// gcdCalculator() 메서드 정의
	public static int gcdCalculator(int buttonA, int buttonB) {
		
		// 주어진 숫자로 나누어 떨어지는 경우 해당 숫자를 반환
		if (buttonA % buttonB == 0)
			return buttonB;
		
		// gcdCalculator() 메서드를 재귀 호출해 최대공약수를 반환
		return gcdCalculator(buttonB, buttonA % buttonB);
	}
}