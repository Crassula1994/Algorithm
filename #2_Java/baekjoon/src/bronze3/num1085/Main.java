package bronze3.num1085;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 좌표 및 직사각형의 크기를 각 변수에 할당
		int coordinateX = Integer.parseInt(st.nextToken());
		int coordinateY = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		
		// min() 메서드를 사용해 각 좌표 기준 경계선까지의 거리를 비교
		int distanceX = Math.min(coordinateX, width - coordinateX);
		int distanceY = Math.min(coordinateY, height - coordinateY);
		int minDistance = Math.min(distanceX, distanceY);

		// valueOf() 및 write() 메서드를 사용해 거리의 최솟값을 출력
		out.write(String.valueOf(minDistance));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}