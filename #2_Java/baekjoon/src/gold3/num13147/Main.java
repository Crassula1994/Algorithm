package gold3.num13147;

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
	
	// 최대로 존재할 수 있는 난쟁이의 수를 저장할 상수 MAX_DWARF_cCOUNT
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 진술의 수를 변수 statementNum에 할당
		int statementNum = Integer.parseInt(in.readLine());
		
		// 각 난쟁이의 이름과 번호를 저장할 Map 객체 dwarves 초기화
		Map<String, Integer> dwarves = new HashMap<>();
		
		// while 반복문을 사용해 각 진술을 순회
		while (statementNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 charAt() 메서드를 사용해 진술의 각 관계 정보를 각 변수에 할당
			String dwarfA = st.nextToken();
			char sign = st.nextToken().charAt(0);
			String dwarfB = st.nextToken();
			
			
			
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}