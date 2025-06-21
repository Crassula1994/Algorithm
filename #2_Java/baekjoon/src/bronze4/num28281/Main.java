package bronze4.num28281;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 동원이의 생일까지 남은 일 수,
		한번에 구매할 양말의 개수를 각 변수에 할당 */
		int dayNum = Integer.parseInt(st.nextToken());
		int countLimit = Integer.parseInt(st.nextToken());
		
		// 양말을 사는 데 드는 최소 비용을 저장할 변수 minCost 초기화
		int minCost = Integer.MAX_VALUE;
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 이전 날짜의 양말 가격을 변수 prevPrice에 할당
		int prevPrice = Integer.parseInt(st.nextToken());
		
		// while 반복문을 사용해 각 날짜를 순회
		while (dayNum-- > 1) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 현재 날짜의 양말 가격을 변수 curPrice에 할당
			int curPrice = Integer.parseInt(st.nextToken());
			
			// min() 메서드를 사용해 양말을 사는 데 드는 최소 비용을 갱신
			minCost = Math.min((prevPrice + curPrice) * countLimit, minCost);
			
			// 이전 날짜의 양말 가격을 현재 날짜의 양말 가격으로 갱신
			prevPrice = curPrice;
		}
		
		// valueOf() 및 write() 메서드를 사용해 양말을 사는 데 드는 최소 비용을 출력
		out.write(String.valueOf(minCost));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}