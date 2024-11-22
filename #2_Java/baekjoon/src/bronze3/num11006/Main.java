package bronze3.num11006;

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
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 닭 다리 수의 합과 닭의 수를 각 변수에 할당
			int legNum = Integer.parseInt(st.nextToken());
			int chickenNum = Integer.parseInt(st.nextToken());
			
			// 다리가 잘린 닭의 수와 멀쩡한 닭의 수를 계산해 각 변수에 할당
			int oneLegCount = chickenNum * 2 - legNum;
			int twoLegCount = chickenNum - oneLegCount;
			
			// write() 메서드를 사용해 다리가 잘린 닭의 수와 멀쩡한 닭의 수를 출력
			out.write(oneLegCount + " " + twoLegCount + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}