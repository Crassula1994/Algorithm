package bronze5.num27889;

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
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 학교의 약칭과 이름을 저장할 Map 객체 schoolNames 초기화
		Map<String, String> schoolNames = new HashMap<>();
		
		// put() 메서드를 사용해 각 학교의 약칭과 정식 명칭을 schoolNames에 추가
		schoolNames.put("NLCS", "North London Collegiate School");
		schoolNames.put("BHA", "Branksome Hall Asia");
		schoolNames.put("KIS", "Korea International School");
		schoolNames.put("SJA", "St. Johnsbury Academy");
		
		// readLine(), get(), write() 메서드를 사용해 입력 받은 학교의 약칭에 해당하는 정식 명칭을 출력
		out.write(schoolNames.get(in.readLine()));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}