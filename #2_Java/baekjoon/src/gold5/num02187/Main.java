package gold5.num02187;

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
		
		// 해당 점의 세로 좌표, 가로 좌표, 가중치를 나타낼 각 변수 초기화
		int row;
		int column;
		int scale;
		
		// 매개변수를 입력 받는 생성자 정의
		public Point (int row, int column, int scale) {
			this.row = row;
			this.column = column;
			this.scale = scale;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 점의 개수, 직사각형의 크기를 각 변수에 할당
		int pointNum = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		// 가중치의 최댓값과 최솟값의 차이가 최대일 경우의 값을 저장할 변수 maxDiff 초기화
		int maxDiff = 0;
		
		// 각 점의 정보를 저장할 배열 points 초기화
		Point[] points = new Point[pointNum];
		
		// for 반복문을 사용해 각 점의 정보를 순회
		for (int idx = 0; idx < points.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 점의 정보를 각 변수에 할당
			int row = Integer.parseInt(st.nextToken());
			int column = Integer.parseInt(st.nextToken());
			int scale = Integer.parseInt(st.nextToken());
			
			// 해당 점의 정보를 배열 points에 저장
			points[idx] = new Point(row, column, scale);
		}
		
		// for 반복문을 사용해 두 점의 쌍을 순회
		for (int p1 = 0; p1 < pointNum - 1; p1++) {
			for (int p2 = p1 + 1; p2 < pointNum; p2++) {
			
				// 두 점을 각 변수에 할당
				Point point1 = points[p1];
				Point point2 = points[p2];
				
				// 두 점이 세로로 떨어진 거리가 직사각형 내에 포함될 수 없는 경우 다음 쌍을 순회 
				if (Math.abs(point1.row - point2.row) + 1 > height)
					continue;
				
				// 두 점이 가로로 떨어진 거리가 직사각형 내에 포함될 수 없는 경우 다음 쌍을 순회 
				if (Math.abs(point1.column - point2.column) + 1 > width)
					continue;
				
				// abs() 및 max() 메서드를 사용해 가중치의 최댓값과 최솟값의 차이가 최대일 경우의 값을 갱신
				maxDiff = Math.max(Math.abs(point1.scale - point2.scale), maxDiff);
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 가중치의 최댓값과 최솟값의 차이가 최대일 경우의 값을 출력
		out.write(String.valueOf(maxDiff));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}