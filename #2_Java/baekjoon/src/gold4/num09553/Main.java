package gold4.num09553;

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
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 타겟의 수를 변수 targetNum에 할당
			int targetNum = Integer.parseInt(in.readLine());
			
			// 화살 한 발로 맞힐 수 있는 타겟 수의 기댓값을 저장할 변수 expectation 초기화
			double expectation = 0;
			
			// for 반복문을 사용해 각 타겟을 순회
			for (int target = 0; target < targetNum; target++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseDouble() 메서드를 사용해 입력 받은 타겟의 각 좌표를 각 변수에 할당
				double startX = Double.parseDouble(st.nextToken());
				double startY = Double.parseDouble(st.nextToken());
				double endX = Double.parseDouble(st.nextToken());
				double endY = Double.parseDouble(st.nextToken());
				
				// probabilityCalculator() 메서드를 호출해 화살 한 발로 맞힐 수 있는 타겟 수의 기댓값을 갱신
				expectation += probabilityCalculator(startX, startY, endX, endY);
			}
			
			// format() 및 write() 메서드를 사용해 기댓값을 소수점 다섯 번째 자리까지 출력
			out.write(String.format("%.5f", expectation));
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// probabilityCalculator() 메서드 정의
	public static double probabilityCalculator(double startX, double startY, double endX, double endY) {
		
		// sqrt() 메서드를 사용해 두 점의 내적과 크기를 계산하고 각 변수에 할당
		double product = startX * endX + startY * endY;
		double magnitudeStart = Math.sqrt(startX * startX + startY * startY);
		double magnitudeEnd = Math.sqrt(endX * endX + endY * endY);
		
		// 두 점의 내적과 크기를 사용해 두 선분이 원점과 이루는 각도의 코사인 값을 변수 cosAngle에 할당
		double cosAngle = product / (magnitudeStart * magnitudeEnd);
		
		// min(), max(), acos() 메서드를 사용해 두 선분과 원점이 이루는 각도를 계산하고 변수 angle에 할당
		double angle = Math.acos(Math.max(Math.min(cosAngle, 1), -1));
		
		// 360도 중 해당 각도가 차지하는 비율을 확률로서 반환
		return angle / (Math.PI * 2);
	}
}