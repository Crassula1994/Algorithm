package bronze3.num05063;

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
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 광고에 따른 수익, 비용을 각 변수에 할당
			int revenueA = Integer.parseInt(st.nextToken());
			int revenueB = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			// 광고를 해야 하는 경우 'advertise' 출력
			if (revenueA < revenueB - cost) {
				out.write("advertise");
			
			// 광고를 하지 않아야 하는 경우 'do not advertise' 출력
			} else if (revenueA > revenueB - cost) {
				out.write("do not advertise");

			// 광고를 해도 수익의 차이가 없는 경우 'does not matter' 출력
			} else {
				out.write("does not matter");
			}
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}