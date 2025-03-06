package silver3.num22233;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 가희가 메모장에 적은 키워드의 개수
		및 가희가 블로그에 쓴 글의 개수를 각 변수에 할당 */
		int keywordNum = Integer.parseInt(st.nextToken());
		int postNum = Integer.parseInt(st.nextToken());
		
		// 메모장에 남아 있는 키워드의 개수를 저장할 변수 remains 초기화
		int remains = keywordNum;
		
		// 가희가 메모장에 적은 키워드를 저장할 Map 객체 keywords 초기화
		Map<String, Boolean> keywords = new HashMap<>();
		
		// while 반복문을 사용해 입력 받은 키워드를 keywords에 저장
		while (keywordNum-- > 0)
			keywords.put(in.readLine(), true);
		
		// while 반복문을 사용해 각 블로그에 쓴 글을 순회
		while (postNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine(), ",");
			
			// while 반복문을 사용해 해당 글과 관련한 키워드를 순회
			while (st.hasMoreTokens()) {
				
				// nextToken() 메서드를 사용해 해당 키워드를 변수 keyword에 할당
				String keyword = st.nextToken();
				
				// 해당 키워드가 메모장에 남아 있는 경우
				if (keywords.containsKey(keyword) && keywords.get(keyword)) {
					
					// replace() 메서드를 사용해 메모장에서 해당 키워드를 제거
					keywords.replace(keyword, false);
					
					// 메모장에 남아 있는 키워드의 개수를 갱신
					remains--;
				}
			}
			
			// size() 및 write() 메서드를 사용해 해당 글을 쓰고 난 후 메모장에 있는 키워드의 개수를 출력
			out.write(remains + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}