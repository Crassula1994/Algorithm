package bronze1.num13450;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

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
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 첫 번째 무방향 그래프의 간선 수를 변수 edgeCntA에 할당
			int edgeCntA = Integer.parseInt(in.readLine());
			
			// for 반복문을 사용해 첫 번째 무방향 그래프의 각 간선을 순회
			for (int edge = 0; edge < edgeCntA; edge++)
				in.readLine();
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 두 번째 무방향 그래프의 간선 수를 변수 edgeCntB에 할당
			int edgeCntB = Integer.parseInt(in.readLine());
			
			// for 반복문을 사용해 두 번째 무방향 그래프의 각 간선을 순회
			for (int edge = 0; edge < edgeCntB; edge++)
				in.readLine();
			
			// write() 메서드를 사용해 두 그래프가 동형인지 여부를 출력
			out.write((edgeCntA == edgeCntB) ? "yes" : "no");
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}