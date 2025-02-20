package silver3.num32589;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseLong() 메서드를 사용해 입력 받은 깃발이 줄무늬 수를 변수 stripeNum에 할당
		long stripeNum = Long.parseLong(in.readLine());
		
		// 다시 칠해야 하는 칸의 수를 저장할 변수 totalCount 초기화
		long totalCount = stripeNum * stripeNum;
		
		// 각 색상을 지닌 줄무늬의 수를 저장할 Map 객체 stripes 초기화
		Map<Integer, Integer> stripes = new HashMap<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 각 줄무늬를 순회
		while (stripeNum-- > 0) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 줄무늬의 색깔을 변수 color에 할당
			int color = Integer.parseInt(st.nextToken());
			
			// getOrDefault() 및 put() 메서드를 사용해 해당 색상을 지닌 줄무늬의 수를 stripes에 저장
			stripes.put(color, stripes.getOrDefault(color, 0) + 1);
		}
		
		// for 반복문을 사용해 각 색상을 순회
		for (int color : stripes.keySet()) {
			
			// get() 메서드를 사용해 해당 색상을 지닌 줄무늬의 수를 변수 count에 할당
			long count = stripes.get(color);
			
			// 다시 칠해야 하는 칸의 수를 갱신
			totalCount -= count * count;
		}
		
		// valueOf() 및 write() 메서드를 사용해 다시 칠해야 하는 칸의 수를 출력
		out.write(String.valueOf(totalCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}