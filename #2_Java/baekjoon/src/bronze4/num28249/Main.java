package bronze4.num28249;

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
	
	// 고추의 이름과 스코빌 지수를 저장할 각 배열 초기화
	static String[] pepperNames = {"Poblano", "Mirasol", "Serrano", "Cayenne", "Thai", "Habanero"};
	static int[] scovilleScales = {1500, 6000, 15500, 40000, 75000, 125000};
	
	// 고추의 스코빌 지수를 저장할 Map 객체 peppers 초기화
	static Map<String, Integer> peppers = new HashMap<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// for 반복문을 사용해 각 고추의 정보를 peppers에 저장
		for (int idx = 0; idx < 6; idx++)
			peppers.put(pepperNames[idx], scovilleScales[idx]);

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 고추의 수를 변수 pepperNum에 할당
		int pepperNum = Integer.parseInt(in.readLine());
		
		// 론이 만든 칠리의 매운 정도를 저장할 변수 totalScales 초기화
		int totalScales = 0;
		
		// while 반복문을 사용해 론이 만든 칠리의 매운 정도를 갱신
		while (pepperNum-- > 0)
			totalScales += peppers.get(in.readLine());
		
		// valueOf() 및 write() 메서드를 사용해 론이 만든 칠리의 매운 정도를 출력
		out.write(String.valueOf(totalScales));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}