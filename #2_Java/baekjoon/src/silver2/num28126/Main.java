package silver2.num28126;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 로봇의 이동 횟수 및 로봇의 이동 명령 순서를 각 변수에 할당
		int moveCnt = Integer.parseInt(in.readLine());
		String commands = in.readLine();
		
		// 로봇으로 탐사할 수 있는 지점의 개수를 저장할 변수 totalCount 초기화
		int totalCount = 0;
		
		// 로봇의 이동 가능한 명령의 개수를 저장할 배열 counts 초기화
		int[] counts = new int[3];
		
		// for 반복문을 사용해 각 명령을 순회
		for (int idx = 0; idx < moveCnt; idx++) {
			
			// charAt() 메서드를 사용해 해당 명령의 종류를 변수 command에 할당
			char command = commands.charAt(idx);
			
			// switch 조건문을 사용해 해당 명령의 개수를 갱신해 배열 counts에 저장
			switch (command) {
				case 'R':
					counts[0]++;
					break;
				case 'U':
					counts[1]++;
					break;
				default:
					counts[2]++;
			}
		}
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 탐사하고 싶은 지점의 수를 변수 pointNum에 할당
		int pointNum = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 탐사하고 싶은 지점을 순회
		while (pointNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 지점의 좌표를 각 변수에 할당
			int coordinateX = Integer.parseInt(st.nextToken()) - 1;
			int coordinateY = Integer.parseInt(st.nextToken()) - 1;
			
			// min() 메서드를 사용해 대각선 방향으로 움직일 횟수를 변수 moveX에 할당
			int moveX = Math.min(counts[2], Math.min(coordinateX, coordinateY));
			
			// 각 직선 방향으로 이동하여 해당 지점에 도달할 수 있는 경우 탐사할 수 있는 지점의 개수를 갱신
			if (coordinateX - moveX <= counts[0] && coordinateY - moveX <= counts[1])
				totalCount++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 로봇으로 탐사할 수 있는 지점의 개수를 출력
		out.write(String.valueOf(totalCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}