package gold2.num07869;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Circle 클래스 정의
	public static class Circle {
		
		// 원의 중심의 좌표 및 반지름을 저장할 각 변수 초기화
		double x;
		double y;
		double radius;
		
		// 매개변수를 입력 받는 생성자 정의
		public Circle(double x, double y, double radius) {
			this.x = x;
			this.y = y;
			this.radius = radius;
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
		
		// nextToken() 및 parseDouble() 메서드를 사용해 입력 받은 두 원의 중심 좌표와 반지름을 각 변수에 할당
		Circle circle1 = new Circle(Double.parseDouble(st.nextToken()),
				Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
		Circle circle2 = new Circle(Double.parseDouble(st.nextToken()),
				Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
				
		// circleChecker() 메서드를 호출해 교차하는 영역의 넓이를 변수 area에 할당
		double area = circleChecker(circle1, circle2);
		
		// format() 및 write() 메서드를 사용해 교차하는 영역의 넓이를 반올림해 소수점 셋째 자리까지 출력
		out.write(String.format("%.3f", area));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// circleChecker() 메서드 정의
	public static double circleChecker(Circle circle1, Circle circle2) {
		
		// pow() 및 sqrt() 메서드를 사용해 두 원의 중심 사이의 거리를 계산해 변수 distance에 할당
		double distance = Math.sqrt(Math.pow(circle1.x - circle2.x, 2) + Math.pow(circle1.y - circle2.y, 2));

		// 두 원이 서로 겹치지 않는 경우 0을 반환
		if (circle1.radius + circle2.radius <= distance)
			return 0;
		
		// 두 원 중 한 원이 모두 겹치는 경우 작은 원의 넓이를 반환
		if (Math.abs(circle1.radius - circle2.radius) >= distance)
			return Math.pow(Math.min(circle1.radius, circle2.radius), 2) * Math.PI;
		
		// angleCalculator() 메서드를 호출해 두 원이 서로 겹치는 부분에 해당하는 부채꼴의 중심각을 각 변수에 할당
		double angle1 = angleCalculator(circle1.radius, circle2.radius, distance);
		double angle2 = angleCalculator(circle2.radius, circle1.radius, distance);
		
		// areaCalculator() 메서드를 호출해 두 원이 서로 겹치는 부분의 넓이를 반환
		return areaCalculator(circle1.radius, angle1) + areaCalculator(circle2.radius, angle2);
	}
	
	// ----------------------------------------------------------------------------------------------------

	// angleCalculator() 메서드 정의
	public static double angleCalculator(double r1, double r2, double d) {
		return 2 * Math.acos((Math.pow(r1, 2) + Math.pow(d, 2) - Math.pow(r2, 2)) / (2 * r1 * d));
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// areaCalculator() 메서드 정의
	public static double areaCalculator(double radius, double angle) {
		return Math.pow(radius, 2) * (angle - Math.sin(angle)) / 2;
	}
}