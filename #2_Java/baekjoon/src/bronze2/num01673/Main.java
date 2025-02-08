package bronze2.num01673;

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
		
		// 각 테스트 케이스를 저장할 변수 testCase 초기화
		String testCase;
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while ((testCase = in.readLine()) != null) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(testCase);
			
			/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 현재 가지고 있는 쿠폰의 수
			및 치킨 쿠폰을 교환해주는 도장의 수를 각 변수에 할당 */
			int curCoupon = Integer.parseInt(st.nextToken());
			int stampLimit = Integer.parseInt(st.nextToken());
			
			// 강민이가 가진 치킨 쿠폰으로 최대로 먹을 수 있는 치킨의 수, 현재 도장의 수를 저장할 변수 maxCount 초기화
			int maxCount = curCoupon;
			int stampCnt = curCoupon;
			
			// while 반복문을 사용해 강민이가 더 이상 치킨을 주문할 수 없을 때까지 순회
			while (stampCnt >= stampLimit) {
				
				// 현재 강민이가 가진 치킨 쿠폰으로 다시 얻을 수 있는 쿠폰의 수를 변수 nextCoupon에 할당
				int nextCoupon = stampCnt / stampLimit;
				
				// 최대로 먹을 수 있는 치킨의 수 및 현재 도장의 수를 갱신
				maxCount += nextCoupon;
				stampCnt = stampCnt % stampLimit + nextCoupon;
			}
			
			// write() 메서드를 사용해 강민이가 가진 치킨 쿠폰으로 최대로 먹을 수 있는 치킨의 수를 출력
			out.write(maxCount + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}