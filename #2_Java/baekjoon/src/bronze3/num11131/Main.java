package bronze3.num11131;

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
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 무게 추의 개수를 변수 weightNum에 할당
			int weightNum = Integer.parseInt(in.readLine());
			
			// 현재 작용하는 돌림힘의 크기를 저장할 변수 torque 초기화
			int torque = 0;
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// while 반복문을 사용해 현재 작용하는 돌림힘의 크기를 갱신
			while (weightNum-- > 0)
				torque += Integer.parseInt(st.nextToken());
			
			// 막대가 왼쪽으로 기우는 경우 'Left'를 출력
			if (torque < 0) {
				out.write("Left");
				
			// 막대가 오른쪽으로 기우는 경우 'Right'를 출력
			} else if (torque > 0) {
				out.write("Right");
				
			// 막대가 어느 쪽으로도 기울지 않는 경우 'Equilibrium'을 출력
			} else {
				out.write("Equilibrium");
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}