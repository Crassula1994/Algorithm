package silver4.num15970;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Point 클래스 정의
	static class Point implements Comparable<Point> {
		
		// 해당 점의 위치 및 색깔을 나타낼 각 변수 초기화
		int location;
		int color;
		
		// 매개변수를 입력 받는 생성자 정의
		public Point(int location, int color) {
			this.location = location;
			this.color = color;
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(Point anotherPoint) {
			
			// 두 점의 색깔이 같은 경우 위치를 기준으로 오름차순 정렬
			if (this.color == anotherPoint.color)
				return this.location - anotherPoint.location;
			
			// 두 점의 색깔이 다른 경우 색깔을 기준으로 오름차순 정렬
			return this.color - anotherPoint.color;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 점들의 개수를 변수 pointNum에 할당
		int pointNum = Integer.parseInt(in.readLine());
		
		// 모든 점에서 시작하는 화살표들의 길이 합을 저장할 변수 lengthSum 초기화
		int lengthSum = 0;
		
		// 각 점의 정보를 저장할 배열 points 초기화
		Point[] points = new Point[pointNum];
		
		// for 반복문을 사용해 각 점들의 정보를 순회
		for (int idx = 0; idx < points.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 점의 위치 및 색깔을 각 변수에 할당
			int location = Integer.parseInt(st.nextToken());
			int color = Integer.parseInt(st.nextToken());
			
			// 해당 점의 정보를 배열 points에 저장
			points[idx] = new Point(location, color);
		}
		
		// sort() 메서드를 사용해 각 점을 색깔과 위치를 기준으로 정렬
		Arrays.sort(points);
		
		// for 반복문을 사용해 각 점을 순회
		for (int idx = 0; idx < points.length; idx++) {
			
			// 가장 마지막에 위치한 점이거나 오른쪽 점과 색깔이 다른 경우 왼쪽 점과의 거리를 화살표들의 길이 합에 갱신
			if (idx == pointNum - 1 || points[idx].color != points[idx + 1].color) {
				lengthSum += points[idx].location - points[idx - 1].location;
				
			// 가장 처음에 위치한 점이거나 왼쪽 점과 색깔이 다른 경우 오른쪽 점과의 거리를 화살표들의 길이 합에 갱신
			} else if (idx == 0 || points[idx].color != points[idx - 1].color) {
				lengthSum += points[idx + 1].location - points[idx].location;
				
			// 양끝에 위치한 점이 아니고, 왼쪽 점과 오른쪽 점 모두 색깔이 같은 경우
			} else {
				
				// 왼쪽 점 및 오른쪽 점과의 거리를 계산해 각 변수에 할당
				int leftDist = points[idx].location - points[idx - 1].location;
				int rightDist = points[idx + 1].location - points[idx].location;
				
				// min() 메서드를 사용해 더 가까운 점과의 거리를 화살표들의 길이 합에 갱신
				lengthSum += Math.min(leftDist, rightDist);
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 모든 점에서 시작하는 화살표들의 길이 합을 출력
		out.write(String.valueOf(lengthSum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}