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
		
		// 칸의 크기에 따른 원의 반지름과 색칠된 칸의 개수를 저장할 각 변수 초기화
		double cellRadius = (double) radius / cellSize;
		int paintedCellCnt = 0;
		
		// for 반복문을 사용해 원의 중심 좌표를 기준으로 제1사분면의 사분원 내에 존재하는 모든 정수 x좌표를 순회
		for (int x = 0; x < cellRadius; x++) {
			
			/* ceil(), floor(), sqrt() 메서드를 사용해 현재 정수 x좌표와 다음 정수 x좌표에서 원의 그래프가 지나는 상한과 하한의 값을 계산하고
			이를 각 변수에 할당 */
			int maxY = (int) Math.ceil(Math.sqrt(cellRadius * cellRadius - x * x));
			int minY = (int) Math.floor(Math.sqrt(cellRadius * cellRadius - (x + 1) * (x + 1)));
			
			// 색칠된 칸의 개수를 갱신
			paintedCellCnt += maxY - minY;
		}
		
		// valueOf() 및 write() 메서드를 사용해 전체 색칠된 칸의 개수를 출력
		out.write(String.valueOf(paintedCellCnt * 4));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}