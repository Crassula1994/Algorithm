package bronze2.num05054;

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
			
			// readLine() 메서드를 사용해 입력 받은 선영이가 방문할 상점의 수를 변수 shopNum에 할당
			int shopNum = Integer.parseInt(in.readLine());
			
			// 선영이가 방문할 상점의 최소 위치와 최대 위치를 저장할 각 변수 초기화
			int minPosition = Integer.MAX_VALUE;
			int maxPosition = Integer.MIN_VALUE;
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// while 반복문을 각 상점의 위치를 순회
			while (shopNum-- > 0) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 상점의 위치를 변수 position에 할당
				int position = Integer.parseInt(st.nextToken());
				
				// min() 및 max() 메서드를 사용해 선영이가 방문할 상점의 최소 위치와 최대 위치를 갱신
				minPosition = Math.min(position, minPosition);
				maxPosition = Math.max(position, maxPosition);
			}
			
			// write() 메서드를 사용해 선영이가 모든 상점을 방문하기 위해 걸어야 하는 거리의 최솟값을 출력
			out.write(((maxPosition - minPosition) * 2) + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}