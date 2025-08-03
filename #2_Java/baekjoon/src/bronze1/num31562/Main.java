package bronze1.num31562;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 음을 아는 노래의 개수와 맞히기를 시도할 노래의 개수를 각 변수에 할당
		int answerNum = Integer.parseInt(st.nextToken());
		int questionNum = Integer.parseInt(st.nextToken());
		
		// 각 노래의 첫 세 음과 해당 노래의 제목을 저장할 Map 객체 songs 초기화
		Map<String, String> songs = new HashMap<>();
		
		// while 반복문을 사용해 각 음을 아는 노래의 개수를 순회
		while (answerNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 노래 제목, 첫 세 음을 각 변수에 할당
			st.nextToken();
			String title = st.nextToken();
			String headNotes = st.nextToken() + st.nextToken() + st.nextToken();
			
			// compute() 메서드를 사용해 입력 받은 노래 제목을 songs에 추가
			songs.compute(headNotes, (key, value) -> (value == null) ? title : "?");
		}
		
		// while 반복문을 사용해 맞히기를 시도할 각 노래를 순회
		while (questionNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 메서드를 사용해 입력 받은 첫 세 음을 변수 headNotes에 할당
			String headNotes = st.nextToken() + st.nextToken() + st.nextToken();
			
			// getOrDefault() 및 write() 메서드를 사용해 해당 첫 세 음에 해당하는 노래의 제목을 출력
			out.write(songs.getOrDefault(headNotes, "!"));
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}