package platinum4.num20149;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 선분이 교차하는지, 한 점에서 교차하는지, 교차하는 좌표를 저장할 각 변수 초기화
	static boolean isCrossed;
	static boolean atPoint;
	static double pointX;
	static double pointY;
	
	// ----------------------------------------------------------------------------------------------------
	
	// Point 클래스 정의
	public static class Point {
		
		// 해당 점의 좌표를 저장할 각 변수 초기화
		long x;
		long y;
		
		// 매개변수를 입력 받는 생성자 정의
		public Point(long x, long y) {
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
		
		// StringTokenizer 객체를 불러와 각 선분의 좌표값을 저장할 각 변수에 할당
		StringTokenizer line1 = new StringTokenizer(in.readLine());
		StringTokenizer line2 = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 점을 각 변수에 할당
		Point point1 = new Point(Integer.parseInt(line1.nextToken()), Integer.parseInt(line1.nextToken()));
		Point point2 = new Point(Integer.parseInt(line1.nextToken()), Integer.parseInt(line1.nextToken()));
		Point point3 = new Point(Integer.parseInt(line2.nextToken()), Integer.parseInt(line2.nextToken()));
		Point point4 = new Point(Integer.parseInt(line2.nextToken()), Integer.parseInt(line2.nextToken()));
		
		// lineChecker() 메서드를 호출해 선분이 교차하는지 여부와 그 교점을 갱신
		lineChecker(point1, point2, point3, point4);
		
		// 선분이 교차하는 경우 1을 출력
		if (isCrossed) {
			out.write(String.valueOf(1));
			
			// 선분이 한 점에서 교차하는 경우 교차하는 좌표를 출력
			if (atPoint)
				out.write("\n" + pointX + " " + pointY);
			
		// 선분이 교차하지 않는 경우 0을 출력
		} else {
			out.write(String.valueOf(0));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// lineChecker() 메서드 정의
	public static void lineChecker(Point point1, Point point2, Point point3, Point point4) {
		
		// ccwCalculator() 메서드를 호출해 그 결과를 각 변수에 할당
		int ccw123 = ccwCalculator(point1, point2, point3);
		int ccw124 = ccwCalculator(point1, point2, point4);
		int ccw341 = ccwCalculator(point3, point4, point1);
		int ccw342 = ccwCalculator(point3, point4, point2);
		
		// 두 선분이 일직선 상에 위치하는 경우
		if (ccw123 * ccw124 == 0 && ccw341 * ccw342 == 0) {
			
			// min() 및 max() 메서드를 사용해 첫 번째 선분의 각 점 좌표를 각 변수에 할당
			long minXLine1 = Math.min(point1.x, point2.x);
			long minYLine1 = Math.min(point1.y, point2.y);
			long maxXLine1 = Math.max(point1.x, point2.x);
			long maxYLine1 = Math.max(point1.y, point2.y);
			
			// min() 및 max() 메서드를 사용해 두 번째 선분의 각 점 좌표를 각 변수에 할당
			long minXLine2 = Math.min(point3.x, point4.x);
			long minYLine2 = Math.min(point3.y, point4.y);
			long maxXLine2 = Math.max(point3.x, point4.x);
			long maxYLine2 = Math.max(point3.y, point4.y);
			
			// 두 선분이 교차하는지 여부를 갱신
			isCrossed = minXLine1 <= maxXLine2 && minXLine2 <= maxXLine1
					&& minYLine1 <= maxYLine2 && minYLine2 <= maxYLine1;
			
			// 두 선분이 교차하는 경우
			if (isCrossed) {
				
				// 두 선분이 평행하게 존재하는 경우
				if (ccw123 == 0 && ccw124 == 0 && ccw341 == 0 && ccw342 == 0) {
					
					// 두 선분이 무수히 많은 점에서 교차하는 경우 한 점에서 교차하는지 여부 갱신 후 메서드 종료
					if ((minXLine1 < maxXLine2 && minXLine2 < maxXLine1)
							|| (minYLine1 < maxYLine2 && minYLine2 < maxYLine1)) {
						atPoint = false;
						return;
					}
				}
				
				// 두 선분이 첫 번째 선분의 첫 번째 점에서 교차하는 경우 한 점에서 교차하는지 여부 및 교차하는 좌표 갱신
				if ((point1.x == point3.x && point1.y == point3.y) || (point1.x == point4.x && point1.y == point4.y)) {
					atPoint = true;
					pointX = point1.x;
					pointY = point1.y;
					
				// 두 선분이 첫 번째 선분의 두 번째 점에서 교차하는 경우 한 점에서 교차하는지 여부 및 교차하는 좌표 갱신
				} else {
					atPoint = true;
					pointX = point2.x;
					pointY = point2.y;
				}
			}
			
			// 메서드 종료
			return;
		}
		
		// 두 선분이 교차하는지 여부를 갱신
		isCrossed = ccw123 * ccw124 <= 0 && ccw341 * ccw342 <= 0;
		
		// 두 선분이 교차하는 경우 한 점에서 만나므로 pointFinder() 메서드를 호출해 교차하는 좌표를 찾아 갱신
		if (isCrossed) {
			atPoint = true;
			pointFinder(point1, point2, point3, point4);
		}
	}
	
	// ----------------------------------------------------------------------------------------------------

	// ccwCalculator() 메서드 정의
	public static int ccwCalculator(Point point1, Point point2, Point point3) {
		
		// 세 점을 이은 직선의 방향를 나타내는 값을 계산해 변수 direction에 할당
		long direction = (point2.x - point1.x) * (point3.y - point1.y) - (point3.x - point1.x) * (point2.y - point1.y);
		
		// 세 점을 이은 직선의 방향이 일직선인 경우 0을 반환
		if (direction == 0)
			return 0;
		
		// 세 점을 이은 직선의 방향이 시계 방향인지 반시계 방향인지에 따라 -1 또는 1을 반환
		return direction < 0 ? -1 : 1;
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// pointFinder() 메서드 정의
	public static void pointFinder(Point point1, Point point2, Point point3, Point point4) {
		
		// 첫 번째 선분의 기울기가 무한대인 경우
		if (point1.x == point2.x) {
			
			// 교차하는 좌표의 x축 좌표를 갱신
			pointX = point1.x;
			
			// slopeCalculator() 메서드를 호출해 교차하는 좌표의 y축 좌표를 갱신
			pointY = slopeCalculator(point3, point4) * (pointX - point3.x) + point3.y; 
			
		// 두 번째 선분의 기울기가 무한대인 경우
		} else if (point3.x == point4.x) {
			
			// 교차하는 좌표의 x축 좌표를 갱신
			pointX = point3.x;
			
			// slopeCalculator() 메서드를 호출해 교차하는 좌표의 y축 좌표를 갱신
			pointY = slopeCalculator(point1, point2) * (pointX - point1.x) + point1.y; 
		
		// 두 선분의 기울기가 모두 무한대가 아닌 경우
		} else {
			
			// slopeCalculator() 메서드를 호출해 두 선분의 기울기를 각 변수에 할당
			double slope1 = slopeCalculator(point1, point2);
			double slope2 = slopeCalculator(point3, point4);
			
			// 교차하는 좌표의 x축 좌표와 y축 좌표를 갱신
			pointX = (slope1 * point1.x - slope2 * point3.x + point3.y - point1.y) / (slope1 - slope2);
			pointY = slope1 * (pointX - point1.x) + point1.y;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------

	// slopeCalculator() 메서드 정의
	public static double slopeCalculator(Point point1, Point point2) {
		
		// 주어진 선분의 기울기를 계산해 반환
		return ((double) point2.y - point1.y) / (point2.x - point1.x);
	}
}