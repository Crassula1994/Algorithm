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
		
		// 입력 받은 장소의 정보를 저장할 배열 places 초기화
		Place[] places = new Place[placeNum];
		
		// 각 장소 사이의 거리와 최단거리를 저장할 각 2차원 배열 초기화
		double[][] distances = new double[placeNum][placeNum];
		double[][] minDistances = new double[placeNum][placeNum];
		
		// for 반복문을 사용해 각 장소의 정보를 순회
		for (int idx = 0; idx < places.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 해당 장소의 층수와 각 좌표를 각 변수에 할당
			int floor = Integer.parseInt(st.nextToken());
			int coordinateX = Integer.parseInt(st.nextToken());
			int coordinateY = Integer.parseInt(st.nextToken());
			
			// 해당 장소의 정보를 배열 places에 저장
			places[idx] = new Place(floor, coordinateX, coordinateY);
		}
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 질의의 수를 변수 queryNum에 할당
		int queryNum = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 질의를 순회
		while (queryNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 두 장소의 번호를 각 변수에 할당
			int origin = Integer.parseInt(st.nextToken());
			int destination = Integer.parseInt(st.nextToken());
			
			// shortestPathFinder() 및 write() 메서드를 사용해 출발 장소에서 도착 장소까지 최단 거리로 가기 위한 경로를 출력
			out.write(shortestPathFinder(origin, destination));
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// shortestPathFinder() 메서드 정의
	public static String shortestPathFinder(int origin, int destination) {
		
		// 출발 장소에서 도착 장소까지 최단 거리로 가기 위한 경로를 저장할 StringBuilder 객체 sb 초기화
		StringBuilder sb = new StringBuilder();
		
		
		
		// toString() 메서드를 사용해 출발 장소에서 도착 장소까지 최단 거리로 가기 위한 경로를 반환
		return sb.toString();
	}
}