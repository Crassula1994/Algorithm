package bronze2.num12184;

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
		for (int tc = 1; tc <= testCase; tc++) {
			
			// write() 메서드를 사용해 해당 테스트 케이스 번호를 출력
			out.write("Case #" + tc + ": ");
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 G버스의 수를 변수 busNum에 할당
			int busNum = Integer.parseInt(in.readLine());
			
			// 각 도시를 지나는 버스의 수를 저장할 배열 counts 초기화
			int[] counts = new int[501];
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// while 반복문을 사용해 각 버스를 순회
			while (busNum-- > 0) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 버스 노선의 시작 도시와 끝 도시를 각 변수에 할당
				int startCity = Integer.parseInt(st.nextToken());
				int endCity = Integer.parseInt(st.nextToken());
				
				// for 반복문을 사용해 각 도시를 지나는 버스의 수를 갱신
				for (int idx = startCity; idx <= endCity; idx++)
					counts[idx]++;
			}
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 관심 있는 도시의 수를 변수 cityNum에 할당
			int cityNum = Integer.parseInt(in.readLine());
			
			// while 반복문을 사용해 각 도시를 지나는 버스의 수를 출력
			while (cityNum-- > 0)
				out.write(counts[Integer.parseInt(in.readLine())] + " ");
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
			
			// 마지막 테스트 케이스가 아닌 경우 빈 줄을 제거
			if (tc < testCase)
				in.readLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}