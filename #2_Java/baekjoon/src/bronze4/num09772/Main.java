package bronze4.num09772;

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
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseDouble() 메서드를 사용해 주어진 점의 좌표를 각 변수에 할당
			double coordinateX = Double.parseDouble(st.nextToken());
			double coordinateY = Double.parseDouble(st.nextToken());
			
			// 해당 점이 X축 또는 Y축에 위치하는 경우 'AXIS' 출력
			if (coordinateX == 0 || coordinateY == 0) {
				out.write("AXIS");
			
				// (0, 0)의 좌표가 입력된 경우 반복문 탈출
				if (coordinateX == 0 && coordinateY == 0)
					break;
				
			// 해당 점이 1사분면에 위치한 경우 'Q1' 출력
			} else if (coordinateX > 0 && coordinateY > 0) {
				out.write("Q1");
				
			// 해당 점이 2사분면에 위치한 경우 'Q2' 출력
			} else if (coordinateX < 0 && coordinateY > 0) {
				out.write("Q2");
				
			// 해당 점이 3사분면에 위치한 경우 'Q3' 출력
			} else if (coordinateX < 0 && coordinateY < 0) {
				out.write("Q3");
				
			// 해당 점이 4사분면에 위치한 경우 'Q4' 출력	
			} else {
				out.write("Q4");
			}
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}