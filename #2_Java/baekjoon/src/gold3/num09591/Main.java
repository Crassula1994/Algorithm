package gold3.num09591;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Place 클래스 정의
	static class Place {
		
		// 해당 장소의 층수와 각 좌표를 저장할 각 변수 초기화
		int floor;
		int coordinateX;
		int coordinateY;
		
		// 매개변수를 입력 받는 생성자 정의
		public Place(int floor, int coordinateX, int coordinateY) {
			this.floor = floor;
			this.coordinateX = coordinateX;
			this.coordinateY = coordinateY;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 장소의 수 및 각 연결편의 개수를 각 변수에 할당
		int placeNum = Integer.parseInt(st.nextToken());
		int connectionNum = Integer.parseInt(st.nextToken());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}