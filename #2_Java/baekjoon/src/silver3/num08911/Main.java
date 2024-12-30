package silver3.num08911;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 거북이의 이동을 나타낼 각 델타 배열 초기화
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// readLine() 메서드를 사용해 입력 받은 컨트롤 프로그램을 변수 program에 할당
			String program = in.readLine();
			
			// 거북이가 이동한 위치의 극값과 현재 위치, 방향을 저장할 각 변수 초기화
			int minX = 0;
			int maxX = 0;
			int minY = 0;
			int maxY = 0;
			int curX = 0;
			int curY = 0;
			int direction = 0;
			
			// for 반복문을 사용해 각 명령을 순회
			for (char command : program.toCharArray()) {
				
				// switch 조건문을 사용해 각 명령을 순회
				switch (command) {
				
					// 명령이 'F'인 경우 거북이를 한 칸 전진
					case 'F':
						curX += dx[direction];
						curY += dy[direction];
						break;
						
					// 명령이 'B'인 경우 거북이를 한 칸 후진
					case 'B':
						curX -= dx[direction];
						curY -= dy[direction];
						break;
					
					// 명령이 'L'인 경우 거북이의 방향을 왼쪽으로 90도 회전
					case 'L':
						direction = (direction + 3) % 4;
						break;
						
					// 명령이 'R'인 경우 거북이의 방향을 오른쪽으로 90도 회전
					default:
						direction = (direction + 1) % 4;
				}
				
				// 거북이가 이동한 경우 거북이가 이동한 위치의 극값을 갱신
				if (command == 'F' || command == 'B') {
					minX = Math.min(curX, minX);
					maxX = Math.max(curX, maxX);
					minY = Math.min(curY, minY);
					maxY = Math.max(curY, maxY);
				}
			}
			
			// valueOf() 및 write() 메서드를 사용해 거북이가 이동한 영역을 모두 포함하는 가장 작은 직사각형의 넓이를 출력
			out.write(String.valueOf((maxX - minX) * (maxY - minY)));
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}