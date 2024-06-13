package bronze1.num04404;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Location 클래스 정의
	public static class Location {
		
		// 해당 위치의 좌표를 저장할 각 변수 초기화
		double x;
		double y;
		
		// 매개변수를 입력 받는 생성자 정의
		public Location(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 땅다람쥐가 탈출할 수 있는지 여부를 나타낼 변수 canEscape 초기화
		boolean canEscape = false;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseDouble() 메서드를 사용해 땅다람쥐와 개의 좌표를 각 변수에 할당
		Location gopher = new Location(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
		Location dog = new Location(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
		
		// 굴의 좌표를 입력 받을 변수 line 초기화
		String line;
		
		// while 반복문을 사용해 각 굴의 좌표를 순회
		while ((line = in.readLine()) != null && !line.isEmpty()) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(line);
			
			// nextToken() 및 parseDouble() 메서드를 사용해 굴의 좌표를 변수 gopherHole에 할당
			Location gopherHole = new Location(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
			
			// 해당 굴로부터 땅다람쥐와 개가 떨어진 거리를 계산해 각 변수에 할당
			double distGopher = Math.pow(gopher.x - gopherHole.x, 2) + Math.pow(gopher.y - gopherHole.y, 2);
			double distDog = Math.pow(dog.x - gopherHole.x, 2) + Math.pow(dog.y - gopherHole.y, 2);
			
			// 땅다람쥐가 탈출할 수 있는 경우
			if (distGopher * 4 < distDog) {
				
				// format() 및 write() 메서드를 사용해 탈출할 수 있는 굴의 좌표를 포함한 문구 출력
				out.write(String.format("The gopher can escape through the hole at (%.3f,%.3f).", gopherHole.x, gopherHole.y));
				
				// 땅다람쥐가 탈출할 수 있는지 여부를 갱신
				canEscape = true;
				
				// 반복문 탈출
				break;
			}
		}
		
		// 땅다람쥐가 탈출할 수 없는 경우 정해진 문구 출력
		if (!canEscape)
			out.write("The gopher cannot escape.");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}