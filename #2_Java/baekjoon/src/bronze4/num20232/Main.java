package bronze4.num20232;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 각 연도별 우승자의 정보를 저장할 배열 winners 초기화
	static String[] winners = {
		"ITMO", "SPbSU", "SPbSU", "ITMO", "ITMO",
		"SPbSU", "ITMO", "ITMO", "ITMO", "ITMO",
        "ITMO", "PetrSU, ITMO", "SPbSU", "SPbSU", "ITMO",
        "ITMO", "ITMO", "ITMO", "SPbSU", "ITMO",
        "ITMO", "ITMO", "ITMO", "SPbSU", "ITMO"
	};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine(), parseInt(), write() 메서드를 사용해 해당 연도의 우승자를 출력
		out.write(winners[Integer.parseInt(in.readLine()) - 1995]);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}