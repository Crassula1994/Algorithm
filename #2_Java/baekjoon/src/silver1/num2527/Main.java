package silver1.num2527;

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

		// for 반복문을 사용해 4개의 테스트 케이스를 순회
		for (int tc = 0; tc < 4; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 첫 번째 사각형의 각 좌표를 나타내는 변수에 저장
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());
			
			// nextToken() 및 parseInt() 메서드를 사용해 두 번째 사각형의 각 좌표를 나타내는 변수에 저장
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			
			// 만나지 않는 경우 'd' 출력
			if (p1 < x2 || q1 < y2 || x1 > p2 || y1 > q2) {
				out.write("d\n");
			
			// 점으로 만나는 경우 'c' 출력
			} else if ((p1 == x2 && y1 == q2) || (p1 == x2 && q1 == y2) || (x1 == p2 && q1 == y2) || (x1 == p2 && y1 == q2)) {
				out.write("c\n");
			
			// 선으로 만나는 경우 'b'출력
			} else if (p1 == x2 || q1 == y2 || x1 == p2 || y1 == q2) {
				out.write("b\n");

			// 직사각형으로 만나는 경우 'a' 출력
			} else {
				out.write("a\n");
			}
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}