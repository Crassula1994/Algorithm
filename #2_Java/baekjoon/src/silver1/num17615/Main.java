package silver1.num17615;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 볼의 총 개수를 저장할 변수 ballNum 초기화
	static int ballNum;
	
	// 각 볼의 배치를 저장할 배열 balls 초기화
	static char[] balls;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 볼의 총 개수를 변수 ballNum에 할당
		ballNum = Integer.parseInt(in.readLine());
		
		// 각 색깔의 볼의 개수를 저장할 각 변수 초기화
		int redCount = 0;
		int blueCount = 0;
		
		// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 각 볼의 배치를 배열 balls에 저장
		balls = in.readLine().toCharArray();
		
		// for 반복문을 사용해 각 색깔의 볼의 rotnfmf rodtls
		for (int idx = 0; idx < balls.length; idx++) {
			redCount = (balls[idx] == 'R') ? redCount + 1 : redCount;
			blueCount = (balls[idx] == 'B') ? blueCount + 1 : blueCount;			
		}
		
		// tipCounter() 메서드를 호출해 양 극단에 위치한 연속된 같은 색깔 볼의 개수를 세어 각 변수에 할당
		int leftCount = tipCounter(true);
		int rightCount = tipCounter(false);
		
		/* min() 메서드를 사용해 각 색깔의 볼을 왼쪽으로 옮기는 경우와 오른쪽으로 옮기는 경우를 상정하고
		더 적은 이동 횟수를 각 변수에 할당 */
		int leftShiftCount = (balls[0] == 'R') ?
				Math.min(redCount - leftCount, blueCount) : Math.min(redCount, blueCount - leftCount);
		int rightShiftCount = (balls[ballNum - 1] == 'R') ?
				Math.min(redCount - rightCount, blueCount) : Math.min(redCount, blueCount - rightCount);
		
		// min(), valueOf(), write() 메서드를 사용해 같은 색끼리 모을 수 있는 최소 이동 횟수를 출력
		out.write(String.valueOf(Math.min(leftShiftCount, rightShiftCount)));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// tipCounter() 메서드 정의
	public static int tipCounter(boolean isLeft) {
		
		// 같은 색깔 볼의 개수 및 해당 볼의 색상을 저장할 각 변수 초기화
		int count = 0;
		char color = (isLeft) ? balls[0] : balls[ballNum - 1];
		
		// while 반복문을 사용해 같은 색깔 볼의 나오지 않을 때까지 순회
		while ((isLeft) ? balls[count] == color : balls[ballNum - count - 1] == color) {
			
			// 같은 색깔 볼의 개수를 갱신
			count++;
			
			// 모든 색이 같은 경우 반복문 탈출
			if (count == ballNum)
				break;
		}
		
		// 같은 색깔 볼의 개수를 반환
		return count;
	}
}