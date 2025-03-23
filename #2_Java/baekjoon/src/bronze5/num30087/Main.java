package bronze5.num30087;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

// Main 클래스 정의
public class Main {
	
	// 세미나가 열리는 교실의 정보를 저장할 Map 객체 seminars 초기화
	static Map<String, String> seminars = new HashMap<>();
	
	// put() 메서드를 사용해 세미나가 열리는 교실의 정보를 seminars에 저장
	static {
		seminars.put("Algorithm", "204");
		seminars.put("DataAnalysis", "207");
		seminars.put("ArtificialIntelligence", "302");
		seminars.put("CyberSecurity", "B101");
		seminars.put("Network", "303");
		seminars.put("Startup", "501");
		seminars.put("TestStrategy", "105");
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 진흥이가 신청한 세미나의 수를 변수 seminarNum에 할당
		int seminarNum = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 세미나를 순회
		while (seminarNum-- > 0) {
			
			// readLine(), get(), write() 메서드를 사용해 해당 세미나가 어느 교실에서 열리는지를 출력
			out.write(seminars.get(in.readLine()));
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}