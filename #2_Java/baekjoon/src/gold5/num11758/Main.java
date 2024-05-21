package gold5.num11758;

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
		
		// 각 점의 좌표를 저장할 2차원 배열 points 초기화
		int[][] points = new int[4][2];
		
		// for 반복문을 사용해 각 점을 순회
		for (int point = 1; point <= 3; point++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 각 점의 좌표를 2차원 배열 points에 저장
			points[point][0] = Integer.parseInt(st.nextToken());
			points[point][1] = Integer.parseInt(st.nextToken());
		}
		
		// 세 점을 이은 선분의 방향을 판단할 공식을 계산해 변수 result에 할당
		int result = (points[2][0] - points[1][0]) * (points[3][1] - points[1][1])
				- (points[3][0] - points[1][0]) * (points[2][1] - points[1][1]);
		
		// 세 점이 반시계 방향을 나타내는 경우 1을 출력
		if (result > 0) {
			out.write(String.valueOf(1));
		
		// 세 점이 시계 방향을 나타내는 경우 -1을 출력
		} else if (result < 0) {
			out.write(String.valueOf(-1));
			
		// 세 점이 일직선인 경우 0을 출력
		} else {
			out.write(String.valueOf(0));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}