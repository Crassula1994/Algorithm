package silver2.num12409;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 1; tc <= testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseDouble() 메서드를 사용해 입력 받은 목표의 양 끝점의 좌표를 각 변수에 할당
			double targetX1 = Double.parseDouble(st.nextToken());
			double targetY1 = Double.parseDouble(st.nextToken());
			double targetX2 = Double.parseDouble(st.nextToken());
			double targetY2 = Double.parseDouble(st.nextToken());
			
			// 카즈키가 목표를 볼 수 있는 최대 가시 각도를 저장할 변수 maxAngle 초기화
			double maxAngle = 0;
			
			// for 반복문을 사용해 가능한 카즈키의 위치를 순회
			for (double originX = -20.0; originX <= 20.0; originX += 0.001) {
				
				// atan2() 및 toDegrees() 메서드를 사용해 목표의 각 끝 점과 카즈키의 위치가 이루는 각도를 각 변수에 할당
				double angle1 = Math.toDegrees(Math.atan2(targetY1, targetX1 - originX));
				double angle2 = Math.toDegrees(Math.atan2(targetY2, targetX2 - originX));
				
				// abs() 및 max() 메서드를 사용해 카즈키가 목표를 볼 수 있는 최대 가시 각도를 갱신
				maxAngle = Math.max(Math.abs(angle1 - angle2), maxAngle);
			}
			
			// format() 및 write() 메서드를 사용해 카즈키가 목표를 볼 수 있는 최대 가시 각도를 출력
			out.write(String.format("Case #%d: %.4f", tc, maxAngle));
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}