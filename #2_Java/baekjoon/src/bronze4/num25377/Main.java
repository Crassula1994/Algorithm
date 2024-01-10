package bronze4.num25377;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 가게의 수를 변수 storeNum에 할당
		int storeNum = Integer.parseInt(in.readLine());
		
		// 빵을 구하는 데 걸리는 최소 시간을 저장할 변수 minTime 초기화
		int minTime = Integer.MAX_VALUE;
		
		// for 반복문을 사용해 각 가게를 순회
		for (int store = 0; store < storeNum; store++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 가게까지 소요 시간, 빵이 들어올 때까지의 시간을 각 변수에 할당
			int requiredTime = Integer.parseInt(st.nextToken());
			int targetTime = Integer.parseInt(st.nextToken());
			
			// 빵을 구할 수 있는 경우 빵을 구하는 데 걸리는 최소 시간을 갱신
			if (requiredTime <= targetTime)
				minTime = Math.min(minTime, targetTime);
		}
		
		// 빵을 살 수 없는 경우 -1을 출력
		if (minTime == Integer.MAX_VALUE) {
			out.write(String.valueOf(-1));
			
		// 빵을 살 수 있는 경우 빵을 구하는 데 걸리는 최소 시간을 출력
		} else {
			out.write(String.valueOf(minTime));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}