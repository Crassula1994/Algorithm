package bronze1.num20362;

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
		
		// 각 채팅 내용별 채팅을 친 사람의 수를 저장할 Map 객체 chatCounts 초기화
		Map<String, Integer> chatCounts = new HashMap<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 채팅의 개수 및 정답자의 닉네임을 각 변수에 할당
		int chatNum = Integer.parseInt(st.nextToken());
		String winner = st.nextToken();
		
		// while 반복문을 사용해 각 채팅 기록을 순회
		while (chatNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 메서드를 사용해 해당 채팅 기록의 닉네임과 내용을 각 변수에 할당
			String nickname = st.nextToken();
			String message = st.nextToken();
			
			// 해당 채팅 기록의 닉네임이 정답자의 닉네임과 일치하는 경우 아쉬운 사람의 수를 출력 후 반복문 탈출
			if (nickname.equals(winner)) {
				out.write(String.valueOf(chatCounts.getOrDefault(message, 0)));
				break;
			}
			
			// getOrDefault() 및 put() 메서드를 사용해 해당 채팅 내용을 입력한 사람의 수를 chatCounts에 저장
			chatCounts.put(message, chatCounts.getOrDefault(message, 0) + 1);
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}