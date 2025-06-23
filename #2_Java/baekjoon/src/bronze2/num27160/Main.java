package bronze2.num27160;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 카드의 개수를 변수 cardNum에 할당
		int cardNum = Integer.parseInt(in.readLine());
		
		// 한별이가 종을 쳐야 하는지 여부를 나타낼 변수 shouldRing 초기화
		boolean shouldRing = false;
		
		// 펼쳐진 카드에 존재하는 각 과일별 개수를 저장할 Map 객체 fruitCounts 초기화
		Map<String, Integer> fruitCounts = new HashMap<>();
		
		// while 반복문을 사용해 각 카드를 순회
		while (cardNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 과일의 종류와 개수를 각 변수에 할당
			String category = st.nextToken();
			int count = Integer.parseInt(st.nextToken());
			
			// getOrDefault() 및 put() 메서드를 사용해 입력 받은 과일의 종류와 개수를 fruitCounts에 저장
			fruitCounts.put(category, fruitCounts.getOrDefault(category, 0) + count);
		}
		
		// for 반복문을 사용해 각 과일의 종류를 순회
		for (String category : fruitCounts.keySet()) {
			
			// 해당 과일의 개수가 5개인 경우 한별이가 종을 쳐야 하는지 여부를 갱신 후 반복문 탈출
			if (fruitCounts.get(category) == 5) {
				shouldRing = true;
				break;
			}
		}
		
		// write() 메서드를 사용해 한별이가 종을 쳐야 하는지 여부를 출력
		out.write((shouldRing) ? "YES" : "NO");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}