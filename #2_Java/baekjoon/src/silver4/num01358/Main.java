package silver4.num01358;

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
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 하키 링크의 직사각형의 크기 및 왼쪽 아래 모서리의 위치,
		선수의 수를 각 변수에 할당 */
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		int startX = Integer.parseInt(st.nextToken());
		int startY = Integer.parseInt(st.nextToken());
		int playerNum = Integer.parseInt(st.nextToken());
		
		// 링크 안에 있는 선수의 수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 각 선수를 순회
		for (int player = 0; player < playerNum; player++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// 입력 받은 선수의 위치를 각 변수에 할당
			int playerX = Integer.parseInt(st.nextToken());
			int playerY = Integer.parseInt(st.nextToken());
			
			// 선수가 현재 직사각형 영역에 있는 경우 링크 안에 있는 선수의 수를 갱신 후 다음 선수를 순회
			if (playerX >= startX && playerX <= startX + width
					&& playerY >= startY && playerY <= startY + height) {
				count++;
				continue;
			}
			
			// 선수가 현재 왼쪽 반원 영역에 있는 경우 링크 안에 있는 선수의 수를 갱신 후 다음 선수를 순회
			if (playerX < startX
					&& isOnSemiCircle(playerX, playerY, startX, startY + height / 2, height / 2)) {
				count++;
				continue;
			}
			
			// 선수가 현재 오른쪽 반원 영역에 있는 경우 링크 안에 있는 선수의 수를 갱신
			if (playerX > startX + width
					&& isOnSemiCircle(playerX, playerY, startX + width, startY + height / 2, height / 2))
				count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 링크 안에 있는 선수의 수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// isOnSemiCircle() 메서드 정의
	public static boolean isOnSemiCircle(int playerX, int playerY, int centerX, int centerY, int radius) {
		
		// pow() 및 sqrt() 메서드를 사용해 선수로부터 반원의 중심까지의 거리를 계산하고 변수 distance에 할당
		double distance = Math.sqrt(Math.pow(centerX - playerX, 2) + Math.pow(centerY - playerY, 2));
		
		// 선수가 반원 안에 있는지 여부를 반환
		return distance <= radius;
	}
}