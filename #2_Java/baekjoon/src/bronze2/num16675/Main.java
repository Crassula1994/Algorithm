package bronze2.num16675;

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
		
		// 이기는 경우의 수를 저장할 Map 객체 winningCase 초기화
		Map<Character, Character> winningCase = new HashMap<>();
		
		// put() 메서드를 사용해 이기는 경우의 수를 winningCase에 저장
		winningCase.put('S', 'R');
		winningCase.put('R', 'P');
		winningCase.put('P', 'S');
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 charAt() 메서드를 사용해 입력 받은 민성이와 태경이의 손의 상태를 각 변수에 할당
		char leftMS = st.nextToken().charAt(0);
		char rightMS = st.nextToken().charAt(0);
		char leftTK = st.nextToken().charAt(0);
		char rightTK = st.nextToken().charAt(0);
		
		// 민성이가 무조건 이길 수 있는 경우 'MS'를 출력
		if (leftTK == rightTK && (winningCase.get(leftTK) == leftMS
				|| winningCase.get(leftTK) == rightMS)) {
			out.write("MS");
			
		// 태경이가 무조건 이길 수 있는 경우 'TK'를 출력
		} else if (leftMS == rightMS && (winningCase.get(leftMS) == leftTK
				|| winningCase.get(leftMS) == rightTK)) {
			out.write("TK");
		
		// 누가 이길 지 확답할 수 없는 경우 '?'를 출력
		} else {
			out.write("?");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}