package silver4.num17219;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 사이트 주소의 수를 각 변수에 할당
		int savedSite = Integer.parseInt(st.nextToken());
		int findingSite = Integer.parseInt(st.nextToken());
		
		// 각 사이트 주소별 비밀번호를 저장할 Map 객체 passwords 초기화
		Map<String, String> passwords = new HashMap<>();

		// for 반복문을 사용해 각 사이트 주소를 순회
		for (int site = 0; site < savedSite; site++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 메서드를 사용해 입력 받은 사이트 주소와 비밀번호를 각 변수에 할당
			String address = st.nextToken();
			String password = st.nextToken();
			
			// put() 메서드를 사용해 사이트 주소와 비밀번호를 passwords에 저장
			passwords.put(address, password);
		}
		
		// for 반복문을 사용해 찾고자 하는 각 사이트 주소를 순회
		for (int site = 0; site < findingSite; site++) {
			
			// readLine() 메서드를 사용해 입력 받은 사이트 주소를 변수 address에 할당
			String address = in.readLine();
			
			// get() 및 write() 메서드를 사용해 사이트 비밀번호를 출력
			out.write(passwords.get(address) + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}