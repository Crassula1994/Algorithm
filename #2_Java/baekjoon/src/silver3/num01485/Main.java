package silver3.num01485;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

// Main 클래스 정의
public class Main {
	
	// Point 클래스 정의
	static class Point {
		
		// 해당 점의 좌표를 저장할 각 변수 초기화
		int coordinateX;
		int coordinateY;
		
		// 매개변수를 입력 받는 생성자 정의
		public Point(int coordinateX, int coordinateY) {
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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// 각 점의 좌표를 저장할 배열 points 초기화
			Point[] points = new Point[4];
			
			// 각 점 사이의 거리를 저장할 Map 객체 distances 초기화
			Map<Long, Integer> distances = new TreeMap<>();
			
			// for 반복문을 사용해 각 점을 순회
			for (int idx = 0; idx < points.length; idx++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 해당 점의 좌표를 배열 points에 저장
				points[idx] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			// for 반복문을 사용해 각 점의 쌍을 순회
			for (int p1 = 0; p1 < 3; p1++) {
				for (int p2 = p1 + 1; p2 < 4; p2++) {
					
					// abs() 메서드를 사용해 두 점과 그 거리를 각 변수에 할당
					Point point1 = points[p1];
					Point point2 = points[p2];
					long distX = Math.abs(point1.coordinateX - point2.coordinateX);
					long distY = Math.abs(point1.coordinateY - point2.coordinateY);
					long distance = distX * distX + distY * distY;
					
					// getOrDefault() 및 put() 메서드를 사용해 해당 점 사이의 거리를 distances에 저장
					distances.put(distance, distances.getOrDefault(distance, 0) + 1);
				}
			}
			
			// 두 종류의 거리가 존재하지 않는 경우 정사각형이 아니므로 0을 출력
			if (distances.size() != 2) {
				out.write("0");
				
			// 두 종류의 거리가 존재하는 경우
			} else {
				
				// 각 거리의 개수를 저장할 List 객체 counts 초기화
				List<Integer> counts = new ArrayList<>();
				
				// for 반복문을 사용해 각 거리의 개수를 counts에 저장
				for (long distance : distances.keySet())
					counts.add(distances.get(distance));
				
				// write() 메서드를 사용해 주어진 점들로 정사각형을 만들 수 있는지 여부를 출력
				out.write((counts.get(0) == 4 && counts.get(1) == 2) ? "1" : "0");
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}