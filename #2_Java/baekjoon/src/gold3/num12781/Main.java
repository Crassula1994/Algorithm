package gold3.num12781;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Point 클래스 정의
	public static class Point {
		
		// 해당 점의 좌표를 저장할 각 변수 초기화
		int x;
		int y;
		
		// 매개변수를 입력 받는 생성자 정의
		public Point(int x, int y) {
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
		
		// 선택한 네 점을 저장할 배열 points 초기화
		Point[] points = new Point[4];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 점의 좌표를 배열 points에 저장
		for (int idx = 0; idx < 4; idx++)
			points[idx] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		// 두 선분에 의해 피자가 네 조각으로 나뉘는 경우 1을 출력
		if (pizzaCutter(points[0], points[1], points[2], points[3])) {
			out.write(String.valueOf(1));
			
		// 두 선분에 의해 피자가 네 조각으로 나뉘지 않는 경우 0을 출력
		} else {
			out.write(String.valueOf(0));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// pizzaCutter() 메서드 정의
	public static boolean pizzaCutter(Point point1, Point point2, Point point3, Point point4) {
		
		// ccwCalculator() 메서드를 호출해 그 결과를 각 변수에 할당
		int isCrossed1 = ccwCalculator(point1, point2, point3) * ccwCalculator(point1, point2, point4);
		int isCrossed2 = ccwCalculator(point3, point4, point1) * ccwCalculator(point3, point4, point2);
		
		// 두 선분이 교차하는지 여부를 반환
		return isCrossed1 < 0 && isCrossed2 < 0;
	}
	
	// ----------------------------------------------------------------------------------------------------

	// ccwCalculator() 메서드 정의
	public static int ccwCalculator(Point point1, Point point2, Point point3) {
		
		// 세 점을 이은 직선의 방향를 나타내는 값을 계산해 변수 direction에 할당
		int direction = (point2.x - point1.x) * (point3.y - point1.y) - (point3.x - point1.x) * (point2.y - point1.y);
		
		// 세 점을 이은 직선의 방향이 일직선인 경우 0을 반환
		if (direction == 0)
			return 0;
		
		// 세 점을 이은 직선의 방향이 시계 방향인지 반시계 방향인지에 따라 -1 또는 1을 반환
		return direction < 0 ? -1 : 1;
	}
}