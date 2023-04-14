package gold5.num01011;

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
			
			// nextToken() 및 parseInt() 메서드를 사용해 현재 위치과 목표 위치를 각 변수에 할당
			int currentLoc = Integer.parseInt(st.nextToken());
			int targetLoc = Integer.parseInt(st.nextToken());
			
			// 두 위치 사이의 거리를 변수 distance에 할당
			int distance = targetLoc - currentLoc;
			
			// sqrt() 메서드를 사용해 공간 이동 시 가장 먼 거리를 이동하는 경우의 거리를 변수 maxMove에 저장
			int maxMove = (int) Math.sqrt(distance);
			
			// 공간 이동 장치의 최소 작동 횟수를 저장할 변수 minCnt 초기화
			int minCnt = 0;
			
			// 가장 먼 거리를 이동하는 경우의 거리의 제곱이 거리와 동일한 경우 최소 작동 횟수를 갱신
			if (maxMove * maxMove == distance) {
				minCnt = 2 * maxMove - 1;
				
			// 가장 먼 거리를 이동하는 경우의 제곱에 이를 더한 값이 거리보다 크거나 같은 경우 최소 작동 횟수를 갱신
			} else if (maxMove * maxMove + maxMove >= distance) {
				minCnt = 2 * maxMove;
				
			// 나머지 경우 최소 작동 횟수를 갱신
			} else {
				minCnt = 2 * maxMove + 1;
			}
				
			// write() 메서드를 사용해 공간 이동 장치의 최소 작동 횟수를 출력
			out.write(minCnt + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}