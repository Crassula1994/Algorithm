package bronze1.num15722;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 달팽이의 이동 방향을 저장할 각 델타 배열 초기화
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 달팽이가 움직인 시간을 변수 totalTime에 할당
		int totalTime = Integer.parseInt(in.readLine());
		
		// 현재 시간, 달팽이의 현재 이동 방향과 위치, 이동하는 한 변의 길이를 저장할 각 변수 초기화
		int curTime = 0;
		int curDirection = 0;
		int curX = 0;
		int curY = 0;
		int length = 1;
		
		// while 반복문을 사용해 각 시간을 순회
		outer: while (curTime < totalTime) {
			
			// for 반복문을 사용해 이동하는 한 변의 길이가 같은 두 번의 이동을 순회
			for (int len = 0; len < 2; len++) {
				
				// for 반복문을 사용해 한 변을 이동하는 데 필요한 각 횟수를 순회
				for (int count = 0; count < length; count++) {
					
					// 현재 시간 및 달팽이의 현재 위치를 갱신
					curTime++;
					curX += dx[curDirection];
					curY += dy[curDirection];
					
					// 달팽이가 움직인 시간에 도달한 경우 반복문 탈출
					if (curTime == totalTime)
						break outer;
				}
				
				// 달팽이의 현재 이동 방향을 갱신
				curDirection = (curDirection + 1) % 4;
			}
			
			// 이동하는 한 변의 길이를 갱신
			length++;
		}
		
		// write() 메서드를 사용해 현재 달팽이의 위치를 출력
		out.write(curX + " " + curY);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}