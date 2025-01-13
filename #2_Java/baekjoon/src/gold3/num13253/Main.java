package gold3.num13253;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 도넛해의 모든 칸 및 목표 좌표를 각 변수에 할당
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		int targetX = Integer.parseInt(st.nextToken());
		int targetY = Integer.parseInt(st.nextToken());
		
		// 목표 좌표까지 이동한 횟수, 원래 좌표까지 돌아오기 위해 이동한 횟수, 현재 좌표를 저장할 각 변수 초기화
		int targetCount = 0;
		int totalCount = 0;
		int curX = 0;
		int curY = 0;
		
		// do while 반복문을 사용해 원래 좌표로 돌아올 때까지 순회
		do {
			
			// 목표 좌표에 도달한 경우 목표 좌표까지 이동한 횟수를 갱신
			if (curX == targetX && curY == targetY)
				targetCount = totalCount;
			
			// 현재 좌표 및 원래 좌표까지 돌아오기 위해 이동한 횟수를 갱신
			curX = (curX + 1) % height;
			curY = (curY + 1) % width;
			totalCount++;
		} while (curX != 0 || curY != 0);
		
		// 목표 좌표까지 도착할 수 없는 경우 -1을 출력
		if (targetCount == 0) {
			out.write(String.valueOf(-1));
		
		// 목표 좌표까지 도착할 수 있는 경우 해당 좌표까지 이동하는 데 필요한 일의 기댓값을 출력
		} else {
			out.write(String.format("%.1f", (double) (targetCount * (totalCount - targetCount))));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}