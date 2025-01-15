package bronze2.num06696;

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
		
		// while 반복문을 사용해 각 부동산을 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseDouble() 메서드를 사용해 입력 받은 부동산의 좌표를 각 변수에 할당
			double coordinateX = Double.parseDouble(st.nextToken());
			double coordinateY = Double.parseDouble(st.nextToken());
			
			// 모든 부동산을 확인한 경우 반복문 탈출
			if (coordinateX == 0 && coordinateY == 0)
				break;
			
			// sqrt() 메서드를 사용해 원점에서 해당 부동산까지의 거리를 계산하고 이를 변수 distance에 할당
			double distance = Math.sqrt(coordinateX * coordinateX + coordinateY * coordinateY);
			
			// ceil() 메서드를 사용해 해당 부동산이 침수되기까지 대피 시간을 변수 evacuationTime에 할당
			int evacuationTime = (int) Math.ceil(distance * distance * Math.PI / 100);
			
			// write() 메서드를 사용해 해당 부동산이 침수되기까지 대피 시간을 출력
			out.write("The property will be flooded in hour " + evacuationTime + ".\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}