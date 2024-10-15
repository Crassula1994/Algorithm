package silver3.num14223;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 점의 숫자를 변수 pointNum에 할당
		int pointNum = Integer.parseInt(in.readLine());
		
		// 조건을 만족하는 정사각형 중에서 가장 작은 넓이를 저장할 변수 minArea 초기화
		long minArea = Long.MAX_VALUE;
		
		// 각 점의 좌표를 저장할 2차원 배열 points 초기화
		int[][] points = new int[pointNum][2];
		
		// for 반복문을 사용해 각 점의 좌표를 순회
		for (int idx = 0; idx < pointNum; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 점의 좌표를 2차원 배열 points에 저장
			points[idx][0] = Integer.parseInt(st.nextToken());
			points[idx][1] = Integer.parseInt(st.nextToken());
		}
		
		// for 반복문을 사용해 각 점 중에서 정사각형에 포함하지 않을 두 점의 조합을 순회
		for (int p1 = 0; p1 < pointNum- 1; p1++) {
			for (int p2 = p1 + 1; p2 < pointNum; p2++) {
				
				// 다른 모든 점의 X좌표 및 Y좌표에 대하여 최솟값과 최댓값을 저장할 각 변수 초기화
				int minX = Integer.MAX_VALUE;
				int minY = Integer.MAX_VALUE;
				int maxX = Integer.MIN_VALUE;
				int maxY = Integer.MIN_VALUE;
				
				// for 반복문을 사용해 다른 점을 순회
				for (int p3 = 0; p3 < pointNum; p3++) {
					
					// 해당 점이 포함하지 않을 점인 경우 다음 점을 순회
					if (p3 == p1 || p3 == p2)
						continue;
					
					// min() 및 max() 메서드를 사용해 X좌표 및 Y좌표에 대하여 최솟값과 최댓값을 갱신
					minX = Math.min(points[p3][0], minX);
					minY = Math.min(points[p3][1], minY);
					maxX = Math.max(points[p3][0], maxX);
					maxY = Math.max(points[p3][1], maxY);
				}
				
				// max() 메서드를 사용해 다른 모든 점을 포함하는 정사각형 한 변의 길이를 변수 side에 저장
				long side = Math.max(maxX - minX, maxY - minY) + 2;
				
				// min() 메서드를 사용해 조건을 만족하는 정사각형 중에서 가장 작은 넓이를 갱신
				minArea = Math.min(side * side, minArea);
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 조건을 만족하는 정사각형 중에서 가장 작은 넓이를 출력
		out.write(String.valueOf(minArea));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}