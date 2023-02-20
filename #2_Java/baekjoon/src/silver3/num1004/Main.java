package silver3.num1004;

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
			
			// 어린 왕자의 행성계 진입 및 이탈 횟수를 저장할 변수 inOutNum 초기화
			int inOutNum = 0;
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 출발점 및 도착점의 각 좌표를 변수에 할당
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 행성계의 수를 변수 planetSys에 할당
			int planetSys = Integer.parseInt(in.readLine());
			
			// for 반복문을 사용해 각 행성계를 순회
			for (int sys = 0; sys < planetSys; sys++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 행성계의 중점 및 반지름을 각 변수에 할당
				int sysX = Integer.parseInt(st.nextToken());
				int sysY = Integer.parseInt(st.nextToken());
				int sysR = Integer.parseInt(st.nextToken());
				
				// 출발점과 행성계의 중점까지의 거리 제곱, 도착점과 행성계의 중점까지의 거리 제곱을 계산해 각 변수에 할당
				int startDist = (startX - sysX) * (startX - sysX) +  (startY - sysY) * (startY - sysY);
				int endDist = (endX - sysX) * (endX - sysX) + (endY - sysY) * (endY - sysY);
				int radius = sysR * sysR;
				
				// 출발점과 도착점이 모두 행성계 내부에 존재하는 경우 다음 행성계로 넘기기
				if (startDist < radius && endDist < radius) {
					continue;
				
				// 출발점 또는 도착점 둘 중 하나가 행성계 내부에 존재하는 경우 행성계 진입 및 이탈 횟수 갱신
				} else if (startDist < radius || endDist < radius) {
					inOutNum++;
				}
			}
			
			// write() 메서드를 사용해 행성계 진입 및 이탈 횟수 출력
			out.write(inOutNum + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}