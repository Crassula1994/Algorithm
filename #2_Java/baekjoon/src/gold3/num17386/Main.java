package gold3.num17386;

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
		
		// 선분이 교차하는 경우 1을 출력
		if (lineChecker(point1, point2, point3, point4)) {
			out.write(String.valueOf(1));
			
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
	public static boolean lineChecker(Point point1, Point point2, Point point3, Point point4) {
		
		// ccwCalculator() 메서드를 호출해 그 결과를 각 변수에 할당
		int isCrossed1 = ccwCalculator(point1, point2, point3) * ccwCalculator(point1, point2, point4);
		int isCrossed2 = ccwCalculator(point3, point4, point1) * ccwCalculator(point3, point4, point2);
		
		// 두 선분이 교차하는지 여부를 반환
		return isCrossed1 < 0 && isCrossed2 < 0;
	}
	
	// ----------------------------------------------------------------------------------------------------

	// ccwCalculator() 메서드 정의
	public static int ccwCalculator(Point point1, Point point2, Point point3) {
		return (point2.x - point1.x) * (point3.y - point1.y) - (point3.x - point1.x) * (point2.y - point1.y) < 0 ? -1 : 1;
	}
}