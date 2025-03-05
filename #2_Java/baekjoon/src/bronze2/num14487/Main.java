package bronze2.num14487;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 마을의 수를 변수 villageNum 초기화
		int villageNum = Integer.parseInt(in.readLine());
		
		// 모든 길의 이동 비용의 합과 가장 비싼 도로의 이동 비용을 저장할 각 변수 초기화
		int costSum = 0;
		int maxCost = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 각 마을의 이동 비용을 순회
		while (villageNum-- > 0) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 마을의 이동 비용을 변수 cost에 할당
			int cost = Integer.parseInt(st.nextToken());
			
			// 모든 길의 이동 비용의 합을 갱신
			costSum += cost;
			
			// max() 메서드를 사용해 가장 비싼 도로의 이동 비용을 갱신
			maxCost = Math.max(cost, maxCost);
		}
		
		// valueOf() 및 write() 메서드를 사용해 모든 마을을 관광하기 위해 필요한 최소 이동 비용을 출력
		out.write(String.valueOf(costSum - maxCost));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}