package gold4.num10437;

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
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 번호와 목표 점의 좌표를 각 변수에 할당
			int caseNum = Integer.parseInt(st.nextToken());
			int targetPointX = Integer.parseInt(st.nextToken());
			int targetPointY = Integer.parseInt(st.nextToken());
			
			// write() 메서드를 사용해 테스트 케이스의 번호를 출력
			out.write(caseNum + " ");
			
			// 목표 점에 두 번 만에 도달 가능한 경우 필요한 성장 횟수와 그 방법을 출력
			if (targetPointX < targetPointY) {
				out.write(2 + " " + targetPointX + " " + targetPointY);
			
			// 목표 점에 여섯 번 만에 도달 가능한 경우 필요한 성장 횟수와 그 방법을 출력
			} else if (targetPointY >= 4) {
				out.write(6 + " ");
				out.write(1 + " " + 2 + " " + 3 + " ");
				out.write((targetPointX - targetPointY + 5) + " " + (targetPointX + 2) + " " + (targetPointX + 3));
				
			// 목표 점에 도달할 수 없는 경우 'NO PATH'를 출력
			} else {
				out.write("NO PATH");
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}