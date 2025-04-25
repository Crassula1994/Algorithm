package gold5.num07196;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 선분의 개수와 다각형을 각 변수에 할당
		int lineNum = Integer.parseInt(in.readLine());
		String polygon = in.readLine();
		
		// 다각형의 면적과 이전 꼭짓점, 현재 꼭짓점의 좌표를 저장할 각 변수 초기화
		long area = 0;
		long prevX = 0;
		long prevY = 0;
		long curX = 0;
		long curY = 0;
		
		// for 반복문을 사용해 각 선분의 방향을 순회
		for (int idx = 0; idx < lineNum; idx++) {
			
			// charAt() 메서드를 사용해 해당 선분의 방향을 변수 direction에 할당
			char direction = polygon.charAt(idx);
			
			// switch 조건문을 사용해 현재 꼭짓점의 좌표를 갱신
			switch (direction) {
				case 'N':
					curY++;
					break;
				case 'S':
					curY--;
					break;
				case 'E':
					curX++;
					break;
				default:
					curX--;
			}
			
			// 신발끈 공식을 통해 다각형의 면적을 계산
			area += prevX * curY - curX * prevY;
			
			// 이전 꼭짓점의 좌표를 갱신
			prevX = curX;
			prevY = curY;
		}
		
		// abs(), valueOf(), write() 메서드를 사용해 다각형의 면적을 출력
		out.write(String.valueOf(Math.abs(area) / 2));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}