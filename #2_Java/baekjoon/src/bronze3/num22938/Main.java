package bronze3.num22938;

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
		
		// nextToken() 및 parseLong() 메서드를 사용해 입력 받은 첫 번째 과녁의 중심과 반지름을 각 변수에 할당
		long coordinateX1 = Long.parseLong(st.nextToken());
		long coordinateY1 = Long.parseLong(st.nextToken());
		long radius1 = Long.parseLong(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseLong() 메서드를 사용해 입력 받은 두 번째 과녁의 중심과 반지름을 각 변수에 할당
		long coordinateX2 = Long.parseLong(st.nextToken());
		long coordinateY2 = Long.parseLong(st.nextToken());
		long radius2 = Long.parseLong(st.nextToken());
		
		// 두 과녁 중심 사이의 각 좌표에서의 거리 및 두 과녁이 접하기 위한 거리를 계산해 각 변수에 할당
		long distX = coordinateX1 - coordinateX2;
		long distY = coordinateY1 - coordinateY2;
		long targetDist = radius1 + radius2;
		
		// write() 메서드를 사용해 두 과녁이 겹치는지 여부를 출력
		out.write((distX * distX + distY * distY < targetDist * targetDist) ? "YES" : "NO");

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}