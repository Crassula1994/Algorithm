package silver1.num07115;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 칸의 크기와 원의 반지름을 각 변수에 할당
		int cellSize = Integer.parseInt(st.nextToken());
		int radius = Integer.parseInt(st.nextToken());
		
		// 색칠된 칸의 개수를 저장할 변수 paintedCellCnt 초기화
		int paintedCellCnt = 0;
		
		// for 반복문을 사용해 원의 중심 좌표를 기준으로 제1사분면에 위치한 칸을 순회
		for (int x = 0; x * cellSize < radius; x++) {
			for (int y = 0; y * cellSize < radius; y++) {
				
				// 원의 중심에서 가장 가까운 위치의 좌표를 각 변수에 할당
				int nearX = x * cellSize;
				int nearY = y * cellSize;
				
				// 원의 중심에서 가장 가까운 위치의 거리가 반지름 이상인 경우 다음 x좌표를 순회
				if (nearX * nearX + nearY * nearY >= radius * radius)
					break;
				
				// 원의 중심에서 가장 먼 위치의 좌표를 각 변수에 할당
				int farX = (x + 1) * cellSize;
				int farY = (y + 1) * cellSize;
				
				// 원의 중심에서 가장 먼 위치의 거리가 반지름 이하인 경우 다음 칸을 순회
				if (farX * farX + farY * farY <= radius * radius)
					continue;
				
				// 색칠된 칸의 개수를 갱신
				paintedCellCnt++;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 색칠된 칸의 개수를 출력
		out.write(String.valueOf(paintedCellCnt * 4));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}