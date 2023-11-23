package bronze1.num14467;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 관찰 횟수를 변수 watchNum에 할당
		int watchNum = Integer.parseInt(in.readLine());
		
		// 소가 길을 건넌 최소 횟수를 저장할 변수 minCount 초기화
		int minCount = 0;
		
		// 관찰 결과를 저장할 Map 객체 watchResult 초기화
		Map<Integer, Integer> watchResult = new HashMap<>();
		
		// for 반복문을 사용해 각 관찰 횟수를 순회
		for (int w = 0; w < watchNum; w++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 소의 번호와 위치를 각 변수에 할당
			int number = Integer.parseInt(st.nextToken());
			int location = Integer.parseInt(st.nextToken());
			
			// 해당 소를 처음 관찰하지 않고 소가 길을 건넌 경우 소가 길을 건넌 최소 횟수를 갱신
			if (watchResult.containsKey(number) && watchResult.get(number) != location)
				minCount++;
			
			// put() 메서드를 사용해 해당 소의 관찰 정보를 watchResult에 추가
			watchResult.put(number, location);
		}
		
		// valueOf() 및 write() 메서드를 사용해 소가 길을 건넌 최소 횟수를 출력
		out.write(String.valueOf(minCount));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}