package silver3.num1002;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 위치 정보를 변수에 할당
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			// 두 사람 사이의 거리를 계산해 변수 distance에 할당
			int distance = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
			
			// 두 사람의 류재명과의 거리의 합 및 차의 제곱을 계산해 각 변수에 할당
			int sum = (r1 + r2) * (r1 + r2);
			int diff = (r1 - r2) * (r1 - r2);
			
			// 류재명이 있을 수 있는 위치가 무수히 많은 경우 -1을 출력
			if (x1 == x2 && y1 == y2 && r1 == r2) {
				out.write(-1 + "\n");
			
			// 류재명이 있을 수 있는 위치가 2개인 경우 2를 출력
			} else if (distance > diff && distance < sum) {
				out.write(2 + "\n");
				
			// 류재명이 있을 수 있는 위치가 1개인 경우 1을 출력
			} else if (sum == distance || diff == distance) {
				out.write(1 + "\n");
			
			// 류재명이 있을 수 있는 위치가 0개인 경우 0을 출력
			} else {
				out.write(0 + "\n");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}